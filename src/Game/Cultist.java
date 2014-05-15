package Game;

/**
 * @date 15/5/14
 * @author José Carlos Entrena
 * @author Mario Román
 * @author Óscar Bermúdez
 */
public class Cultist implements Card{
    private final int gainedLevels;
    private final String name;
    
    Cultist (String name, int gainedLevels) {
        this.name = name;
        this.gainedLevels = gainedLevels;
    }
    
    public int getGainedLevels () {
        return gainedLevels;
    }
    
    public String getName () {
        return name;
    }
    
    @Override
    public int getBasicValue(){
        return getGainedLevels(); 
    }
    
    @Override 
    public int getSpecialValue(){
        return getBasicValue() * CultistPlayer.getTotalCultistPlayers(); 
    }
}
