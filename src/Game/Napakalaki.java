package Game;

import java.util.ArrayList;

/**
 * @date 19/3/14
 * @author José Carlos Entrena
 * @author Mario Román
 * @author Óscar Bermúdez
 */
public class Napakalaki {
    // Atributos
    private static final Napakalaki instance = new Napakalaki();
    private Player currentPlayer;
    private int currentPlayerIndex;
    private Monster currentMonster; 
    private ArrayList<Player> players; 
    
    
    // Patrón Singleton.
    // El constructor privado asegura que no se puede instanciar desde otras clases
    private Napakalaki() {
        currentPlayer = null;
        currentMonster = null;
    }
    
    public static Napakalaki getInstance() {
        return instance;
    }
    
    
    // Métodos privados
    /**
     * @brief Inicia los jugadores a partir de los nombres y toma el primero como actual. 
     * @param names Nombres de los jugadores. 
     */
    private void initPlayers(ArrayList<String> names){
        // Inicializa jugadores
        players = new ArrayList<>();
        for (String name : names)
            players.add(new Player(name));
        
        // Toma el índice del primer jugador como -1. 
        // Así, cuando iniciemos el juego y hagamos nextTurn(), el primer jugador en jugar será el primero.
        currentPlayerIndex = -1;
    }
    
    /**
     * @brief Pasa al siguiente jugador.
     * @return Siguiente jugador. 
     */
    private Player nextPlayer(){
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();        
        currentPlayer = players.get(currentPlayerIndex);
        return currentPlayer;
    }
    
    // Métodos públicos.
    // Los siguientes métodos llaman al correspondiente en el jugador actual. 
    public CombatResult combat(){
        CombatResult result = currentPlayer.combat(currentMonster);
        CardDealer.getInstance().giveMonsterBack(currentMonster);

        return result;
    }
    
    public void discardVisibleTreasure(Treasure treasure){
        currentPlayer.discardVisibleTreasure(treasure);
    }
    
    public void discardHiddenTreasure(Treasure treasure){
        currentPlayer.discardHiddenTreasure(treasure);
    }
    
    public boolean makeTreasureVisible(Treasure treasure){
        return currentPlayer.makeTreasureVisible(treasure);
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible, 
            ArrayList<Treasure> hidden){
        return currentPlayer.buyLevels(visible, hidden); 
    }
    
    public boolean canMakeTreasureVisible(Treasure treasure){
        return currentPlayer.canMakeTreasureVisible(treasure); 
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return currentPlayer.getVisibleTreasures(); 
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return currentPlayer.getHiddenTreasures(); 
    }
    
    /**
     * @brief Inicia el juego. 
     * @param names Nombres de los jugadores. 
     */
    public void initGame(ArrayList<String> names){
        CardDealer.getInstance().initCards();
        initPlayers(names);
        nextTurn();
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer; 
    }
    
    public Monster getCurrentMonster(){
        return currentMonster; 
    }
    
    /** 
     * @brief Pasa al siguiente turno si el estado es válido. 
     * @brief Si el siguiente jugador está muerto, llama a initTreasures()
     */
    public boolean nextTurn(){
        boolean stateOK = nextTurnAllowed();
        
        if (stateOK) {
            currentMonster = CardDealer.getInstance().nextMonster();
            currentPlayer  = nextPlayer();
            
            if (currentPlayer.isDead())
                currentPlayer.initTreasures();
        }
        
        return stateOK;
    }
    
    /**
     * @brief Comprueba si el estado del jugador es apto para pasar de turno. 
     * @return Valor booleano indicando si podemos pasar de turno. 
     */
    public boolean nextTurnAllowed(){
        return currentPlayer.validState();
    }
    
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINANDWINGAME;
    } 
}