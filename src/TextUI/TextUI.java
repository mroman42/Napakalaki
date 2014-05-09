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
/*      def initialize
            @turn = 0
        end

        
        def menu(msg, *options)
            puts msg
            
            index = 1
            for o in options
                puts "[#{index}]: #{o}"
                index = index + 1
            end
        end

        def selectionMenu
            menu("Elegir acción:\n",
                 "Comprar niveles",
                 "Combatir",
                 "Cerrar juego"
                 )

            # Controla opciones del menú
            case respuesta = STDIN.getch
            when "1"
                clearScreen
                buyLevels
                selectionMenu
            when "2"
                clearScreen
            when "3"
                exit
            else
                clearScreen
                selectionMenu
            end
        end

        def selectionMenu2
            menu("Elegir acción:\n", 
                 "Equipar tesoros", 
                 "Pasar de turno",
                 )
            respuesta = 0

            # Controla opciones
            case respuesta = STDIN.getch
            when "1"
                clearScreen 
                equip
                selectionMenu2
            when "2"
                clearScreen
            else 
                clearScreen
                selectionMenu2
            end
        end
        
        def yesNoQuestion(message)
            puts "#{message} (y/n)"

            begin 
                c = STDIN.getch
            end while c != 'y' and c != 'n'

            return c == 'y'
        end

        def buyLevels
            # Compra de niveles.
            # Listas de tesoros ocultos y visibles a vender.
            svisibles = []
            shidden = []
            # Listas con los índices de posibles tesoros a vender.
            index_visibles = (0..NP.getVisibleTreasures.size-1).to_a
            index_hidden = (0..NP.getHiddenTreasures.size-1).to_a
            
            # Venta de tesoros visibles
            begin
                puts "Vendiendo tesoros visibles:"
                print "Tesoros visibles que se venderán:\n"
                printTreasures(svisibles)
                printVisibleTreasures
                puts "\t(x): Salir"

                index = STDIN.getch
                if (index != 'x')
                    index = index.to_i
                    if (index_visibles.member? index)
                        svisibles.push(NP.getVisibleTreasures.at(index))
                        index_visibles.delete index
                    end
                end 

                clearScreen
            end while (index != 'x')
            
            # Venta de tesoros ocultos
            begin
                puts "Vendiendo tesoros ocultos:"
                print "Tesoros ocultos que se venderán:\n"
                printTreasures(shidden)
                printHiddenTreasures
                puts "\t(x): Salir"

                index = STDIN.getch
                if (index != 'x')
                    index = index.to_i
                    if (index_hidden.member? index)
                        shidden.push(NP.getHiddenTreasures.at(index))
                        index_hidden.delete index
                    end
                end
                
                clearScreen
            end while (index != 'x')


            # Comprobante de venta
            puts "Se venderán los siguientes tesoros:"
            puts "Tesoros visibles:"
            printTreasures svisibles
            sumavisibles = 0
            svisibles.each {|t| sumavisibles += t.getGoldCoins}
            puts "\tSuma total: #{sumavisibles}"
            puts "Tesoros ocultos:"
            printTreasures shidden
            sumahidden = 0
            shidden.each {|t| sumahidden += t.getGoldCoins}
            puts "\tSuma total: #{sumahidden}"
            puts "Aumentarías #{sumavisibles/1000 + sumahidden/1000} niveles"


            
            if (yesNoQuestion "¿Realizar la compra?")
                # Tras realizar la compra, limpia la pantalla y muestra el resultado.
                if(!NP.buyLevels(svisibles, shidden))
                    clearScreen
                    puts "No puedes vender los tesoros.\n"
                else
                    clearScreen
                    puts "Compra realizada.\n"
                end 
            else
                clearScreen
                puts "Compra anulada.\n"
            end
            
        end
        

        def equip
            begin
                # Escribe información relevante a la equipación de objetos
                puts "Equipación de objetos.\n"
                printVisibleTreasures
                printHiddenTreasures
                puts "\t(x): Salir"
                puts "Dime que tesoro oculto te quieres equipar:"
                
                # Pasamos el índice del tesoro que queremos equipar. 
                index = STDIN.getch
                if (index != 'x')
                    index = index.to_i
                    clearScreen

                    # Comprueba que el índice sea válido.
                    if (index < NP.getHiddenTreasures.size and index >= 0)
                        if(NP.canMakeTreasureVisible(NP.getHiddenTreasures.at(index)))
                            puts "Tesoro #{NP.getHiddenTreasures.at(index).getName} equipado\n"
                            NP.makeTreasureVisible(NP.getHiddenTreasures.at(index))
                        else
                            puts "No puedes equiparte #{NP.getHiddenTreasures.at(index)}\n"
                        end
                    else
                        puts "Índice inválido.\n"
                    end
                end 
            end while (index != 'x')
            clearScreen
        end

        # Método para ajustar el mal rollo. 
        def adjust
            begin 
                discardVisibleTreasures
                discardHiddenTreasures
            end while !NP.nextTurnAllowed
        end

        def discardVisibleTreasures
            begin
                puts "Descarta tesoros visibles:\n"
                printVisibleTreasures
                puts "Dime el índice del tesoro visible a descartar (x para terminar): "
                index = STDIN.getch
                if (index != 'x') 
                    index = index.to_i
                    if (index >= 0 and index < NP.getVisibleTreasures.size)
                        NP.discardVisibleTreasure(NP.getVisibleTreasures.at(index))
                        clearScreen 
                        puts "Tesoro eliminado.\n"
                    else
                        clearScreen
                    end
                else
                    clearScreen
                end
            end while (index != 'x')
        end 

        def discardHiddenTreasures
            begin
                puts "Descarta tesoros ocultos:\n"
                printHiddenTreasures
                puts "Dime el índice del tesoro oculto a descartar (x para terminar): "
                index = STDIN.getch
                if (index != 'x') 
                    index = index.to_i
                    if (index >= 0 and index < NP.getHiddenTreasures.size)
                        NP.discardHiddenTreasure(NP.getHiddenTreasures.at(index))
                        clearScreen 
                        puts "Tesoro eliminado.\n"
                    else
                        clearScreen
                    end
                else
                    clearScreen
                end
            end while (index != 'x')
        end

        def main
            # Presentación del juego
            system "clear"
            printHeader

            # Lee los jugadores
            players = readPlayers
            NP.initGame players

            # Bucle principal del juego
            begin
                # Anuncia el nuevo turno
                clearScreen
                
                # El jugador elige acción
                selectionMenu

                # Combate
                result = NP.combat
                printCombatResult result

                if result != Game::WINANDWINGAME
                    # Aplica mal rollo si pierde, o bien ofrece la posibilidad de eliminar tesoros.    
                    adjust 
                    begin
                        selectionMenu2
                        # Pasa al siguiente turno
                    end while not yesNoQuestion("¿Pasar al siguiente turno?")
                    NP.nextTurn
                    @turn = @turn+1
                else
                    # Fin del juego.
                    puts "¡El juego ha terminado! Ganador: #{NP.getCurrentPlayer}"
                end
            end while not NP.endOfGame(result)
        end
    end
*/
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
