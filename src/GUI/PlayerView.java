package GUI;
import Game.*;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * @author José Carlos Entrena
 * @author Mario Román
 * @author Óscar Bermúdez
 */
public class PlayerView extends javax.swing.JPanel {
    Player playerModel; 
    private Napakalaki napakalakiModel;

    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }

    public void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> treasureList) {
        // Se eliminan los elementos y se añaden los nuevos. 
        aPanel.removeAll(); 
        for (Treasure t : treasureList){
            TreasureView treasureView = new TreasureView(); 
            treasureView.setTreasure(t); 
            treasureView.setVisible(true);
            aPanel.add(treasureView); 
        }
        
        aPanel.repaint(); 
        aPanel.revalidate(); 
    }
    
    public void setPlayer(Player p){
        playerModel = p; 
        nameLabel.setText(playerModel.getName());
        levelLabel.setText(Integer.toString(playerModel.getLevel()));
        combatLevelLabel.setText(Integer.toString(playerModel.getCombatLevel()));
        // Si es un sectario actualizamos su carta de sectario. 
        if (playerModel.getClass() == CultistPlayer.class)
            cultistView.setCultist(((CultistPlayer) playerModel).getCultistCard());
        
        fillTreasurePanel(visibleTreasuresPanel, playerModel.getVisibleTreasures());
        fillTreasurePanel(hiddenTreasuresPanel, playerModel.getHiddenTreasures());
        repaint();
        revalidate();
    }
    
    public void setNapakalaki(Napakalaki nueva) {
        napakalakiModel = nueva; 
        repaint(); 
    }
    
    
    // Nos permite reimprimir desde NapakalakiView
    public void paint(){
        repaint(); 
    }
    
    // Métodos para desactivar y activar botones desde NapakalakiView
    
    public void disableBuyLevels(){
        buyLevelsButton.setEnabled(false);
    }
    
    public void enableBuyLevels(){
        buyLevelsButton.setEnabled(true); 
    }
    
    public void disableDiscard(){
        discardTreasuresButton.setEnabled(false); 
    }
    
    public void enableDiscard(){
        discardTreasuresButton.setEnabled(true); 
    }
    
    public void disableMakeVisible(){
        makeTreasuresVisibleButton.setEnabled(false); 
    }
    
    public void enableMakeVisible(){
        makeTreasuresVisibleButton.setEnabled(true); 
    }
    
    
    
    public ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {
        TreasureView treasureView;
        ArrayList<Treasure> selected = new ArrayList();
        
        for(Component treasure : aPanel.getComponents()) {
            treasureView = (TreasureView) treasure;
            
            if(treasureView.isSelected())
                selected.add (treasureView.getTreasure());
            }
        return selected;
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        nivel = new javax.swing.JLabel();
        levelLabel = new javax.swing.JLabel();
        visibleTreasuresPanel = new javax.swing.JPanel();
        hiddenTreasuresPanel = new javax.swing.JPanel();
        nivelCombate = new javax.swing.JLabel();
        combatLevelLabel = new javax.swing.JLabel();
        cultistView = new GUI.CultistView();
        buyLevelsButton = new javax.swing.JButton();
        makeTreasuresVisibleButton = new javax.swing.JButton();
        discardTreasuresButton = new javax.swing.JButton();
        visibleTreasureLabel = new javax.swing.JLabel();
        hiddenTreasuresLabel = new javax.swing.JLabel();

        nameLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        nameLabel.setText("Nombre");

        nivel.setText("Nivel");

        levelLabel.setText("Nº nivel");

        nivelCombate.setText("Nivel de Combate");

        combatLevelLabel.setText("CombatLevel");

        buyLevelsButton.setText("Comprar Niveles");
        buyLevelsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyLevelsButtonActionPerformed(evt);
            }
        });

        makeTreasuresVisibleButton.setText("Equipar");
        makeTreasuresVisibleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeTreasuresVisibleButtonActionPerformed(evt);
            }
        });

        discardTreasuresButton.setText("Eliminar Tesoros");
        discardTreasuresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardTreasuresButtonActionPerformed(evt);
            }
        });

        visibleTreasureLabel.setText("Visibles:");

        hiddenTreasuresLabel.setText("Ocultos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(visibleTreasuresPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hiddenTreasuresPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(visibleTreasureLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nivelCombate)
                                            .addComponent(nivel))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(levelLabel)
                                            .addComponent(combatLevelLabel))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cultistView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(hiddenTreasuresLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buyLevelsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(makeTreasuresVisibleButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(discardTreasuresButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nivel)
                            .addComponent(levelLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nivelCombate)
                            .addComponent(combatLevelLabel)))
                    .addComponent(cultistView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visibleTreasureLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visibleTreasuresPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hiddenTreasuresLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hiddenTreasuresPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discardTreasuresButton)
                    .addComponent(makeTreasuresVisibleButton)
                    .addComponent(buyLevelsButton)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void makeTreasuresVisibleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeTreasuresVisibleButtonActionPerformed
        
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasuresPanel);
        
        for(Treasure treasure : selHidden){
            napakalakiModel.makeTreasureVisible(treasure);
        }
        
        setPlayer(napakalakiModel.getCurrentPlayer());
        repaint(); 
    }//GEN-LAST:event_makeTreasuresVisibleButtonActionPerformed

    private void discardTreasuresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardTreasuresButtonActionPerformed
        
        // Eliminación de tesoros. 
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasuresPanel);
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreasuresPanel);
        
        for(Treasure treasure : selHidden){
            napakalakiModel.discardHiddenTreasure(treasure);
        }
        
        for(Treasure treasure : selVisible){
            napakalakiModel.discardVisibleTreasure(treasure);
        }
        
        setPlayer(napakalakiModel.getCurrentPlayer());
        
        // Si el mal rollo es vacío, activamos el botón de equipar tesoros. 
        if (playerModel.validState()){
            this.enableMakeVisible();
        }
        
        repaint(); 
    }//GEN-LAST:event_discardTreasuresButtonActionPerformed

    private void buyLevelsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyLevelsButtonActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasuresPanel);
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreasuresPanel);
        
        napakalakiModel.buyLevels(selVisible, selHidden);
        
        setPlayer(napakalakiModel.getCurrentPlayer());
        repaint(); 
    }//GEN-LAST:event_buyLevelsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyLevelsButton;
    private javax.swing.JLabel combatLevelLabel;
    private GUI.CultistView cultistView;
    private javax.swing.JButton discardTreasuresButton;
    private javax.swing.JLabel hiddenTreasuresLabel;
    private javax.swing.JPanel hiddenTreasuresPanel;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JButton makeTreasuresVisibleButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nivel;
    private javax.swing.JLabel nivelCombate;
    private javax.swing.JLabel visibleTreasureLabel;
    private javax.swing.JPanel visibleTreasuresPanel;
    // End of variables declaration//GEN-END:variables
}
