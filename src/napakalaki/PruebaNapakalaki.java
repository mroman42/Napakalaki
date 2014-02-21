package napakalaki;

/**
 * @date 21/02/2014
 * @author Mario Román
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Prize ejemplo = new Prize(2,3);
         System.out.print("Ejemplo: Levels: ");
         System.out.print(ejemplo.getLevels());
         System.out.print(" Treasures: ");
         System.out.print(ejemplo.getTreasures());
         System.out.print("\n");
    }
    
}
