
package Game;

import java.util.ArrayList;

/**
 * @date 19/3/14
 * @author José Carlos Entrena
 * @author Mario Román
 * @author Óscar Bermúdez
 */
class Napakalaki {
    
    private Player currentPlayer; 
    private Monster currentMonster; 
    private ArrayList<Player> players; 
    private static final Napakalaki instance = new Napakalaki();
    
    // El constructor privado asegura que no se puede instanciar desde otras clases
    
    private Napakalaki() {}
    

    
    public static Napakalaki getInstance() {
        return instance;
    }
    
    private void initPlayers(ArrayList<String> names){}
    
    private Player nextPlayer(){
        return null; 
    }
    
    // Métodos públicos. 
    
    public CombatResult combat(){
        return null; 
    }
    
    public void discardVisibleTreasure(Treasure t){}
    
    public void discradHiddenTreasure(Treasure t){}
    
    public boolean makeVisibleTreasure(Treasure t){
        return false; 
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible, 
            ArrayList<Treasure> hidden){
        return false; 
    }
    
    public void initGame(ArrayList<String> players){}
    
    public Player getCurrentPlayer(){
        return null; 
    }
    
    public Monster getCurrentMonster(){
        return null; 
    }
    
    public boolean canMakeTreasureVisible(Treasure t){
        return true; 
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return null; 
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return null; 
    }
    
    public boolean nextTurn(){
        return true; 
    }
    
    public boolean nextTurnAllowed(){
        return true;
    }
    
    public boolean endOfGame(CombatResult result){
        return true; 
    }
     
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }
}