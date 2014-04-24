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
    private static final Napakalaki NP = Napakalaki.getInstance();
    
    // Método main.
    public static void main(){
        printHeader(); 
        ArrayList<String> names = readNames();
        NP.initGame(names);
             
        do{
            printCurrentPlayerStatus(); 
            printCurrentMonsterStatus();           
            
        } while (false); 
    }

    
    // Imprime una cabecera para el juego
    public static void printHeader(){
        System.out.println("---------------------"); 
        System.out.println("\tNapakalaki");
        System.out.println("---------------------"); 
    }

    // Imprime el estado del jugador actual. 
    public static void printCurrentPlayerStatus(){
        System.out.println(NP.getCurrentPlayer().toString());  
    }
    
    // Imprime el estado del monstruo actual.
    public static void printCurrentMonsterStatus(){
        System.out.println(NP.getCurrentMonster().toString());
    }
    
    /**
     * Lee un número entero introducido por el usuario.
     * @param msg Mensaje mostrado por pantalla para solicitar la entrada.
     * @return Número entero leído.
     */
    public static int readInteger(String msg) {
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
     * @return Cadena de texto leída.
     */
    public static String readString(String msg) {
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
        String line = readString("");
        String[] names = line.split(" ");
        
        return new ArrayList<>(Arrays.asList(names));
    }
    
}
