package Game;

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

    public TreasureKind getType() {
        return type;
    }
    // Métodos auxiliares
    @Override
    public String toString() {
        String tipo;
        
        switch (type) {
            case ARMOR: {
                tipo = "Armadura";
                break;
            }
            case BOTHHANDS: {
                tipo = "Arma de dos manos";
                break;
            }
            case ONEHAND: {
                tipo = "Arma de una mano";
                break;
            }
            case SHOE: {
                tipo = "Calzado";
                break;
            }
            case HELMET: {
                tipo = "Casco";
                break;
            }
            case NECKLACE: {
                tipo = "Collar";
                break;
            }
            default: {
                tipo = "ERROR";
                break;
            }
        }

        return name + "  (" + tipo + ") [+" + minBonus + ",++" + maxBonus + "] (" + goldCoins + "$)";
    }
}

