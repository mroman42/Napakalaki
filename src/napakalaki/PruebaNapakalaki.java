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
        ArrayList<TreasureKind> tvp = new ArrayList(); 
        ArrayList<TreasureKind> thp = new ArrayList(); 
        
        // Ejemplos del guión. 
        
        // El rey de rosa
        BadConsequence bad = new BadConsequence("Pierdes 5 niveles y 3 tesoros"
                + " visibles.", 5, 3, 0);
        Prize price = new Prize(4,2);
        monsters.add(new Monster("El rey de rosa", 13, bad, price)); 
        
        // Ángeles de la noche ibicenca
        tvp.add(TreasureKind.ONEHAND);
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
        thp.clear(); 
        tvp.add(TreasureKind.HELMET); 
        BadConsequence bad4 = new BadConsequence("Embobados con el lindo "
                + "primigenio te descartas de tu casco visible.", 0, tvp, thp);
        Prize price4 = new Prize(1,1); 
        monsters.add(new Monster("Chibithulhu", 2, bad4, price4)); 
             
        // El sopor de Dunwich
        tvp.clear(); 
        tvp.add(TreasureKind.SHOE); 
        BadConsequence bad5 = new BadConsequence("El primordial bostezo "
                + "contagioso. Pierdes el calzado visible.", 0, tvp, thp);
        Prize price5 = new Prize(1,1); 
        monsters.add(new Monster("El sopor de Dunwich", 2, bad5, price5)); 
        
        // El gorrón en el umbral
        tvp.clear(); 
        tvp.add(TreasureKind.ARMOR);
        tvp.add(TreasureKind.BOTHHANDS); 
        tvp.add(TreasureKind.SHOE);
        tvp.add(TreasureKind.NECKLACE); 
        tvp.add(TreasureKind.HELMET);
        tvp.add(TreasureKind.ONEHAND); 
        BadConsequence bad6 = new BadConsequence("Pierdes todos tus tesoros "
                + "visibles.", 0, tvp, thp); 
        Prize price6 = new Prize(3,1); 
        monsters.add(new Monster("El gorrón en el umbral", 10, bad6, price6)); 
        
        // H.P. Munchcraft
        tvp.clear(); 
        tvp.add(TreasureKind.ARMOR); 
        BadConsequence bad7 = new BadConsequence("Pierdes la armadura visible.",
                0, tvp, thp); 
        Prize price7 = new Prize(2,1); 
        monsters.add(new Monster("H.P. Munchcraft", 6, bad7, price7)); 
        
        // Bichgooth
        
        tvp.clear(); 
        tvp.add(TreasureKind.ARMOR); 
        BadConsequence bad8 = new BadConsequence("Sientes bichos bajo la ropa. "
                + "Descarta la armadura visible.", 0, tvp, thp);
        Prize price8 = new Prize(1,1); 
        monsters.add(new Monster("Bichgooth", 2, bad8, price8)); 
        
        // La que redacta en las sombras. 
        
        BadConsequence bad9 = new BadConsequence("Toses los pulmones y "
                + "pierdes 2 niveles.", 2, 0, 0); 
        Prize price9 = new Prize(1,1); 
        monsters.add(new Monster("La que redacta en las sombras", 3, bad9, price9));
        
        // Los hondos verdes
        
        BadConsequence bad10 = new BadConsequence("Estos monstruos resultan "
                + "bastante superficiales y te aburren mortalmente. "
                + "Estás muerto.", true);
        Prize price10 = new Prize(2,1);
        monsters.add(new Monster("Los hondos verdes", 7, bad10, price10)); 
        
        // Semillas Cthulhu
        
        BadConsequence bad11 = new BadConsequence("Pierdes 2 niveles y 2 tesoros "
                + "ocultos.", 2, 0, 2); 
        Prize price11 = new Prize(2,1); 
        monsters.add(new Monster("Semillas Cthulhu", 4, bad11, price11)); 
        
        
       
                 
         
    }
    
}
