
package Game;

import java.util.ArrayList;


/**
 *
 * @author Mario Román
 * @author José Carlos Entrena
 * @author Óscar Bermúdez
 */
public class CultistPlayer extends Player {
    
    private static int totalCultistPlayers = 0; 
    private Cultist myCultistCard; 
    
    public CultistPlayer(Player player, Cultist card){
        super(player); 
        myCultistCard = card;    
        totalCultistPlayers++; 
    }
    
    public void applyPrize(Prize prize){
        super.applyPrize(prize);
    }
    
    public int computeGoldCoinsValue(ArrayList<Treasure> treasure_list){
        int gold_coins = 0; 
        for (Treasure t : treasure_list)
            gold_coins += (t.getGoldCoins()*2); 
        return (gold_coins / 1000); 
    }
    
    public boolean shouldConvert(){
        return false; 
    }
    
    public int getOponentLevel(Monster monster){
        return monster.getSpecialValue(); 
    }
    
    public int getCombatLevel(){
        return super.getCombatLevel() + myCultistCard.getSpecialValue(); 
    }
 
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers; 
    }
    
}
