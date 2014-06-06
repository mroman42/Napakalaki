package GUI;
import Game.*;
import java.awt.Frame;
import java.util.ArrayList;

/**
 *
 * @author Mario Román 
 * @author José Carlos Entrena
 * @author Óscar Bermúdez 
 */
public class GUIMain {
    private static final NapakalakiView napakalakiView = new NapakalakiView();
    private static final Napakalaki napakalakiModel = Napakalaki.getInstance();
    
    public static void main (String[] args) {
        // Lectura de nombres
        ArrayList<String> names;
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
        names = namesCapture.getNames();
        
        // Ventana maximizada de inicio del juego
        napakalakiModel.initGame(names);
        napakalakiView.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        napakalakiView.setNapakalaki(napakalakiModel);
        napakalakiView.showView(); 
    }
}
