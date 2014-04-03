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
        return (death == false && levels == 0 && nVisibleTreasures == 0 && nHiddenTreasures == 0); 
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
        if(specificVisibleTreasures.contains(treasure) || (specificVisibleTreasures.isEmpty() && nVisibleTreasures != 0)){
            specificVisibleTreasures.remove(treasure);
            nVisibleTreasures--;
        }
    }
    
    public void substractHiddenTreasure (Treasure treasure) {
        if(specificHiddenTreasures.contains(treasure) || (specificHiddenTreasures.isEmpty()) && nHiddenTreasures != 0){
            specificHiddenTreasures.remove(treasure);
            nHiddenTreasures--;
        }
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visibles, ArrayList<Treasure> hidden){
        BadConsequence adjustedBC = null;
        
        if(death){
            adjustedBC = new BadConsequence(text, death);
        }
        else{
            int nVTreasures;
            int nHTreasures;
            final ArrayList<TreasureKind> listHiddenTreasures = null;
            final ArrayList<TreasureKind> listVisibleTreasures = null;

            //Si las dos son vacías, o no especifica los tesoros, o no quita tesoros
            if(specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty()){
                nVTreasures = (visibles.size() > nVisibleTreasures? nVisibleTreasures : visibles.size());
                nHTreasures = (hidden.size() > nHiddenTreasures? nHiddenTreasures : hidden.size());
                
                adjustedBC = new BadConsequence(text, levels, nVTreasures, nHTreasures);
            }
            else{
                for(TreasureKind object : specificVisibleTreasures)
                    if(visibles.contains(object))
                        listVisibleTreasures.add(object);
        
                for(TreasureKind object : specificHiddenTreasures)
                    if(hidden.contains(object))
                        listHiddenTreasures.add(object);

                adjustedBC = new BadConsequence(text, levels, listVisibleTreasures, listHiddenTreasures);
            }
        }
        
        return adjustedBC;
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
    
