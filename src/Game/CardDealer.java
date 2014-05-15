package Game;

import java.util.*;

/**
 * @date 27/02/2014
 * @author Mario Román
 * @author José Carlos Entrena
 * @author Óscar Bermúdez
 */
public class CardDealer {
    // Atributos
    private static final CardDealer instance = new CardDealer();
    private ArrayList<Treasure> usedTreasures = new ArrayList<>(); 
    private ArrayList<Treasure> unusedTreasures = new ArrayList<>(); 
    private ArrayList<Monster> usedMonsters = new ArrayList<>(); 
    private ArrayList<Monster> unusedMonsters = new ArrayList<>(); 
    
    // Patrón Singleton.
    // El constructor privado nos asegura que no se puede instanciar desde otras clases
    private CardDealer() {
    }
    
    public static CardDealer getInstance() {
        return instance;
    }
    
    
    // Métodos privados.
    private void initTreasureCardDeck() {
        //Tesoros añadidos por orden de aparición en el guión.
        // ¡Sí, mi amo!
        unusedTreasures.add(new Treasure("¡Sí, mi amo!", 0, 4, 7, TreasureKind.HELMET));

        // Botas de investigación
        unusedTreasures.add(new Treasure("Botas de investigación", 600, 3, 4, TreasureKind.SHOE));

        // Capucha de Cthulhu
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.HELMET));

        // A prueba de babas verdes
        unusedTreasures.add(new Treasure("A prueba de babas verdes", 400, 3, 5, TreasureKind.ARMOR));

        // Botas de lluvia  ́acida
        unusedTreasures.add(new Treasure("Botas de lluvia  ́acida", 800, 1, 1, TreasureKind.BOTHHANDS));

        // Casco minero
        unusedTreasures.add(new Treasure("Casco minero", 400, 2, 4, TreasureKind.HELMET));

        // Ametralladora Thompson
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 600, 4, 8, TreasureKind.BOTHHANDS));

        // Camiseta de la UGR
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 100, 1, 7, TreasureKind.ARMOR));

        // Clavo de rail ferroviario
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 400, 3, 6, TreasureKind.ONEHAND));

        // Cuchillo de sushi arcano
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 300, 2, 3, TreasureKind.ONEHAND));

        // Fez Alópodo
        unusedTreasures.add(new Treasure("Fez Alópodo", 700, 3, 5, TreasureKind.HELMET));

        // Hacha prehistórica
        unusedTreasures.add(new Treasure("Hacha prehistórica", 500, 2, 5, TreasureKind.ONEHAND));

        // El aparato del Pr. Tesla
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 900, 4, 8, TreasureKind.ARMOR));

        // Gaita
        unusedTreasures.add(new Treasure("Gaita", 200, 1, 5, TreasureKind.BOTHHANDS));

        // Insecticida
        unusedTreasures.add(new Treasure("Insecticida", 300, 2, 3, TreasureKind.ONEHAND));

        // Escopeta de 3 cañones
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 700, 4, 6, TreasureKind.BOTHHANDS));

        // Garabato místico
        unusedTreasures.add(new Treasure("Garabato místico", 300, 2, 2, TreasureKind.ONEHAND));

        // La fuerza de Mr. T
        unusedTreasures.add(new Treasure("La fuerza de Mr. T", 1000, 0, 0, TreasureKind.NECKLACE));

        // La rebeca metálica
        unusedTreasures.add(new Treasure("La rebeca metálica", 400, 2, 3, TreasureKind.ARMOR));

        // Mazo de los antiguos
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 200, 3, 4, TreasureKind.ONEHAND));

        // Necro-playboycón
        unusedTreasures.add(new Treasure("Necro-playboycón", 300, 3, 5, TreasureKind.ONEHAND));

        // Lanzallamas
        unusedTreasures.add(new Treasure("Lanzallamas", 800, 4, 8, TreasureKind.BOTHHANDS));

        // Necro-comicón
        unusedTreasures.add(new Treasure("Necro-comicón", 100, 1, 1, TreasureKind.ONEHAND));

        // Necronomicón
        unusedTreasures.add(new Treasure("Necronomicón", 800, 5, 7, TreasureKind.BOTHHANDS));

        // Linterna a 2 manos
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 400, 3, 6, TreasureKind.BOTHHANDS));

        // Necro-gnomicón
        unusedTreasures.add(new Treasure("Necro-gnomicón", 200, 2, 4, TreasureKind.ONEHAND));

        // Necrotelecom
        unusedTreasures.add(new Treasure("Necrotelecom", 300, 2, 3, TreasureKind.HELMET));

        // Porra preternatural
        unusedTreasures.add(new Treasure("Porra preternatural", 200, 2, 3, TreasureKind.ONEHAND));

        // Tentáculo de pega
        unusedTreasures.add(new Treasure("Tentáculo de pega", 200, 0, 1, TreasureKind.HELMET));

        // Zapatillas deja-amigos
        unusedTreasures.add(new Treasure("Zapatillas deja-amigos", 500, 0, 1, TreasureKind.SHOE));

        // Shogulador
        unusedTreasures.add(new Treasure("Shogulador", 600, 1, 1, TreasureKind.BOTHHANDS));

        // Varita de atizamiento
        unusedTreasures.add(new Treasure("Varita de atizamiento", 400, 3, 4, TreasureKind.ONEHAND));
    }
    
    private void initMonsterCardDeck() {
        BadConsequence bad;
        Prize prize;
        ArrayList<TreasureKind> tvp = new ArrayList();
        ArrayList<TreasureKind> thp = new ArrayList(); 
        
        // Monstruos añadidos por orden de aparición en el guión. 
        
        // 3 Byakhees de bonanza.
        tvp.add(TreasureKind.ARMOR);
        thp.add(TreasureKind.ARMOR);
        bad = new BadConsequence("Pierdes tu armadura visible y otra oculta.", 0, tvp, thp);
        tvp.clear();
        thp.clear();
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, bad, prize));
        
        
        // Chibithulhu 
        tvp.add(TreasureKind.HELMET); 
        bad = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible.", 0, tvp, thp);
        tvp.clear();
        prize = new Prize(1,1); 
        unusedMonsters.add(new Monster("Chibithulhu", 2, bad, prize)); 

        
        // El sopor de Dunwich
        tvp.add(TreasureKind.SHOE); 
        bad = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.", 0, tvp, thp);
        tvp.clear();
        prize = new Prize(1,1); 
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, bad, prize)); 
        
        
        // Ángeles de la noche ibicenca
        tvp.add(TreasureKind.ONEHAND);
        thp.add(TreasureKind.ONEHAND);
        bad = new BadConsequence("Te atrapan para llevarte de "
                + "fiesta y te dejan caer en mitad del vuelo. "
                + "Descarta 1 mano visible y 1 mano oculta.", 0, tvp, thp);
        tvp.clear();
        thp.clear();
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, bad, prize));
        
        
        // El gorrón en el umbral
            bad = new BadConsequence("Pierdes todos tus tesoros visibles.", 0, 99, 0);
        prize = new Prize(3,1); 
        unusedMonsters.add(new Monster("El gorrón en el umbral", 10, bad, prize)); 
        
        
        // H.P. Munchcraft
        tvp.add(TreasureKind.ARMOR); 
        bad = new BadConsequence("Pierdes la armadura visible.", 0, tvp, thp);
        tvp.clear(); 
        prize = new Prize(2,1); 
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, bad, prize)); 
        
        
        // Bichgooth
        tvp.add(TreasureKind.ARMOR); 
        bad = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.", 0, tvp, thp);
        tvp.clear();
        prize = new Prize(1,1); 
        unusedMonsters.add(new Monster("Bichgooth", 2, bad, prize)); 
        
        
        // El rey de rosa
        bad = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, bad, prize)); 
        
        
        // La que redacta en las sombras. 
        bad = new BadConsequence("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0); 
        prize = new Prize(1,1); 
        unusedMonsters.add(new Monster("La que redacta en las sombras", 3, bad, prize));
        
        
        // Los hondos verdes
        bad = new BadConsequence("Estos monstruos resultan "
                + "bastante superficiales y te aburren mortalmente. "
                + "Estás muerto.", true);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos verdes", 7, bad, prize)); 
        
        
        // Semillas Cthulhu
        bad = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2); 
        prize = new Prize(2,1); 
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, bad, prize));
        
        
        // Dameargo
        tvp.add(TreasureKind.ONEHAND); 
        bad = new BadConsequence("Te intentas escapar. Pierdes una mano visible.", 0, tvp, thp);
        tvp.clear();
        prize = new Prize(2,1); 
        unusedMonsters.add(new Monster("Dameargo", 1, bad, prize)); 
         
        
        // Pollipólipo volante
        bad = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0); 
        prize = new Prize(1,1); 
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, bad, prize)); 
        
        
        // Yskhtihyssg-Goth
        bad = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto.", true); 
        prize = new Prize(3,1); 
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, bad, prize)); 
        
        
        // Familia feliz. 
        bad = new BadConsequence("La familia te atrapa. Estás muerto.", true); 
        prize = new Prize(4,1); 
        unusedMonsters.add(new Monster("Familia feliz", 1, bad, prize)); 
        
        
        // Roboggoth 
        tvp.add(TreasureKind.BOTHHANDS); 
        bad = new BadConsequence("La quinta directiva primaria "
                + "te obliga a perder 2 niveles y un tesoro 2 manos visible.", 2
                , tvp, thp);
        tvp.clear();
        prize = new Prize(2,1); 
        unusedMonsters.add(new Monster("Roboggoth", 8, bad, prize)); 
        
        
        // El espía ciego.
        tvp.add(TreasureKind.HELMET); 
        bad = new BadConsequence("Te asusta en la noche. "
                + "Pierdes un casco visible.", 0, tvp, thp);
        tvp.clear();
        prize = new Prize(1,1); 
        unusedMonsters.add(new Monster("El espía ciego", 4, bad, prize)); 
        
        
        // El Lenguas
        bad = new BadConsequence("Menudo susto te llevas. Pierdes "
                + "2 niveles y 5 tesoros visibles.", 2, 5, 0); 
        prize = new Prize(1,1); 
        unusedMonsters.add(new Monster("El Lenguas", 20, bad, prize)); 
        
        
        // Bicéfalo
        tvp.add(TreasureKind.BOTHHANDS);
        tvp.add(TreasureKind.ONEHAND);
        tvp.add(TreasureKind.ONEHAND);
        bad = new BadConsequence("Te faltan manos para tanta cabeza."
                + " Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, tvp, thp);
        tvp.clear();
        prize = new Prize(1,1); 
        unusedMonsters.add(new Monster("Bicéfalo", 20, bad, prize));
        
        // El mal indecible impronunciable
        tvp.add(TreasureKind.ONEHAND);
        bad = new BadConsequence("Pierdes 1 mano visible.", 0, tvp, thp);
        tvp.clear();
        prize = new Prize(3,1); 
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, bad, prize, -2));
        
        // Testigos oculares
        bad = new BadConsequence("Pierdes tus tesoros visibles. Jajaja", 0, 99, 0);
        prize = new Prize(2,1); 
        unusedMonsters.add(new Monster("Testigos oculares", 6, bad, prize, 2));
        
        // El gran Cthulhu
        bad = new BadConsequence("Hoy no es tu día de suerte. Mueres", true);
        prize = new Prize(2,5); 
        unusedMonsters.add(new Monster("El gran Cthulhu", 20, bad, prize, 4));
        
        // Serpiente Político
        bad = new BadConsequence("Tu gobierno te recorta 2 niveles.", 2, 0, 0);
        prize = new Prize(2,1); 
        unusedMonsters.add(new Monster("Serpiente Político", 8, bad, prize, -2));
        
        // Felpuggoth
        tvp.add(TreasureKind.HELMET);
        tvp.add(TreasureKind.ARMOR);
        for(int i = 0; i < 4; i++){
            thp.add(TreasureKind.BOTHHANDS);
            thp.add(TreasureKind.ONEHAND);
        }
        bad = new BadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas", 0, tvp, thp);
        tvp.clear();
        thp.clear();
        prize = new Prize(1,1); 
        unusedMonsters.add(new Monster("Felpuggoth", 2, bad, prize, 5));
        
        // Shoggoth
        bad = new BadConsequence("Pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(4,2); 
        unusedMonsters.add(new Monster("Shoggoth", 16, bad, prize, -4));
        
        // Lolitagooth
        bad = new BadConsequence("Puntalabios negro. Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo", 2, bad, prize, 3));
    }
    
    private void shuffleTreasures() {
        long seed = System.nanoTime();
        Collections.shuffle(unusedTreasures, new Random(seed));
    }
    
    private void shuffleMonsters() {
        long seed = System.nanoTime();
        Collections.shuffle(unusedMonsters, new Random(seed));
    } 
    
    // Métodos públicos.
    /**
     * Devuelve el siguiente tesoro. En caso de que se hayan usado todos, los vuelve a poner 
     * como no usados y los vuelve a barajar. 
     * @return Treasure siguiente tesoro. 
     */
    public Treasure nextTreasure() {    
        if (unusedTreasures.isEmpty()) {
            ArrayList<Treasure> temp = unusedTreasures;
            unusedTreasures = usedTreasures;
            usedTreasures = temp;
            shuffleTreasures(); 
        }
        
        Treasure next = unusedTreasures.remove(0);
        
        return next;
    }
    /**
     * Devuelve el siguiente monstruo. En caso de que hayan salido todos, los vuelve a poner 
     * como no usados y los vuelve a barajar. 
     * @return Monster siguiente monstruo. 
     */
    public Monster nextMonster() {
        if (unusedMonsters.isEmpty()) {
            ArrayList<Monster> temp = unusedMonsters;
            unusedMonsters = usedMonsters;
            usedMonsters = temp;
            shuffleMonsters(); 
        }
        
        Monster next = unusedMonsters.remove(0);
        
        return next;
    }
    
    public void giveTreasureBack(Treasure treasure) {
        usedTreasures.add(treasure);
    }
    
    public void giveMonsterBack(Monster monster) {
        usedMonsters.add(monster);
    }
    
    public void initCards() {
        initTreasureCardDeck();
        initMonsterCardDeck();
        shuffleTreasures(); 
        shuffleMonsters(); 
    }
    
    @Override
    public String toString() {
        return "Mazo de monstruos: (" + usedMonsters.size() + "/" + unusedMonsters.size()
                + ")\nMazo de tesoros: (" + usedTreasures.size() + "/" + unusedTreasures.size() + ")";
    }
}
