package Game;

import java.util.ArrayList;

/**
 * @date 27/02/2014
 * @author Mario Román
 * @author José Carlos Entrena
 * @author Óscar Bermúdez
 */
public class BadConsequence {
    private final String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private final ArrayList<TreasureKind> specificHiddenTreasures;
    private final ArrayList<TreasureKind> specificVisibleTreasures;

  
    // Constructores
    public BadConsequence (String text, int levels, int nVisible, int nHidden) {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        this.specificHiddenTreasures = new ArrayList();
        this.specificVisibleTreasures = new ArrayList();
    }
    
    public BadConsequence (String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden) {
        this.text = text; 
        this.levels = levels; 
        this.specificHiddenTreasures = (ArrayList<TreasureKind>) tHidden.clone();
        this.specificVisibleTreasures = (ArrayList<TreasureKind>) tVisible.clone(); 
        this.nVisibleTreasures = tVisible.size();
        this.nHiddenTreasures = tHidden.size();         
    }
    
    public BadConsequence (String text, boolean death) {
        this.text = text;
        this.death = death;
        this.specificHiddenTreasures = new ArrayList();
        this.specificVisibleTreasures = new ArrayList();
    }
    
    
    // Consultores
    public boolean isEmpty(){
        return true; 
    }
    
    public boolean kills(){
        return death; 
    }
    
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
    
    
    // Métodos públicos
    public void substractVisibleTreasure (Treasure treasure) {
    }
    
    public void substractHiddenTreasure (Treasure treasure) {
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visibles, ArrayList<Treasure> hidden){
        return null; 
    }
    
    // Métodos auxiliares
    @Override
    public String toString() {
        return text +
               "\n\t" + (death? " DEATH." : (Integer.toString(levels) + " levels, " +
               Integer.toString(nHiddenTreasures) + " hidden treasures, " +
               Integer.toString(nVisibleTreasures) + " visible treasures.")) + "\n"; 
    }
}
    
