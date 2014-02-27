package napakalaki;

/**
 * @date 27/02/2014
 * @author Mario Román
 * @author José Carlos Entrena
 */
public class Prize {
    private int treasures;
    private int levels;
    
    // Constructores
    public Prize (int treasures, int levels) {
        this.treasures = treasures;
        this.levels = levels;
    }
    
    // Consultores
    public int getTreasures() {
        return treasures;
    }
    
    public int getLevels() {
        return levels;
    }
    
    // Métodos
    @Override
    public String toString() {
        return "Treasures = " + Integer.toString(treasures) + 
               "\nLevels = " + Integer.toString(levels) + ".\n";
    }
}
