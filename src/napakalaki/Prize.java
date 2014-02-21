package napakalaki;

/**
 * @date 21/02/2014
 * @author Mario Román
 */
public class Prize {
    private int treasures;
    private int levels;
    
    public Prize (int treasures, int levels) {
        this.treasures = treasures;
        this.levels = levels;
    }
    
    public int getTreasures() {
        return treasures;
    }
    
    public int getLevels() {
        return levels;
    }
}
