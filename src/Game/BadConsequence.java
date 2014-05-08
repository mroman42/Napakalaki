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
        this.nHiddenTreasures = 0; 
        this.nVisibleTreasures = 0; 
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
    // En los siguientes dos métodos, hay que usar que hay dos posibles BadConsequence que trabajan con tesoros, los que conocen los objetos que quitan y los que sólo conocen la cantidad.
    // Para saber si un tesoro está contenido, tenemos que ver si está en la lista de tesoros(conoce los tesoros) o está vacía pero la cantidad de tesoros que quita no es nula(no conoce los tesoros)

    public void substractVisibleTreasure (Treasure treasure) {
        if(specificVisibleTreasures.remove(treasure) || (specificVisibleTreasures.isEmpty() && nVisibleTreasures != 0))
            nVisibleTreasures--;
    }
    
    public void substractHiddenTreasure (Treasure treasure) {
        if(specificHiddenTreasures.remove(treasure) || (specificHiddenTreasures.isEmpty()) && nHiddenTreasures != 0)
            nHiddenTreasures--;
    }
    
    // En este método, se usan los tres BadConsequence: 
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visibles, ArrayList<Treasure> hidden){
        BadConsequence adjustedBC = null;
        
    //    ·si es mortal, es mortal.
        if(death){
            adjustedBC = new BadConsequence(text, death);
        }
        else{
            int nVTreasures;
            int nHTreasures;
            final ArrayList<TreasureKind> listHiddenTreasures = null;
            final ArrayList<TreasureKind> listVisibleTreasures = null;

    //    ·si no conoce los tesoros(o no hay), trabaja con las cantidades(no puedes quitar más tesoros de los que tiene).
            if(specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty()){
                nVTreasures = (visibles.size() > nVisibleTreasures? nVisibleTreasures : visibles.size());
                nHTreasures = (hidden.size() > nHiddenTreasures? nHiddenTreasures : hidden.size());
                
                adjustedBC = new BadConsequence(text, levels, nVTreasures, nHTreasures);
            }
    //    ·si conoce los tesoros, trabaja con los tesoros(no puedes quitar los tesoros que no tiene)
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
    
