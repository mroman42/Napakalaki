package TextUI;

import Game.Napakalaki;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    
    
    /**
     * Lee un número introducido por el usuario.
     * @param msg Mensaje mostrado por pantalla para solicitar la entrada. 
     */
    public  int readInteger(String msg) {
        int input = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        System.out.print(msg);
        
        try {
            input = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
        catch (IOException ioe){
            System.err.println("IO Error!");            
        }
        return input;
    }
    
    /**
     * Lee una cadena introducida por el usuario.
     * @param msg Mensaje mostrado por pantalla para solicitar la entrada. 
     */
    public  String readString(String msg) {
        String input= "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        System.out.print(msg);
        try{
            input = br.readLine();
        }
        catch(IOException ioe){
            System.err.println("IO Error!");            
        }
        return input;
    }   
    
    private static ArrayList<String> readNames() {
        System.out.println("Introduzca los nombres de los jugadores.");
        
        scanIn = new Scanner(System.in);
        String line = scanIn.nextLine();
        String[] names = line.split(" ");
        
        return new ArrayList<>(Arrays.asList(names));
    }
}
