package Game;

import static java.lang.Math.min;
import java.util.ArrayList;

/**
 * @date 19/3/14
 * @author José Carlos Entrena
 * @author Mario Román
 * @author Óscar Bermúdez
 */
public class Player {
    // Atributos.
    private boolean dead;
    private final String name;
    private int level;
    private BadConsequence pendingBadConsequence;
    private final ArrayList<Treasure> hiddenTreasures;
    private final ArrayList<Treasure> visibleTreasures;

    // Constructor.
    public Player(String name) {
        dead = true;
        this.name = name;
        pendingBadConsequence = new BadConsequence("",0,0,0);
        hiddenTreasures = new ArrayList<>();
        visibleTreasures = new ArrayList<>();

        initTreasures();
    }
    
    
    // Métodos privados.
    
    private void bringToLife(){
        dead = false;
        level = 1;
    }
    
    private void incrementLevels(int nlevels){
        level += nlevels; 
    }
    
    private void decrementLevels(int nlevels){
        level -= nlevels;
        
        if(level < 1)
            level = 1;
    }
    
    private void setPendingBadConsequence(BadConsequence bad){
        pendingBadConsequence = bad;
    }
    
    /**
     * @brief Método para matar a un jugador. Devuelve los tesoros al mazo, 
     * los elimina y pone su estado a muerto. 
     */
    private void die(){
        for (Treasure treasure : hiddenTreasures){
            CardDealer.getInstance().giveTreasureBack(treasure);
        }
        hiddenTreasures.clear();
        for (Treasure treasure : visibleTreasures){
            CardDealer.getInstance().giveTreasureBack(treasure);
        }
        visibleTreasures.clear();

        dead = true;
    }
    
    /** 
     * @brief Busca el tesoro de tipo collar, y si lo encuentra, lo elimina. 
     */
    private void discardNecklaceIfVisible() {
        
        for (Treasure t : visibleTreasures){
            if (t.getType() == TreasureKind.NECKLACE){
                CardDealer.getInstance().giveTreasureBack(t);
                visibleTreasures.remove(t);
            }
        }
    }	
    
    /**
     * @brief Mata al jugador si no le queda ningún tesoro, visible u oculto.   
     */
    private void dieIfNoTreasures(){
        if (visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            dead = true; 
    }
    
    /**
     * @brief Devuelve el número de niveles que podemos comprar con unos determinados tesoros. 
     * @param treasure_list Lista de tesoros. 
     * @return Numero de niveles. 
     */
    private int computeGoldCoinsValue(ArrayList<Treasure> treasure_list){
        int gold_coins = 0; 
        for (Treasure t : treasure_list)
            gold_coins += t.getGoldCoins(); 
        return (gold_coins / 1000); 
    }
    
    /**
     * Comprueba si al comprar un número de niveles, no se supera el nivel 10.
     * Hacemos esto porque no podemos alcanzar el nivel 10 en una compra de niveles. 
     */
    private boolean canIBuyLevels(int levels){
        return (this.level + levels < 10); 
    }
    
    
    // Métodos públicos
    
    /**
     * @brief Aplica el buen rollo pasado como parámetro. 
     * @param prize Buen rollo a aplicar. 
     */ 
    public void applyPrize(Prize prize){
        int nLevels = prize.getLevels(); 
        incrementLevels(nLevels); 
        int nPrize = prize.getTreasures(); 
        int min = min(nPrize, 4-hiddenTreasures.size());
        for (int i = 0; i < min; i++){
            Treasure treasure = CardDealer.getInstance().nextTreasure(); 
            hiddenTreasures.add(treasure); 
        }
    }
    /**
     * @brief Combate contra un monstruo. Analiza todas las posibilidades.  
     * @param monster Monstruo al que se enfrenta.
     * @return Resultado del combate
     */
    public CombatResult combat(Monster monster){
        int total_level = this.getCombatLevel();
        int monster_level = monster.getLevel(); 
        CombatResult result;
        // Si ganamos el combate. 
        if (total_level > monster_level){
            Prize prize = monster.getPrize(); 
            applyPrize(prize); 
            if (this.level >= 10)
                result = CombatResult.WINANDWINGAME;
            else
                result = CombatResult.WIN;
        }
        // Si perdemos el combate, podemos escapar o no. 
        else {
        // Tiramos el dado.
            int escape = Dice.getInstance().nextNumber(); 
        // No escapamos. 
            if (escape < 5){
                BadConsequence bad = monster.getBadConsequence();
                
                if (bad.kills()){
                    die(); 
                    result = CombatResult.LOSEANDDIE;
                }
                else{
                    applyBadConsequence(bad); 
                    result = CombatResult.LOSE; 
                }
            }
        // Escapamos.
            else
                result = CombatResult.LOSEANDESCAPE; 
        }
        discardNecklaceIfVisible(); 

        return result;
    }
    
    /**
     * @brief Resta los niveles precisados por el mal rollo, y lo ajusta para que podamos
     * proceder a eliminar tesoros de forma manual. 
     * @param bad Mal rollo. 
     */
    public void applyBadConsequence(BadConsequence bad){
        decrementLevels(bad.getLevels());
        setPendingBadConsequence(bad.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures)); 
    }
    
    /**
     * @brief Hace visible un tesoro, comprobando previamente si puede hacerse. 
     * @param treasure Tesoro a hacer visible. 
     * @return Valor booleano, que nos dice si el tesoro se ha hecho visible. 
     */
    public boolean makeTreasureVisible(Treasure treasure){
        if (canMakeTreasureVisible(treasure)){
            visibleTreasures.add(treasure); 
            hiddenTreasures.remove(treasure); 
            return true; 
        }
        else
            return false;       
    }
    
