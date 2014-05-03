package Game;

import static java.lang.Math.min;
import java.util.ArrayList;
import java.util.Arrays;

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
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;

    // Constructor.
    public Player(String name) {
        dead = true;
        this.name = name;
        level = 1; //¿Necesario? Lo hace bringToLife
        pendingBadConsequence = new BadConsequence("",0,0,0);
        hiddenTreasures = new ArrayList<Treasure>();
        visibleTreasures = new ArrayList<Treasure>();

        bringToLife();
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
    
    private void discardNecklaceIfVisible() {
        
        int position = 0;
        int size = visibleTreasures.size();
        boolean found = false;
        
        while (!found || position == size){
           if (visibleTreasures.get(position).getType() != TreasureKind.NECKLACE)
               position++; 
           else 
               found = true; 
        }
        
        if (found){
            CardDealer.getInstance().giveTreasureBack(visibleTreasures.get(position));
            visibleTreasures.remove(position); 		
        }
    }	
    
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
    public void applyPrize(Prize prize){
        int nLevels = prize.getLevels(); 
        incrementLevels(nLevels); 
        int nPrize = prize.getTreasures(); 
        for (int i = 0; i < min(nPrize, 4-hiddenTreasures.size()); i++){
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
            result = CombatResult.WIN;
            Prize prize = monster.getPrize(); 
            applyPrize(prize); 
            if (this.level >= 10)
                result = CombatResult.WINANDWINGAME;
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
        CardDealer.getInstance().giveMonsterBack(monster);
        return result;
    }
        
    public void applyBadConsequence(BadConsequence bad){
        int nlevels = bad.getLevels();
        decrementLevels(nlevels); 
        BadConsequence pendingBad = bad.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures); 
        setPendingBadConsequence(pendingBad); 
    }
    
    public boolean makeTreasureVisible(Treasure treasure){
        if (canMakeTreasureVisible(treasure)){
            visibleTreasures.add(treasure); 
            hiddenTreasures.remove(treasure); 
            return true; 
        }
        else
            return false;       
    }
    
    public boolean canMakeTreasureVisible(Treasure treasure){
        TreasureKind type = treasure.getType(); 
        // Si es un collar, se puede hacer visible. 
        if (type == TreasureKind.NECKLACE)
            return true; 
        
        // Si no es de una mano, comprobamos si ya tiene uno visible. 
        else if (type != TreasureKind.ONEHAND){
            boolean has_item = false; 
            for (Treasure t : visibleTreasures){
                if(t.getType() == type)
                    has_item = true;
            }
            return !has_item; 
        }
        // Si es de una mano, comprobamos si hay dos visibles.
        else{
            int number_of_onehands = 0; 
            for (Treasure t : visibleTreasures){
                if(t.getType() == TreasureKind.ONEHAND)
                    number_of_onehands++;
            }
            return (number_of_onehands < 2); 
        }       
    }
    
    public void discardVisibleTreasure(Treasure treasure){
        visibleTreasures.remove(treasure);
        if (pendingBadConsequence!=null && !pendingBadConsequence.isEmpty())
            pendingBadConsequence.substractVisibleTreasure(treasure);
        CardDealer.getInstance().giveTreasureBack(treasure); 
        dieIfNoTreasures(); 
    }

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
     * pendingBadConsequence, no interfiere en el mal rollo ya que este aun no ha aparecido.
     * @param visible Lista de tesoros visibles. 
     * @param hidden Lista de tesoros ocultos. 
     * @return Compra realizada. 
     */
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        // Aunque se computen por separado, los posibles errores originados se obviarán. 
        int levels = computeGoldCoinsValue(visible); 
        levels += computeGoldCoinsValue(hidden);
        // No me gusta tener variables "canis" XD
        // No me gusta tener comentarios fútiles 
        boolean canI = canIBuyLevels(levels); 
        if (canI){
            incrementLevels(levels); 
            for(Treasure treasure : visible)
                discardVisibleTreasure(treasure); 
            for (Treasure treasure : hidden)
                discardHiddenTreasure(treasure); 
        }
        return canI;
    }
    
    public int getCombatLevel(){
        int combat_level = level;
        boolean has_necklace = false; 
        
        // Revisar este bucle: puede haber una mejor forma. 
        for (Treasure treasure : visibleTreasures){
            if(treasure.getType() == TreasureKind.NECKLACE)
                has_necklace = true; 
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
    // Mirar como se imprime un tesoro. 
    public String toString() {
        return name +
               "\n\t" + " Lv: " + Integer.toString(level) + 
               hiddenTreasures + " hidden treasures, " +
               visibleTreasures + " visible treasures." + "\n"; 
    }
}
