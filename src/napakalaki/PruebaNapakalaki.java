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
        Prize prize = new Prize(4,2);
        monsters.add(new Monster("El rey de rosa", 13, bad, prize)); 
        
        // Ángeles de la noche ibicenca
        tvp.add(TreasureKind.ONEHAND);
        thp.add(TreasureKind.ONEHAND);
        BadConsequence bad2 = new BadConsequence("Te atrapan para llevarte de "
                + "fiesta y te dejan caer en mitad del vuelo. "
                + "Descarta 1 mano visible y 1 mano oculta.", 0, tvp, thp);
        Prize prize2 = new Prize(4,1);
        monsters.add(new Monster("Ángeles de la noche ibicenca", 14, bad2, prize2));
        
        // Monstruos añadidos por orden de aparición en el guión. 
        
        // 3 Byakhees de bonanza. 
        tvp.clear(); 
        thp.clear(); 
        tvp.add(TreasureKind.ARMOR);
        thp.add(TreasureKind.ARMOR);
        BadConsequence bad3 = new BadConsequence("Pierdes tu armadura visible"
                + "y otra oculta.", 0, tvp, thp);
        Prize prize3 = new Prize(2,1); 
        monsters.add(new Monster("2 Byakhees de bonanza", 8, bad3, prize3));
        
        // Chibithulhu
        tvp.clear(); 
        thp.clear(); 
        tvp.add(TreasureKind.HELMET); 
        BadConsequence bad4 = new BadConsequence("Embobados con el lindo "
                + "primigenio te descartas de tu casco visible.", 0, tvp, thp);
        Prize prize4 = new Prize(1,1); 
        monsters.add(new Monster("Chibithulhu", 2, bad4, prize4)); 
             
        // El sopor de Dunwich
        tvp.clear(); 
        tvp.add(TreasureKind.SHOE); 
        BadConsequence bad5 = new BadConsequence("El primordial bostezo "
                + "contagioso. Pierdes el calzado visible.", 0, tvp, thp);
        Prize prize5 = new Prize(1,1); 
        monsters.add(new Monster("El sopor de Dunwich", 2, bad5, prize5)); 
        
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
        Prize prize6 = new Prize(3,1); 
        monsters.add(new Monster("El gorrón en el umbral", 10, bad6, prize6)); 
        
        // H.P. Munchcraft
        tvp.clear(); 
        tvp.add(TreasureKind.ARMOR); 
        BadConsequence bad7 = new BadConsequence("Pierdes la armadura visible.",
                0, tvp, thp); 
        Prize prize7 = new Prize(2,1); 
        monsters.add(new Monster("H.P. Munchcraft", 6, bad7, prize7)); 
        
        // Bichgooth
        
        tvp.clear(); 
        tvp.add(TreasureKind.ARMOR); 
        BadConsequence bad8 = new BadConsequence("Sientes bichos bajo la ropa. "
                + "Descarta la armadura visible.", 0, tvp, thp);
        Prize prize8 = new Prize(1,1); 
        monsters.add(new Monster("Bichgooth", 2, bad8, prize8)); 
        
        // La que redacta en las sombras. 
        
        BadConsequence bad9 = new BadConsequence("Toses los pulmones y "
                + "pierdes 2 niveles.", 2, 0, 0); 
        Prize prize9 = new Prize(1,1); 
        monsters.add(new Monster("La que redacta en las sombras", 3, bad9, prize9));
        
        // Los hondos verdes
        
        BadConsequence bad10 = new BadConsequence("Estos monstruos resultan "
                + "bastante superficiales y te aburren mortalmente. "
                + "Estás muerto.", true);
        Prize prize10 = new Prize(2,1);
        monsters.add(new Monster("Los hondos verdes", 7, bad10, prize10)); 
        
        // Semillas Cthulhu
        
        BadConsequence bad11 = new BadConsequence("Pierdes 2 niveles y 2 tesoros "
                + "ocultos.", 2, 0, 2); 
        Prize prize11 = new Prize(2,1); 
        monsters.add(new Monster("Semillas Cthulhu", 4, bad11, prize11));
        
        // Dameargo 
        
        tvp.clear(); 
        tvp.add(TreasureKind.ONEHAND); 
        BadConsequence bad12 = new BadConsequence("Te intentas escapar. "
                + "Pierdes una mano visible.", 0, tvp, thp); 
        Prize prize12 = new Prize(2,1); 
        monsters.add(new Monster("Dameargo", 1, bad12, prize12)); 
        
        // Pollipólipo volante
        
        BadConsequence bad13 = new BadConsequence("Da mucho asquito. Pierdes "
                + "3 niveles.", 3, 0, 0); 
        Prize prize13 = new Prize(1,1); 
        monsters.add(new Monster("Pollipólipo volante", 3, bad13, prize13)); 
        
        // Yskhtihyssg-Goth
        
        BadConsequence bad14 = new BadConsequence("No le hace gracia que pronuncien "
                + "mal su nombre. Estás muerto.", true); 
        Prize prize14 = new Prize(3,1); 
        monsters.add(new Monster("Yskhtihyssg-Goth", 12, bad14, prize14)); 
        
        // Familia feliz. 
        
        BadConsequence bad15 = new BadConsequence("La familia te atrapa. Estás muerto."
                , true); 
        Prize prize15 = new Prize(4,1); 
        monsters.add(new Monster("Familia feliz", 1, bad15, prize15)); 
        
        // Roboggoth
        
        tvp.clear(); 
        tvp.add(TreasureKind.BOTHHANDS); 
        BadConsequence bad16 = new BadConsequence("La quinta directiva primaria "
                + "te obliga a perder 2 niveles y un tesoro 2 manos visible.", 2
                , tvp, thp); 
        Prize prize16 = new Prize(2,1); 
        monsters.add(new Monster("Roboggoth", 8, bad16, prize16)); 
        
        // El espía ciego. 
        
        tvp.clear(); 
        tvp.add(TreasureKind.HELMET); 
        BadConsequence bad17 = new BadConsequence("Te asusta en la noche. "
                + "Pierdes un casco visible.", 0, tvp, thp); 
        Prize prize17 = new Prize(1,1); 
        monsters.add(new Monster("El espía ciego", 4, bad17, prize17)); 
        
        // El Lenguas
        
        BadConsequence bad18 = new BadConsequence("Menudo susto te llevas. Pierdes "
                + "2 niveles y 5 tesoros visibles.", 2, 5, 0); 
        Prize prize18 = new Prize(1,1); 
        monsters.add(new Monster("El Lenguas", 20, bad18, prize18)); 
        
        // Bicéfalo
        
        tvp.clear(); 
        tvp.add(TreasureKind.BOTHHANDS); 
        BadConsequence bad19 = new BadConsequence("Te faltan manos para tanta cabeza."
                + " Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, tvp, thp);
        Prize prize19 = new Prize(1,1); 
        monsters.add(new Monster("Bicéfalo", 20, bad19, prize19)); 
        
        
        
        ////
        // Filtros sobre los monstruos.
        ////
        System.out.println("Monstruos de nivel mayor a 10:");
        //System.out.println(nivelSuperior(monsters, 10).toString());
        System.out.println("Monstruos que sólo quitan niveles:");
       // System.out.println(pierdenSoloNiveles(monsters).toString());
        System.out.println("Monstruos con ganancia de un nivel o más:");
        System.out.println(ganaMasDeUnNivel(monsters).toString());
    
    }
    
    public static ArrayList<Monster> nivelSuperior (ArrayList<Monster> listado, int nivel) {
        ArrayList<Monster> filtrados = new ArrayList();
        
        for (Monster actual : listado) {
            if (actual.getLevel() >= nivel)
                filtrados.add(actual);
        }
        
        return filtrados;
    }
    
    public static ArrayList<Monster> pierdenSoloNiveles (ArrayList<Monster> listado) {
        ArrayList<Monster> filtrados = new ArrayList();
        
        for (Monster actual : listado) {
            BadConsequence bad = actual.getBadConsequence();
            
            if ((bad.getLevels() >= 0) && (bad.getDeath() == false) &&
                    (bad.getnVisibleTreasures() == 0) && 
                    (bad.getnHiddenTreasures() == 0))
                filtrados.add(actual);
        }
        
        return filtrados;
    }
    
    public static ArrayList<Monster> ganaMasDeUnNivel (ArrayList<Monster> listado) {
        ArrayList<Monster> filtrados = new ArrayList(); 
        
        for (Monster actual : listado) {
            Prize prize = actual.getPrize();
            
            if ((prize.getLevels() > 1))
                 filtrados.add(actual);
           
        }
        return filtrados; 
    }
}
