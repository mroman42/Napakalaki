package napakalaki;

import java.util.ArrayList;

/**
 * @date 19/3/14
 * @author José Carlos Entrena
 * @author Mario Román
 * @author Óscar Bermúdez
 */
public class Player {
    private final boolean dead = true;
    private String name;
    private int level;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;

    
    private void bringToLife(){}
    
    private void incrementLevels(int nlevels){
        level += nlevels; 
    }
    
    private void decrementLevels(int nlevels){
        level -= nlevels;
        
        if(level < 1)
            level = 1;
    }
    
    private void setPendingBadConsequence(BadConsequence bad){}
    
    private void die(){
        level = 1;
        
        hiddenTreasures.clear();
        visibleTreasures.clear();
        
        bringToLife();
    }
    
    private void discardNecklaceIfVisible(){
        if(visibleTreasures.contains(new ArrayList<>(Arrays.asList(TreasureKind.NECKLACE))))
            visibleTreasures.remove(new ArrayList<>(Arrays.asList(TreasureKind.NECKLACE)));
    }
    /*
-discardNecklaceIfVisible() : void
-dieIfNoTreasures() : void
-computeGoldCoinsValue(t : Treasure []) : int
-canIBuyLevels(l : float) : boolean
+applyPrize(p : Prize) : void
+combat(m : Monster) : CombatResult
+applyBadConsequence(bad : BadConsequence)
+makeTreasureVisible(t : Treasure) : boolean
+canMakeTreasureVisible(t : Treasure) : boolean
+discardVisibleTreasure(t : Treasure) : void
+discardHiddenTreasure(t : Treasure) : void
+buyLevels(visible : Treasure [], hidden : Treasure []) : boolean
+getCombatLevel() : int
+validState() : boolean
+initTreasures() : boolean
+isDead() : boolean
+hasVisibleTreasures() : boolean
+Player(name : string)
+getVisibleTreasures() : Treasure []
+getHiddenTreasures() : Treasure []*/
}
