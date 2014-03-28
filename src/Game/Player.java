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
    // Atributos.
    private boolean dead;
    private final String name;
    private int level;
    private BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;

    // Constructor.
    public Player(String name) {
        this.dead = true;
        this.name = name;
        bringToLife();
    }
    
    
    // Métodos privados.
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
    
    
    // Métodos públicos
    public void applyPrize(Prize prize){
        incrementLevels(prize.getLevels());
    }
    
    public CombatResult combat(Monster monster){
        int total_level = this.getCombatLevel();
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
        visibleTreasures.remove(treasure.getType());
    }

    public void discardHiddenTreasure(Treasure treasure){
        hiddenTreasures.remove(treasure.getType());
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        return canIBuyLevels(1);
    }
    
    public int getCombatLevel(){
        int combat_level = level;
        
        for (Treasure treasure : visibleTreasures){
            if(visibleTreasures.contains(TreasureKind.NECKLACE)){
                combat_level += treasure.getMaxBonus();
            }
            else{
                combat_level += treasure.getMinBonus();
            }
        }
        return combat_level;
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
        return visibleTreasures.isEmpty();
    }

    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }

    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }
}
