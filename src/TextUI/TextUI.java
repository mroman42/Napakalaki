package TextUI;

import Game.Napakalaki;
import java.util.ArrayList;
import java.util.Arrays;
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
        // Trabaja con la instancia de Napakalaki.
        Napakalaki napakalaki = Napakalaki.getInstance();
        
        // Lee los nombres.
        ArrayList<String> names = readNames();
        napakalaki.initGame(names);
    }
    
    private static ArrayList<String> readNames() {
        System.out.println("Introduzca los nombres de los jugadores.");
        
        scanIn = new Scanner(System.in);
        String line = scanIn.nextLine();
        String[] names = line.split(" ");
        
        return new ArrayList<>(Arrays.asList(names));
    }
}
