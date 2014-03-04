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
            tHidden, ArrayList<TreasureKind> tVisible) {
        this.text = text; 
        this.levels = levels; 
        this.specificHiddenTreasures = (ArrayList<TreasureKind>) tHidden.clone(); 
        this.specificVisibleTreasures = (ArrayList<TreasureKind>) tVisible.clone(); 
        
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
    
    public boolean getDeath() {
        return death; 
    }
    
    // Métodos 
    @Override
    public String toString() {
        return "Text = " + text + "\nLevels = " + Integer.toString(levels) + 
                "\nTreasures: Hidden: " + Integer.toString(nHiddenTreasures) +
                "\n\tVisible: " + Integer.toString(nVisibleTreasures) + 
                "\nDeath: " + String.valueOf(death) + ".\n"; 
    }
}
    