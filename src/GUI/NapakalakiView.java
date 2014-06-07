/**
 * NapakalakiView.java
 * @author Jose Carlos Entrena
 * @author Mario Román 
 * @author Óscar Bermúdez
 */

package GUI;
import Game.*;
import java.util.HashSet;
import java.util.Set;


public class NapakalakiView extends javax.swing.JFrame {

    Napakalaki napakalakiModel; 
    
    /**
     * Creates new form NapakalakiView
     */
    public NapakalakiView() {
        initComponents();
        playerView.disableMakeVisible();
        playerView.disableDiscard();
        buttonNextTurn.setEnabled(false);
    }
    
    public void setNapakalaki(Napakalaki nueva) {
        napakalakiModel = nueva;
        playerView.setNapakalaki(napakalakiModel); 
        monsterView.setMonster(nueva.getCurrentMonster());
        playerView.setPlayer(nueva.getCurrentPlayer());
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonCombat = new javax.swing.JButton();
        buttonNextTurn = new javax.swing.JButton();
        monsterView = new GUI.MonsterView();
        playerView = new GUI.PlayerView();
        labelCombatResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonCombat.setText("Combatir");
        buttonCombat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCombatActionPerformed(evt);
            }
        });

        buttonNextTurn.setText("Siguente Turno");
        buttonNextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextTurnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(monsterView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(labelCombatResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCombat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonNextTurn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monsterView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCombatResult, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCombat)
                    .addComponent(buttonNextTurn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCombatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCombatActionPerformed
        CombatResult result = napakalakiModel.combat(); 
        
        switch (result) {
            case WIN:  labelCombatResult.setText("Has derrotado al monstruo.");
                break;
            case WINANDWINGAME:  labelCombatResult.setText("Has ganado el combate y el juego. ¡Enhorabuena!");
                                 buttonNextTurn.setEnabled(false);
                break;
            case LOSE:  labelCombatResult.setText("Has sido derrotado. Ahora se te aplicará el mal rollo del monstruo.");
                break;
            case LOSEANDDIE:  labelCombatResult.setText("Has sido derrotado y has muerto.");
                break;
            case LOSEANDESCAPE:  labelCombatResult.setText("Has logrado escapar del combate a salvo.");
                break;
            case LOSEANDCONVERT: labelCombatResult.setText("Has sido derrotado. ¡Ahora eres sectario!"); 
                break;
            default: labelCombatResult.setText("Error en el combate.");
                break;
        }
        
        buttonCombat.setEnabled(false);
        buttonNextTurn.setEnabled(true);
        repaint();
        
        // Necesario para ver los tesoros que se ganan en el combate. 
        if(napakalakiModel.nextTurn()){
            playerView.enableMakeVisible();
        }
        playerView.enableDiscard();
        playerView.disableBuyLevels();
        playerView.paint();
        
        buttonCombat.setEnabled(false); 
        repaint();
    }//GEN-LAST:event_buttonCombatActionPerformed

    private void buttonNextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextTurnActionPerformed
        // Si no se puede pasar turno, nada cambia.
        if (napakalakiModel.nextTurnAllowed()){
            napakalakiModel.nextTurn();
            
            labelCombatResult.setText("");
            monsterView.setMonster(napakalakiModel.getCurrentMonster()); 
            playerView.setPlayer(napakalakiModel.getCurrentPlayer());
            
            //Ajuste de botones
            buttonNextTurn.setEnabled(false);
            buttonCombat.setEnabled(true);
            playerView.enableBuyLevels();
            
            //Actualizando pantalla
            repaint();
        }
    }//GEN-LAST:event_buttonNextTurnActionPerformed

    public void showView() {
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCombat;
    private javax.swing.JButton buttonNextTurn;
    private javax.swing.JLabel labelCombatResult;
    private GUI.MonsterView monsterView;
    private GUI.PlayerView playerView;
    // End of variables declaration//GEN-END:variables
}
