    package Game;

/**
 * @date 27/02/14
 * @author Mario Román
 * @author José Carlos Entrena
 * @author Óscar Bermúdez
 */
public class Monster implements Card {
    private final String name;
    private final int level;
    private final BadConsequence bad; 
    private final Prize prize;
    private final int levelChangeAgainstCultistPlayer;

    public Monster(String name, int level, BadConsequence bad, Prize prize, int levelChangeAgainstCultistPlayer) {
        this.name = name;
        this.level = level;
        this.bad = bad;
        this.prize = prize;
        this.levelChangeAgainstCultistPlayer = levelChangeAgainstCultistPlayer;
    }
    
    public Monster(String name, int level, BadConsequence bad, Prize prize) {
        this(name, level, bad, prize, 0);
    }
    
    // Consultores
    public String getName() {
        return name; 
    }

    public int getLevelChangeAgainstCultistPlayer() {
        return levelChangeAgainstCultistPlayer;
    }
    
    public int getLevel() {
        return level; 
    }

    public Prize getPrize() {
        return prize;
    }

    public BadConsequence getBadConsequence() {
        return bad;
    }

    @Override
    public int getBasicValue () {
        return getLevel();
    }
    
    @Override
    public int getSpecialValue () {
        return getLevel() + levelChangeAgainstCultistPlayer;
    }
    
    // Métodos auxiliares
    @Override
    public String toString() {
        return name + " (lv. " + Integer.toString(level) + ")" + 
               "\nBuen rollo: " + prize.toString() + 
               "\nMal rollo: " + bad.toString() + 
               "\n";
    }
}
