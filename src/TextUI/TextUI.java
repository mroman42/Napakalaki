package TextUI;

//Sugerencia:
//import Game.*;
import Game.CardDealer;
import Game.CombatResult;
import Game.Napakalaki;
import Game.Treasure;
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
    public static void main(String[] args) {
        printHeader(); 
        ArrayList<String> players = readPlayers();
        NP.initGame(players);
        int turn = 0; 
        do{
            System.out.println("Turno: " + Integer.toString(turn) + "\n"); 
            printCurrentPlayerStatus(); 
            printCurrentMonsterStatus();     
            System.out.println("Compra de niveles."); 
            
            turn++; 
            
        } while (false); 
    }

    // Limpiar consola.
    public final static void clearConsole() {
        System.out.print("\u001b[2J");
        System.out.flush();
    }

 
    /*        def clearScreen
            system "clear"
            printHeader
            puts "Turno: #{@turn}\n"
            puts Game::CardDealer.instance
            printCurrentPlayerStatus
            printCurrentMonsterStatus
        end*/
    public final static void clearScreen() {
        printHeader();
        //System.out.println("Turno: " + turno + "\n");
        System.out.println(CardDealer.getInstance().toString());
        printCurrentPlayerStatus();
        printCurrentMonsterStatus();
        
    }
    
    // Imprime una cabecera para el juego
    public static void printHeader(){
        System.out.println("---------------------"); 
        System.out.println("\tNapakalaki");
        System.out.println("---------------------"); 
    }
    
    // Imprime el estado del jugador actual. 
    public static void printCurrentPlayerStatus(){
        System.out.println("\nJugador actual: " + NP.getCurrentPlayer().toString() + "\n");
        printVisibleTreasures();
        printHiddenTreasures();
        printCurrentPlayerCombatStatus();
    }
    
    public static void printCurrentPlayerCombatStatus(){
        System.out.println("Nivel de combate: " + NP.getCurrentPlayer().getCombatLevel() + "\n");
    }

    public static void printTreasures(ArrayList<Treasure> treasures){
        for(int i = 0; i < treasures.size(); i++){
            System.out.println("\t(" + i + "): " + treasures.get(i) + "\n");
        }
    }
    
    public static void printVisibleTreasures(){
        System.out.println("Tesoros visibles:\n");
        printTreasures(NP.getVisibleTreasures());
    }

    public static void printHiddenTreasures(){
        System.out.println("Tesoros ocultos:\n");
        printTreasures(NP.getHiddenTreasures());
    } 
    // Imprime el estado del monstruo actual.
    public static void printCurrentMonsterStatus(){
        System.out.println("\nMonstruo actual: " + NP.getCurrentMonster().toString() + "\n");
    }
    
    public static void printCombatResult(CombatResult result){
        clearScreen();
        
        System.out.println("Combate contra " + NP.getCurrentMonster().getName() + ":\n");        
        
        switch (result) {
            case WIN:  System.out.println("Has derrotado al monstruo.\n");
                     break;
            case WINANDWINGAME:  System.out.println("Has ganado el combate y el juego. ¡Enhorabuena!\n");
                     break;
            case LOSE:  System.out.println("Has sido derrotado. Ahora se te aplicará el mal rollo del monstruo.\n");
                     break;
            case LOSEANDDIE:  System.out.println("Has sido derrotado y has muerto.\n");
                     break;
            case LOSEANDESCAPE:  System.out.println("Has logrado escapar del combate a salvo.\n");
                     break;
            default: System.out.println("Error en el combate.\n");
                     break;
        }
        
    }
    
    /**
     * @brief Crea un menú
     * @param msg Mensaje inicial del menú
     * @param options Opciones del menú
     */
    public static void menu(String msg, String... options){
        System.out.println(msg);
        
        int i = 1;
        
        for(String o : options){
            System.out.println("[" + i + "]: " + o + "\n");
            
            i++;
        }
    }
    
    /**
     * @brief Menú de antes de la batalla
     */
    public static void selectionMenu(){
        menu("Elegir acción:\n",
                "Comprar niveles",
                "Combatir");
        char respuesta = readString("").charAt(0);
        
        clearScreen();
        
        // Controla las opciones
        switch (respuesta) {
            case '2': break;
            case '1': //buyLevels();    No se me ha olvidado el break, es que cómo los dos hacen SelectionMenu...
            default: selectionMenu();
            break;
        }
    }

    /**
     * @brief Menú de después de la batalla
     */
    public static void selectionMenu2(){
        menu("Elegir acción:\n",
                "Equipar niveles",
                "Pasar de turno");
        char respuesta = readString("").charAt(0);
        
        clearScreen();
        
        // Controla las opciones
        switch (respuesta) {
            case '2': break;
            case '1': //equip();    No se me ha olvidado el break, es que cómo los dos hacen SelectionMenu2...
            default: selectionMenu2();
            break;
        }
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
    
    /**
     * @brief Imprime un mensaje por pantalla y toma una respuesta a la pregunta. 
     * @param msg Mensaje (pregunta) a imprimir. 
     * @return Valor booleano, respuesta a la pregunta. 
     */
    public static boolean yesNoQuestion(String msg) {
        String input = readString(msg + "(y/n): "); 
        return "y".equals(input); 
    }
    
    private static ArrayList<String> readPlayers() {
        String line = readString("Introduzca los nombres de los jugadores: ");
        String[] players = line.split(" ");
        clearConsole();
        
        return new ArrayList<>(Arrays.asList(players));
    }
    
    
}
