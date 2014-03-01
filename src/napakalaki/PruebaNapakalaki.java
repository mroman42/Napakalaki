package napakalaki;

import java.util.ArrayList;

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
        // Declaración de los monstruos. 
        ArrayList<Monster> monsters = new ArrayList();
        // Ejemplos del guión. 
        BadConsequence bad = new BadConsequence("Pierdes 5 niveles", 5, 0, 0);
        Prize price = new Prize(4,2);
        monsters.add(new Monster("El rey de rosa", 13, bad, price)); 
        
        ArrayList<TreasureKind> tvp = new ArrayList(); 
        tvp.add(TreasureKind.ONEHAND);
        ArrayList<TreasureKind> thp = new ArrayList(); 
        thp.add(TreasureKind.ONEHAND);
        BadConsequence bad2 = new BadConsequence("Te atrapan para llevarte de "
                + "fiesta y te dejan caer en mitad del vuelo. "
                + "Descarta 1 mano visible y 1 mano oculta.", 0, tvp, thp);
        Prize price2 = new Prize(4,1);
        monsters.add(new Monster("Ángeles de la noche ibicenca", 14, bad2, price2));
        
        // Monstruos añadidos por orden de aparición en el guión. 
        
        // 3 Byakhees de bonanza. 
        tvp.clear(); 
        thp.clear(); 
        tvp.add(TreasureKind.ARMOR);
        thp.add(TreasureKind.ARMOR);
        BadConsequence bad3 = new BadConsequence("Pierdes tu armadura visible"
                + "y otra oculta.", 0, tvp, thp);
        Prize price3 = new Prize(2,1); 
        monsters.add(new Monster("2 Byakhees de bonanza", 8, bad3, price3));
        
        // Chibithulhu
        tvp.clear(); 
        tvp.add(TreasureKind.HELMET); 
        BadConsequence bad4 = new BadConsequence("Embobados con el lindo "
                + "primigenio te descartas de tu casco visible.", 0, tvp, thp);
        Prize price4 = new Prize(1,1); 
        monsters.add(new Monster("Chibithulhu", 2, bad4, price4)); 
             
         
    }
    
}
