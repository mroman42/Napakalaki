
package Game;

import java.util.ArrayList;


/**
 *
 * @author jose
 */
public class CultistPlayer extends Player {
    private boolean dead;
    private final String name;
    private int level;
    private BadConsequence pendingBadConsequence;
    private final ArrayList<Treasure> hiddenTreasures;
    private final ArrayList<Treasure> visibleTreasures;
    
    public void applyPrize(Prize prize){
        super.applyPrize(prize);
    }
 
    
}
