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
        napakalakiView.showView(); 
        ArrayList<String> names;
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
        
        names = namesCapture.getNames();
        napakalakiModel.initGame(names);
        napakalakiView.showView(); 
    }
}
