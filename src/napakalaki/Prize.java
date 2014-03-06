package napakalaki;

/**
 * @date 27/02/2014
 * @author Mario Román
 * @author José Carlos Entrena
 */
public class Prize {
    private final int treasures;
    private final int levels;
    
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
        return Integer.toString(treasures) + " treasures and "   + 
               Integer.toString(levels)    + " levels.";
    }
}
