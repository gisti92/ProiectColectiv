/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import businessLogic.Controller;
import gui.director.ProjectManagement;
import gui.director.programestudiu.ProgrameDeStudiu;
import javax.swing.JFrame;
import model.director.Proiect;
import model.director.Proiect.ProjectType;

/**
 *
 * @author S7eve
 */
public class UiDirector extends javax.swing.JFrame {
        
    private static UiDirector instance = null;
    private Controller contr = null;

    /**
     * Creates new form UiPublic
     */
    private UiDirector() {
        contr = Controller.getInstance();
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                exit();
            }
        });
        
    }
    
    public static UiDirector getInstance() {
        if (instance == null) {
                    instance = new UiDirector();
        }
        return instance;
    }
    
    private void exit() {
        dispose();
        LoginPage.getInstance().reOpen();
    }
    
    public void reOpen(String name) {
        setTitle(name);
        setName(name);
        setVisible(true);
        // resetarea fereastrei
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        granturiCercetareButton = new javax.swing.JButton();
        evenimentAdministrativButton = new javax.swing.JButton();
        programDeStudiu = new javax.swing.JButton();
        raportDeAlocareButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        granturiCercetareButton.setText("Granturi de cercetare");
        granturiCercetareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                granturiCercetareButtonActionPerformed(evt);
            }
        });

        evenimentAdministrativButton.setText("Evenimente administrative");
        evenimentAdministrativButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evenimentAdministrativButtonActionPerformed(evt);
            }
        });

        programDeStudiu.setText("Programe de studiu");
        programDeStudiu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programDeStudiuActionPerformed(evt);
            }
        });

        raportDeAlocareButton.setText("Rapoarte de alocare");

        okButton.setText("OK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(granturiCercetareButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(evenimentAdministrativButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(programDeStudiu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(raportDeAlocareButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(granturiCercetareButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(evenimentAdministrativButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(programDeStudiu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(raportDeAlocareButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(okButton)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void evenimentAdministrativButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evenimentAdministrativButtonActionPerformed
        
        ProjectManagement prj = new ProjectManagement(ProjectType.EVENIMENT_ADMINISTRATIV);
        prj.setVisible(true);
        
    }//GEN-LAST:event_evenimentAdministrativButtonActionPerformed

    private void granturiCercetareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_granturiCercetareButtonActionPerformed
        
        ProjectManagement prj = new ProjectManagement(ProjectType.PROIECT_STIINTIFIC);
        prj.setVisible(true);
        
    }//GEN-LAST:event_granturiCercetareButtonActionPerformed

    private void programDeStudiuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programDeStudiuActionPerformed
        
        ProgrameDeStudiu stud = new ProgrameDeStudiu(this,true);
        stud.setVisible(true);
        
    }//GEN-LAST:event_programDeStudiuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton evenimentAdministrativButton;
    private javax.swing.JButton granturiCercetareButton;
    private javax.swing.JButton okButton;
    private javax.swing.JButton programDeStudiu;
    private javax.swing.JButton raportDeAlocareButton;
    // End of variables declaration//GEN-END:variables
}