    /**
     * @brief Comprueba si un tesoro puede hacerse visible, según las reglas del juego. 
     * @param treasure Tesoro a comprobar. 
     * @return Valor booleano que nos dice si se puede hacer visible. 
     */
    public boolean canMakeTreasureVisible(Treasure treasure){
        TreasureKind type = treasure.getType(); 
        // Si es un collar, se puede hacer visible. 
        if (type == TreasureKind.NECKLACE)
            return true; 
        
        // Si no es de mano(una o dos), se puede hacer visible si no hay otro del mismo tipo. 
        else if (type != TreasureKind.ONEHAND && type != TreasureKind.BOTHHANDS){
            boolean has_one = false; 
            for (Treasure t : visibleTreasures){
                if (t.getType() == type)
                    has_one = true; 
            }
            return !has_one; 
        }
        // Si es de una mano, puede hacerse visible si no hay de dos manos y hay menos de dos de una mano.
        else if (type == TreasureKind.ONEHAND){
            int number_of_onehands = 0; 
            boolean has_bothhands = false; 
            for (Treasure t : visibleTreasures){
                if(t.getType() == TreasureKind.ONEHAND)
                    number_of_onehands++;
                else if (t.getType() == TreasureKind.BOTHHANDS)
                    has_bothhands = true; 
            }
            return (!has_bothhands && number_of_onehands < 2); 
        }    
        // Si es de dos manos, puede hacerse visible si no hay nada en las manos. 
        else{
            boolean has_bothhands = false; 
            boolean has_onehands = false; 
            for (Treasure t : visibleTreasures){
                if(t.getType() == TreasureKind.ONEHAND)
                    has_onehands = true;
                else if (t.getType() == TreasureKind.BOTHHANDS)
                    has_bothhands = true; 
            }
            return (!has_bothhands && !has_onehands);
        }
    }
    
    /**
     * @brief Elimina un tesoro visible. En caso de que haya un mal rollo pendiente, lo elimina de él.
     * @param treasure Tesoro a eliminar. 
     */
    public void discardVisibleTreasure(Treasure treasure){
        visibleTreasures.remove(treasure);
        
        if (pendingBadConsequence!=null && !pendingBadConsequence.isEmpty())
            pendingBadConsequence.substractVisibleTreasure(treasure);
        
        CardDealer.getInstance().giveTreasureBack(treasure); 
        dieIfNoTreasures(); 
    }

    /**
     * @brief Elimina un tesoro oculto. En caso de que haya un mal rollo pendiente, lo elimina de él.
     * @param treasure Tesoro a eliminar. 
     */
    public void discardHiddenTreasure(Treasure treasure){
        hiddenTreasures.remove(treasure);
        if (pendingBadConsequence!=null && !pendingBadConsequence.isEmpty())
            pendingBadConsequence.substractHiddenTreasure(treasure);
        CardDealer.getInstance().giveTreasureBack(treasure); 
        dieIfNoTreasures(); 
    }
    
    /**
     * @brief Compra niveles a partir de una lista de tesoros, si el juego nos lo permite. 
     * IMPORTANTE: Aunque se llama al método discardVisibleTreasure(), que actúa sobre 
     * pendingBadConsequence, no interfiere en el mal rollo ya que este aún no ha aparecido.
     * @param visible Lista de tesoros visibles. 
     * @param hidden Lista de tesoros ocultos. 
     * @return Compra realizada. 
     */
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        // Aunque se computen por separado, los posibles errores originados se obviarán. 
        int levels = computeGoldCoinsValue(visible) + computeGoldCoinsValue(hidden);
         
        if (canIBuyLevels(levels)){
            incrementLevels(levels); 

            for(Treasure treasure : visible)
                discardVisibleTreasure(treasure);
            for (Treasure treasure : hidden)
                discardHiddenTreasure(treasure); 
            
            return true;
        }
        
        return false;
    }
    
    /**
     * @brief Calcula el nivel de combate del jugados a partir de una lista de tesoros visibles. 
     * @return Nivel de combate. 
     */
    public int getCombatLevel(){
        int combat_level = level;
        boolean has_necklace = false;
        
        for (Treasure treasure : visibleTreasures){
            if(treasure.getType() == TreasureKind.NECKLACE){
                has_necklace = true;
            }
        }
         
        for (Treasure treasure : visibleTreasures){
            if (has_necklace)
                combat_level += treasure.getMaxBonus();
            else
                combat_level += treasure.getMinBonus();
            
        }
        
        return combat_level;
    }
    
    /**
     * Comprueba que el estado del jugador es válido. 
     * Para ello, comprueba que el BadConsequence asociado esté vacío. 
     * @return Validez del estado.
     */
    public boolean validState(){
        return pendingBadConsequence.isEmpty();
    }
    
    /**
     * @brief Inicializa los tesoros de un jugador, dependiendo del número sacado al tirar del dado.
     */
    public void initTreasures(){
        bringToLife();
        int number = Dice.getInstance().nextNumber(); 
        
        if (number == 1){
            hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
        }
        else if (number == 6){
            for (int i = 0; i < 3; i++)
                hiddenTreasures.add(CardDealer.getInstance().nextTreasure()); 
        }
        else{
            for (int i = 0; i < 2; i++)
                hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
        }
    }
    
    public boolean isDead(){
        return dead;
    }
    
    public boolean hasVisibleTreasures(){
        return !visibleTreasures.isEmpty();
    }

    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }

    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }
    
    @Override
    public String toString() {
        return name + ", con nivel " + level;
    }
}
