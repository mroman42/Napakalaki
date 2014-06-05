package GUI;
import Game.*;
import java.util.ArrayList;

/**
 *
 * @author Mario Román 
 * @author José Carlos Entrena
 * @author Óscar Bermúdez 
 */
public class GUI {
    private static final NapakalakiView napakalakiView = new NapakalakiView();
    private static final Napakalaki napakalakiModel = Napakalaki.getInstance();
    
    public static void main (String[] args) {
        // Lectura de nombres
        ArrayList<String> names;
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
        names = namesCapture.getNames();
        
        // Ventana de inicio del juego
        napakalakiModel.initGame(names);
        napakalakiView.setNapakalaki(napakalakiModel);
        napakalakiView.showView(); 
    }
}
