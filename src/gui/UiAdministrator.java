/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import businessLogic.AdministratorController;
import gui.administrator.gestionezaresurse.GestioneazaResurseUmane;
import javax.swing.JFrame;

import businessLogic.Controller;
import gui.administrator.gestionezaresurse.GestioneazaResurseFinanciare;
import gui.administrator.gestionezaresurse.GestioneazaResurseLogistice;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.users.User;

/**
 *
 * @author S7eve
 */
@SuppressWarnings("serial")
public class UiAdministrator extends javax.swing.JFrame {
    private static UiAdministrator instance = null;
    private AdministratorController contr = AdministratorController.getInstance();

    /**
     * Creates new form UiPublic
     */
    private UiAdministrator() {
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

    public static UiAdministrator getInstance() {
        if (instance == null) {
            instance = new UiAdministrator();
        }
        return instance;
    }

    private void exit() {
        dispose();
        LoginPage.getInstance().reOpen();
    }

    public void reOpen(User user) {
        setTitle(user.getName());
        setVisible(true);
        // resetarea fereastrei
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnImportaOrar = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnImportaState = new javax.swing.JButton();
        btnInregResUmane = new javax.swing.JButton();
        btnInregResFinanciare = new javax.swing.JButton();
        btnInregResLogistice = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnImportaOrar.setText("Importa orarul");
        btnImportaOrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportaOrarActionPerformed(evt);
            }
        });

        btnExit.setText("Close");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnImportaState.setText("Importa state de functii");
        btnImportaState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportaStateActionPerformed(evt);
            }
        });

        btnInregResUmane.setText("Inregistreaza resurse umane");
        btnInregResUmane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInregResUmaneActionPerformed(evt);
            }
        });

        btnInregResFinanciare.setText("Inregistreaza resurse financiare");
        btnInregResFinanciare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInregResFinanciareActionPerformed(evt);
            }
        });

        btnInregResLogistice.setText("Inregistreaza resurse logistice");
        btnInregResLogistice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInregResLogisticeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnImportaOrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImportaState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInregResUmane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInregResFinanciare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInregResLogistice, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnImportaOrar)
                .addGap(18, 18, 18)
                .addComponent(btnImportaState)
                .addGap(18, 18, 18)
                .addComponent(btnInregResUmane)
                .addGap(18, 18, 18)
                .addComponent(btnInregResFinanciare)
                .addGap(18, 18, 18)
                .addComponent(btnInregResLogistice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImportaOrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportaOrarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selectati fisierul care contine orarul");
        int result = fileChooser.showOpenDialog(this);
        switch (result) {
            case JFileChooser.APPROVE_OPTION:
                File curFile = fileChooser.getSelectedFile();
                String fileName = curFile.getAbsolutePath();
                if (contr.importOrar(fileName)){
                    JOptionPane.showMessageDialog(this, "Importare incheiata cu succes", "Succes", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(this, "Importare nereusita! ", "Eroare", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case JFileChooser.ERROR_OPTION:
                System.out.println("Eroare la selectare fisier");
                break;
        }
    }//GEN-LAST:event_btnImportaOrarActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        exit();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnImportaStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportaStateActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setDialogTitle("Selectati fisierul care contine statele de functii");
        int result = fileChooser.showOpenDialog(this);
        switch (result) {
            case JFileChooser.APPROVE_OPTION:
                File curFile = fileChooser.getSelectedFile();
                String fileName = curFile.getAbsolutePath();
                if (contr.importStateDeFunctii(fileName)){
                    JOptionPane.showMessageDialog(this, "Importare incheiata cu succes", "Succes", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(this, "Importare nereusita! ", "Eroare", JOptionPane.ERROR_MESSAGE);
                }
                
                break;
            case JFileChooser.ERROR_OPTION:
                System.out.println("Eroare la selectare fisier");
                break;
        }

    }//GEN-LAST:event_btnImportaStateActionPerformed

    private void btnInregResUmaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInregResUmaneActionPerformed
        setVisible(false);
        new GestioneazaResurseUmane(this,true).setVisible(true);
        setVisible(true);
    }//GEN-LAST:event_btnInregResUmaneActionPerformed

    private void btnInregResFinanciareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInregResFinanciareActionPerformed
        setVisible(false);
        new GestioneazaResurseFinanciare(this,true).setVisible(true);
        setVisible(true);
    }//GEN-LAST:event_btnInregResFinanciareActionPerformed

    private void btnInregResLogisticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInregResLogisticeActionPerformed
        setVisible(false);
        new GestioneazaResurseLogistice(this,true).setVisible(true);
        setVisible(true);
    }//GEN-LAST:event_btnInregResLogisticeActionPerformed

    private void showNotYetSupportedDialog() {
        setVisible(false);
        new NotYetSupportedDialog(this, true).setVisible(true);
        setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnImportaOrar;
    private javax.swing.JButton btnImportaState;
    private javax.swing.JButton btnInregResFinanciare;
    private javax.swing.JButton btnInregResLogistice;
    private javax.swing.JButton btnInregResUmane;
    // End of variables declaration//GEN-END:variables
}
