package Game;

/**
 * @date 19/3/14
 * @author José Carlos Entrena
 * @author Mario Román
 * @author Óscar Bermúdez
 */
public class Treasure implements Card {
    private final String name;
    private final int goldCoins;
    private final int minBonus;
    private final int maxBonus;
    private final TreasureKind type;

    // Constructor
    public Treasure(String name, int goldCoins, int minBonus, int maxBonus, TreasureKind type) {
        this.name = name;
        this.goldCoins = goldCoins;
        this.minBonus = minBonus;
        this.maxBonus = maxBonus;
        this.type = type;
    }

    // Consultores
    public String getName() {
        return name;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public int getMinBonus() {
        return minBonus;
    }

    public int getMaxBonus() {
        return maxBonus;
    }
    
    @Override
    public int getBasicValue() {
        return getMinBonus();
    }

    @Override
    public int getSpecialValue() {
        return getMaxBonus();
    }
    
    public TreasureKind getType() {
        return type;
    }
    // Métodos auxiliares
    @Override
    public String toString() {
        String tipo = type.toString();        

        return name + "  (" + tipo + ") [+" + minBonus + ",++" + maxBonus + "] (" + goldCoins + "$)";
    }
}

