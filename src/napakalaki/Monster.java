package napakalaki;

/**
 * @date 27/02/14
 * @author Mario Román
 * @author José Carlos Entrena
 */
public class Monster {
    private final String name;
    private final int level;
    private final BadConsequence bad; 
    private final Prize price; 
    
    // Constructores
    public Monster(String name, int level, BadConsequence bad, Prize price){
        this.name = name; 
        this.level = level; 
        this.bad = bad; 
        this.price = price; 
    }
    
    // Consultores
    public String getName() {
        return name; 
    }
    
    public int getLevel() {
        return level; 
    }
    
    // Métodos
    @Override
    public String toString() {
        return "Name = " + name + "\nLevel = " + Integer.toString(level) + 
                "\nBad: " + bad.toString() + "\nPrize: " + price.toString()
                + ".\n";
    }
    
}
