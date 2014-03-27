package Game;
import java.util.Random;

/**
 * @date 19/3/14
 * @author José Carlos Entrena
 * @author Mario Román
 * @author Óscar Bermúdez
 */
public class Dice {
    private static final Dice instance = new Dice();
    private static Random randomGenerator = new Random();
    
    // Patrón Singleton.
    // El constructor privado asegura que no se puede instanciar externamente.
    private Dice() {
        Dice.randomGenerator = new Random();
    }
    
    // Existe una sola instancia.
    public static Dice getInstance() {
        return instance;
    }
    
    public int nextNumber(){
        return randomGenerator.nextInt(6) + 1;
    }
}
