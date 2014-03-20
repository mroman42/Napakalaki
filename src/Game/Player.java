package Game;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @date 19/3/14
 * @author José Carlos Entrena
 * @author Mario Román
 * @author Óscar Bermúdez
 */
public class Player {
    private boolean dead;
    private String name;
    private int level;
    private BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;

    
    private void bringToLife(){
        dead = false;
        level = 1;
    }
    
    private void incrementLevels(int nlevels){
        level += nlevels; 
    }
    
    private void decrementLevels(int nlevels){
        level -= nlevels;
        
        if(level < 1)
            level = 1;
    }
    
    private void setPendingBadConsequence(BadConsequence bad){
        pendingBadConsequence = bad;
    }
    
    private void die(){
        hiddenTreasures.clear();
        visibleTreasures.clear();
        
        dead = true;
        
        bringToLife();
    }
    
    private void discardNecklaceIfVisible(){
        if(visibleTreasures.contains(new ArrayList<>(Arrays.asList(TreasureKind.NECKLACE))))
            visibleTreasures.remove(new ArrayList<>(Arrays.asList(TreasureKind.NECKLACE)));
    }
    
    private void dieIfNoTreasures(){
        if (visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            die();
    }
    
    private int computeGoldCoinsValue(Treasure treasure){
        return treasure.getGoldCoins();
    }
    
    private boolean canIBuyLevels(int levels){
        return false;
    }
    
    public void applyPrize(Prize prize){
        this.incrementLevels(prize.getLevels());
    }
    
    public CombatResult combat(Monster monster){
        return null;
    }
    
    public void applyBadConsequence(BadConsequence bad){
    }
    
    public boolean makeTreasureVisible(Treasure treasure){
        return false;
    }
    
    public boolean canMakeTreasureVisible(Treasure treasure){
        return false;
    }
    
    public void discardVisibleTreasure(Treasure treasure){
        visibleTreasures.remove(new ArrayList<>(Arrays.asList(treasure.getType())));
    }

    public void discardHiddenTreasure(Treasure treasure){
        hiddenTreasures.remove(new ArrayList<>(Arrays.asList(treasure.getType())));
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        return canIBuyLevels();
    }
    
    public int getCombatLevel(){
        return 0;
    }
    
    public boolean validState(){
        return false;
    }
    
    public boolean initTreasure(){
        return false;
    }
    
    public boolean isDead(){
        return dead;
    }
    
    public boolean hasVisibleTreasures(){
        return false;
    }
    
    public Player(String name) {
        this.name = name;
        bringToLife();
    }    

    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }

    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }

    private boolean canIBuyLevels() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
