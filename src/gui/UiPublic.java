/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.publicul.informatiiresurse.InformatiResurse;
import businessLogic.Controller;
import businessLogic.PubliculController;
import gui.publicul.activitati.CalendarulActivitatiilor;
import gui.publicul.proiecte.InformatiiProiecteDepartament;
import javax.swing.JFrame;

/**
 *
 * @author S7eve
 */
@SuppressWarnings("serial")
public class UiPublic extends javax.swing.JFrame {

    private static UiPublic instance;
    private PubliculController contr;

    /**
     * Creates new form UiPublic
     */
    private UiPublic() {
        contr = PubliculController.getInstance();
        initComponents();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                exit();
            }
        });
        setLocationRelativeTo(null);
    }

    public static UiPublic getInstance() {
        if (instance == null) {
            instance = new UiPublic();
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnInfoResurse = new javax.swing.JButton();
        btnProiecte = new javax.swing.JButton();
        btnCalendar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UiPublic");

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Not yet implemented !");

        btnInfoResurse.setText("Informaţii despre resursele umane şi logistice ");
        btnInfoResurse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoResurseActionPerformed(evt);
            }
        });

        btnProiecte.setText("Informatii despre proiectele departamentului");
        btnProiecte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProiecteActionPerformed(evt);
            }
        });

        btnCalendar.setText("Calendarul activitatiilor");
        btnCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProiecte, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInfoResurse, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnInfoResurse)
                .addGap(33, 33, 33)
                .addComponent(btnProiecte)
                .addGap(32, 32, 32)
                .addComponent(btnCalendar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        exit();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnInfoResurseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoResurseActionPerformed
        // System.out.println();
        //System.out.println("Before");
        setVisible(false);
        new InformatiResurse(this, true).setVisible(true);
        //System.out.println("After");
        setVisible(true);
    }//GEN-LAST:event_btnInfoResurseActionPerformed

    private void btnCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarActionPerformed
        setVisible(false);
        new CalendarulActivitatiilor(this, true).setVisible(true);
        setVisible(true);
    }//GEN-LAST:event_btnCalendarActionPerformed

    private void btnProiecteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProiecteActionPerformed
        setVisible(false);
        new InformatiiProiecteDepartament(this, true).setVisible(true);
        setVisible(true);
    }//GEN-LAST:event_btnProiecteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalendar;
    private javax.swing.JButton btnInfoResurse;
    private javax.swing.JButton btnProiecte;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
