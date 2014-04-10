package TextUI;

import Game.Napakalaki;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @date 10/04/14
 * @author Mario Román
 * @author José Carlos Entrena
 * @author Óscar Bermúdez
 */
public class TextUI {
    private static Scanner scanIn;
    
    // Método main.
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        scanIn = new Scanner(System.in);
        
        // Trabaja con la instancia de Napakalaki.
        Napakalaki napakalaki = Napakalaki.getInstance();
        
        // Lee los nombres.
        napakalaki.initGame(readNames());
    }
    
    private static ArrayList<String> readNames() {
        ArrayList<String> names = new ArrayList();
        System.out.println("Introduzca los nombres de los jugadores.");
        return names;
    }
}
