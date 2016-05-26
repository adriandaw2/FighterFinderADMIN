/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fighterfinderadmin.view;

import fighterfinderadmin.controller.Controller;
import fighterfinderadmin.entities.ACharacter;
import fighterfinderadmin.entities.AGame;
import fighterfinderadmin.entities.Model;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Adrian
 */
public class ModCharacterPanel extends javax.swing.JPanel {
    
    private Controller myController;
    private Model myModel;
    private List<AGame> aGList;
    private int gameCharID;
    private int charId;
    private String charName;
    /**
     * Creates new form ModCharacterPanel
     */
    public ModCharacterPanel() {
        initComponents();
    }
    
    public ModCharacterPanel(Controller aController, Model aModel) {
        initComponents();
        this.aGList = new ArrayList();
        this.gameCharID = -1;
        this.charId = -1;
        this.charName = "";
        this.myController = aController;
        this.myModel = aModel;
        this.myModel.setMyGameList(this.myController.getAllGamesFromDatabase());
        //fillGamesCombobox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        characterNameToModTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        modCharacterBtn = new javax.swing.JButton();
        charGameToMod = new javax.swing.JTextField();
        searchCharIDTF = new javax.swing.JTextField();
        searchCharBtn = new javax.swing.JButton();
        gameHelpBtn = new javax.swing.JButton();

        jLabel2.setText("Character to mod: ");

        jLabel3.setText("Character name: ");

        characterNameToModTF.setEnabled(false);

        jLabel4.setText("Character game ID: ");

        modCharacterBtn.setText("Mod character");
        modCharacterBtn.setEnabled(false);
        modCharacterBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modCharacterBtnMouseClicked(evt);
            }
        });

        charGameToMod.setEnabled(false);

        searchCharBtn.setText("Search character");
        searchCharBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchCharBtnMouseClicked(evt);
            }
        });

        gameHelpBtn.setText("Game help");
        gameHelpBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gameHelpBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(characterNameToModTF, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(charGameToMod, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(gameHelpBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(modCharacterBtn)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchCharIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchCharBtn)
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(searchCharIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchCharBtn))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(characterNameToModTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(charGameToMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modCharacterBtn)
                    .addComponent(gameHelpBtn))
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchCharBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchCharBtnMouseClicked
        // TODO add your handling code here:
        try{
            this.charId = Integer.parseInt(searchCharIDTF.getText());
            ACharacter resChar = this.myController.getOneCharacterInfo(this.charId);
            if(resChar != null)
            {
                this.charId = resChar.getId();
                fillTextsWithData(resChar);
            }else{
                JOptionPane.showMessageDialog(this, "Character not found, please search again ", "Search character", JOptionPane.INFORMATION_MESSAGE);
                disabelTextAndButton();
            }
        }catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Character ID to search must be a number", "Search character", JOptionPane.INFORMATION_MESSAGE);
            disabelTextAndButton();
        }
        
    }//GEN-LAST:event_searchCharBtnMouseClicked

    private void modCharacterBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modCharacterBtnMouseClicked
        // TODO add your handling code here:
        int newGameId = -1;
        String newCharName = "";
        try{
            newGameId = Integer.parseInt(charGameToMod.getText());
            newCharName = characterNameToModTF.getText();
            if(newCharName.length() < 1 || newGameId < 1)
            {
                JOptionPane.showMessageDialog(this, "Data is not correct", "Mod character info", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                this.myController.modifyCharacter(newCharName, newGameId, this.charId);
            }
        }catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Game id must be a number", "Mod character info", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_modCharacterBtnMouseClicked

    private void gameHelpBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameHelpBtnMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, this.myModel.toStringAllGamesInfo(), "All games info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_gameHelpBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField charGameToMod;
    private javax.swing.JTextField characterNameToModTF;
    private javax.swing.JButton gameHelpBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton modCharacterBtn;
    private javax.swing.JButton searchCharBtn;
    private javax.swing.JTextField searchCharIDTF;
    // End of variables declaration//GEN-END:variables

    private void fillGamesCombobox() {
        this.myModel.setMyGameList(this.myController.getAllGamesFromDatabase());
        //this.currentGameID = this.myModel.getMyGameList().get(0).getId();
        //modCharGameListCB.setModel(new DefaultComboBoxModel(this.myModel.getMyGameList().toArray()));
    }

    private void fillTextsWithData(ACharacter resChar) {
        enableTextsAndButton();
        characterNameToModTF.setText(resChar.getName());
        charGameToMod.setText(String.valueOf(resChar.getIdGame()));
    }
    
    private void enableTextsAndButton()
    {
        characterNameToModTF.setEnabled(true);
        charGameToMod.setEnabled(true);
        modCharacterBtn.setEnabled(true);
    }
    
    private void disabelTextAndButton()
    {
        characterNameToModTF.setEnabled(false);
        charGameToMod.setEnabled(false);
        modCharacterBtn.setEnabled(false);
        characterNameToModTF.setText("");
        charGameToMod.setText("");
    }
}
