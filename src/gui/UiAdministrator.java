/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JFrame;

import businessLogic.Controller;

/**
 * 
 * @author S7eve
 */
@SuppressWarnings("serial")
public class UiAdministrator extends javax.swing.JFrame {

  private static UiAdministrator instance = null;
  private Controller contr = null;

  /**
   * Creates new form UiPublic
   */
  private UiAdministrator() {
    contr = Controller.getInstance();
    initComponents();

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
      instance.setLocation(400, 300);
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
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
   * content of this method is always regenerated by the Form Editor.
   */

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setText("Not yet implemented !");

    jButton1.setText("Exit");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        layout.createSequentialGroup().addGap(28, 28, 28).addComponent(jLabel1).addPreferredGap(
            javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE).addComponent(jButton1).addGap(26,
            26, 26)));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        layout.createSequentialGroup().addContainerGap().addGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(
                jButton1)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
    contr.importOrar("in.txt");// TODO just for test
    exit();

  }// GEN-LAST:event_jButton1ActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  // End of variables declaration//GEN-END:variables
}
