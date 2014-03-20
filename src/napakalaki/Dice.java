package napakalaki;

/**
 * @date 19/3/14
 * @author José Carlos Entrena
 * @author Mario Román
 * @author Óscar Bermúdez
 */
public class Dice {
    private static final Dice instance = new Dice();
    
    // El constructor privado asegura que no se puede instanciar
    // desde otras clases
    private Dice() {}
    
    public static Dice getInstance() {
        return instance;
    }
    
    public int nextNumber(){return 0;}
}
