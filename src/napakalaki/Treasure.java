package napakalaki;

/**
 * @date 19/3/14
 * @author José Carlos Entrena
 * @author Mario Román
 * @author Óscar Bermúdez
 */
public class Treasure {
    private final String name;
    private final int goldCoins;
    private final int minBonus;
    private final int maxBonus;
    private TreasureKind type;

    public Treasure(String name, int goldCoins, int minBonus, int maxBonus, TreasureKind type) {
        this.name = name;
        this.goldCoins = goldCoins;
        this.minBonus = minBonus;
        this.maxBonus = maxBonus;
        this.type = type;
    }

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

    public TreasureKind getType() {
        return type;
    }
}
