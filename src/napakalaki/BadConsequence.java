package napakalaki;

import java.util.ArrayList;

/**
 * @date 27/02/2014
 * @author Mario Román
 * @author José Carlos Entrena
 */
public class BadConsequence {
    private final String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;

  
    // Constructores
    public BadConsequence (String text, int levels, int nVisible, int nHidden) {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
    public BadConsequence (String text, boolean death) {
        this.text = text;
        this.death = death;
    }
    
    public BadConsequence (String text, int levels, ArrayList<TreasureKind>
            tVisible, ArrayList<TreasureKind> tHidden) {
        this.text = text; 
        this.levels = levels; 
        this.specificHiddenTreasures = (ArrayList<TreasureKind>) tHidden.clone();
        this.specificVisibleTreasures = (ArrayList<TreasureKind>) tVisible.clone(); 
        this.nVisibleTreasures = tVisible.size();
        this.nHiddenTreasures = tHidden.size();         
    }
    
    // Consultores
    public String getText() {
        return text; 
    }
    
    public int getLevels() {
        return levels; 
    }
    
    public int getnHiddenTreasures() {
        return nHiddenTreasures; 
    }
    
    public int getnVisibleTreasures() {
        return nVisibleTreasures; 
    }

    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
    public boolean getDeath() {
        return death; 
    }
    
    // Métodos 
    @Override
    public String toString() {
        return text +
               "\n\t" + (death? " DEATH." : (Integer.toString(levels) + " levels, " +
               Integer.toString(nHiddenTreasures) + " hidden treasures, " +
               Integer.toString(nVisibleTreasures) + " visible treasures.")) + "\n"; 
    }
}
    