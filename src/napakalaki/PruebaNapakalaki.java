package napakalaki;

import java.util.*;

/**
 * @date 27/02/2014
 * @author Mario Román
 * @author José Carlos Entrena
 * @author Óscar Bermúdez
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
        
        
        
        // Monstruos añadidos por orden de aparición en el guión. 
        
        // 3 Byakhees de bonanza.
        tvp.add(TreasureKind.ARMOR);
        thp.add(TreasureKind.ARMOR);
        BadConsequence bad = new BadConsequence("Pierdes tu armadura visible y otra oculta.", 0, tvp, thp);
        tvp.clear();
        thp.clear();
        Prize prize = new Prize(2,1);
        monsters.add(new Monster("3 Byakhees de bonanza", 8, bad, prize));
        
        
        // Chibithulhu 
        tvp.add(TreasureKind.HELMET); 
        bad = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible.", 0, tvp, thp);
        tvp.clear();
        prize = new Prize(1,1); 
        monsters.add(new Monster("Chibithulhu", 2, bad, prize)); 

        
        // El sopor de Dunwich
        tvp.add(TreasureKind.SHOE); 
        bad = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.", 0, tvp, thp);
        tvp.clear();
        prize = new Prize(1,1); 
        monsters.add(new Monster("El sopor de Dunwich", 2, bad, prize)); 
        
        
        // Ángeles de la noche ibicenca
        tvp.add(TreasureKind.ONEHAND);
        thp.add(TreasureKind.ONEHAND);
        bad = new BadConsequence("Te atrapan para llevarte de "
                + "fiesta y te dejan caer en mitad del vuelo. "
                + "Descarta 1 mano visible y 1 mano oculta.", 0, tvp, thp);
        tvp.clear();
        thp.clear();
        prize = new Prize(4,1);
        monsters.add(new Monster("Ángeles de la noche ibicenca", 14, bad, prize));
        
        
        // El gorrón en el umbral
        tvp.add(TreasureKind.ARMOR);
        tvp.add(TreasureKind.BOTHHANDS); 
        tvp.add(TreasureKind.SHOE);
        tvp.add(TreasureKind.NECKLACE); 
        tvp.add(TreasureKind.HELMET);
        tvp.add(TreasureKind.ONEHAND); 
        bad = new BadConsequence("Pierdes todos tus tesoros visibles.", 0, tvp, thp);
        tvp.clear(); 
        prize = new Prize(3,1); 
        monsters.add(new Monster("El gorrón en el umbral", 10, bad, prize)); 
        
        
        // H.P. Munchcraft
        tvp.add(TreasureKind.ARMOR); 
        bad = new BadConsequence("Pierdes la armadura visible.", 0, tvp, thp);
        tvp.clear(); 
        prize = new Prize(2,1); 
        monsters.add(new Monster("H.P. Munchcraft", 6, bad, prize)); 
        
        
        // Bichgooth
        tvp.add(TreasureKind.ARMOR); 
        bad = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.", 0, tvp, thp);
        tvp.clear();
        prize = new Prize(1,1); 
        monsters.add(new Monster("Bichgooth", 2, bad, prize)); 
        
        
        // El rey de rosa
        bad = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
        prize = new Prize(4,2);
        monsters.add(new Monster("El rey de rosa", 13, bad, prize)); 
        
        
        // La que redacta en las sombras. 
        bad = new BadConsequence("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0); 
        prize = new Prize(1,1); 
        monsters.add(new Monster("La que redacta en las sombras", 3, bad, prize));
        
        
        // Los hondos verdes
        bad = new BadConsequence("Estos monstruos resultan "
                + "bastante superficiales y te aburren mortalmente. "
                + "Estás muerto.", true);
        prize = new Prize(2,1);
        monsters.add(new Monster("Los hondos verdes", 7, bad, prize)); 
        
        
        // Semillas Cthulhu
        bad = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2); 
        prize = new Prize(2,1); 
        monsters.add(new Monster("Semillas Cthulhu", 4, bad, prize));
        
        
        // Dameargo
        tvp.add(TreasureKind.ONEHAND); 
        bad = new BadConsequence("Te intentas escapar. Pierdes una mano visible.", 0, tvp, thp);
        tvp.clear();
        prize = new Prize(2,1); 
        monsters.add(new Monster("Dameargo", 1, bad, prize)); 
         
        
        // Pollipólipo volante
        bad = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0); 
        prize = new Prize(1,1); 
        monsters.add(new Monster("Pollipólipo volante", 3, bad, prize)); 
        
        
        // Yskhtihyssg-Goth
        bad = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto.", true); 
        prize = new Prize(3,1); 
        monsters.add(new Monster("Yskhtihyssg-Goth", 12, bad, prize)); 
        
        
        // Familia feliz. 
        bad = new BadConsequence("La familia te atrapa. Estás muerto.", true); 
        prize = new Prize(4,1); 
        monsters.add(new Monster("Familia feliz", 1, bad, prize)); 
        
        
        // Roboggoth 
        tvp.add(TreasureKind.BOTHHANDS); 
        BadConsequence bad16 = new BadConsequence("La quinta directiva primaria "
                + "te obliga a perder 2 niveles y un tesoro 2 manos visible.", 2
                , tvp, thp);
        tvp.clear();
        Prize prize16 = new Prize(2,1); 
        monsters.add(new Monster("Roboggoth", 8, bad16, prize16)); 
        
        
        // El espía ciego.
        tvp.add(TreasureKind.HELMET); 
        bad = new BadConsequence("Te asusta en la noche. "
                + "Pierdes un casco visible.", 0, tvp, thp);
        tvp.clear();
        prize = new Prize(1,1); 
        monsters.add(new Monster("El espía ciego", 4, bad, prize)); 
        
        
        // El Lenguas
        bad = new BadConsequence("Menudo susto te llevas. Pierdes "
                + "2 niveles y 5 tesoros visibles.", 2, 5, 0); 
        prize = new Prize(1,1); 
        monsters.add(new Monster("El Lenguas", 20, bad, prize)); 
        
        
        // Bicéfalo
        tvp.add(TreasureKind.BOTHHANDS);
        tvp.add(TreasureKind.ONEHAND);
        tvp.add(TreasureKind.ONEHAND);
        bad = new BadConsequence("Te faltan manos para tanta cabeza."
                + " Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, tvp, thp);
        tvp.clear();
        prize = new Prize(1,1); 
        monsters.add(new Monster("Bicéfalo", 20, bad, prize)); 
        
        
        
        ////
        // Filtros sobre los monstruos.
        ////
        System.out.println("\n----\nMonstruos de nivel mayor a 10:\n----\n");
        System.out.println(nivelSuperior(monsters, 10).toString());
        System.out.println("\n----\nMonstruos que sólo quitan niveles:\n----\n");
        System.out.println(pierdenSoloNiveles(monsters).toString());
        System.out.println("\n----\nMonstruos con ganancia de un nivel o más:\n----\n");
        System.out.println(ganaMasDeUnNivel(monsters).toString());
        System.out.println("\n----\nMonstruos que quitan armaduras:\n----\n");
        ArrayList<TreasureKind> tesoros = new ArrayList();
        tesoros.add(TreasureKind.ARMOR);
        System.out.println(pierdeTesoros(monsters,tesoros).toString());
    }
    
    /**
     * Monstruos a partir de un nivel.
     * @param listado Listado de monstruos sobre los que se filtrará.
     * @param nivel Nivel a partir del cual se filtran.
     * @return Listado de mounstruos superiores al nivel dado.
     */
    public static ArrayList<Monster> nivelSuperior (ArrayList<Monster> listado, int nivel) {
        ArrayList<Monster> filtrados = new ArrayList();
        
        for (Monster actual : listado)
            if (actual.getLevel() >= nivel)
                filtrados.add(actual);       
        
        return filtrados;
    }
    
    /**
     * Monstruos que sólo quitan niveles.
     * @param listado Lista completa de monstruos.
     * @return Lista de monstruos que sólo quitan niveles.
     */
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
    
    /**
     * Monstruos que permiten ganar niveles.
     * @param listado Listado completo de monstruos.
     * @return Lista de monstruos que permiten ganar niveles.
     */
    public static ArrayList<Monster> ganaMasDeUnNivel (ArrayList<Monster> listado) {
        ArrayList<Monster> filtrados = new ArrayList(); 
        
        for (Monster actual : listado) {
            Prize prize = actual.getPrize();
            
            if ((prize.getLevels() > 1))
                 filtrados.add(actual);
           
        }
        return filtrados; 
    }
    
    /**
     * Devuelve los monstruos que quitan tesoros específicos.
     * @param listado Listado total de monstruos.
     * @param tesoros Tesoros específicos.
     * @return Monstruos que quitan los tesoros dados.
     */
    public static ArrayList<Monster> pierdeTesoros (ArrayList<Monster> listado, 
            ArrayList<TreasureKind> tesoros){
        ArrayList<Monster> filtrados = new ArrayList();
         
        for (Monster actual : listado) {
            // Añadimos los tesoros que pueden perderse a una lista.
            ArrayList<TreasureKind> quitados = new ArrayList();
            
            quitados.addAll(actual.getBadConsequence().getSpecificVisibleTreasures());
            quitados.addAll(actual.getBadConsequence().getSpecificHiddenTreasures()); 
            
            if (quitados.containsAll(tesoros))
                filtrados.add(actual);
        }
        
        return filtrados; 
    }
}
