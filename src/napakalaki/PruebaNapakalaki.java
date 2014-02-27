package napakalaki;

/**
 * @date 27/02/2014
 * @author Mario Román
 * @author José Carlos Entrena
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Prize ejemplo = new Prize(2,3);
         BadConsequence nueva = new BadConsequence("Lo mando como ejercicio", true);  
         Monster calculo = new Monster("Paco Polo", 28, nueva, ejemplo);
         System.out.print(calculo.toString());
    }
    
}
