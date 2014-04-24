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
        
        // Toma el primer jugador como jugador actual
        currentPlayerIndex = 0;
        currentPlayer = players.get(currentPlayerIndex);
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
    public CombatResult combat(){
        return currentPlayer.combat(currentMonster);
    }
    
    public void discardVisibleTreasure(Treasure t){
        currentPlayer.discardVisibleTreasure(t);
    }
    
    public void discardHiddenTreasure(Treasure t){
        currentPlayer.discardHiddenTreasure(t);
    }
    
    public boolean makeTreasureVisible(Treasure t){
        return currentPlayer.makeTreasureVisible(t);
    }
    
    // Podría tener solo un argumento? Preguntar al profesor. 
    public boolean buyLevels(ArrayList<Treasure> visible, 
            ArrayList<Treasure> hidden){
        return currentPlayer.buyLevels(visible, hidden); 
    }
    
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
    
    // Llama al método canMakeTreasureVisible del jugador actual. 
    public boolean canMakeTreasureVisible(Treasure t){
        return currentPlayer.canMakeTreasureVisible(t); 
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return currentPlayer.getVisibleTreasures(); 
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return currentPlayer.getHiddenTreasures(); 
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
    
    public boolean nextTurnAllowed(){
        return currentPlayer.validState();
    }
    
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINANDWINGAME;
    } 
}