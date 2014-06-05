package Game;

/**
 * @date 21/02/2014
 * @author José Carlos Entrena
 * @author Óscar Bermúdez
 * @author Mario Román
 */
public enum TreasureKind {
    ARMOR, ONEHAND, BOTHHANDS, HELMET, SHOE, NECKLACE;
    
    @Override
    public String toString(){
        String tipo;
        
        switch (this) {
            case ARMOR: {
                tipo = "Armadura";
                break;
            }
            case BOTHHANDS: {
                tipo = "Arma de dos manos";
                break;
            }
            case ONEHAND: {
                tipo = "Arma de una mano";
                break;
            }
            case SHOE: {
                tipo = "Calzado";
                break;
            }
            case HELMET: {
                tipo = "Casco";
                break;
            }
            case NECKLACE: {
                tipo = "Collar";
                break;
            }
            default: {
                tipo = "ERROR";
                break;
            }
        }
        
        return tipo; 
    }
}
