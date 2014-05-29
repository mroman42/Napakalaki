package GUI;
import Game.*;

/**
 *
 * @author mario
 */
public class GUI {
    private static final NapakalakiView napakalakiView = new NapakalakiView();
    private static final Napakalaki napakalakiModel = Napakalaki.getInstance();
    
    public static void main (String[] args) {
        napakalakiView.showView(); 
    }
}
