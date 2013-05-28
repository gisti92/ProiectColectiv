/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director;

import gui.director.models.LogisticResourcesTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import model.ResursaLogistica;
import model.director.Task;

/**
 *
 * @author Artiom.Casapu
 */
public class ProjectLogisticResources extends javax.swing.JDialog {

    /**
     * Creates new form ProjectLogisticResources
     */
    
    private List<ResursaLogistica> logistics = new ArrayList<ResursaLogistica>();
    private boolean ok = false;
    private Task t;
    
    public ProjectLogisticResources(JDialog parent,boolean modal,Task t) {
        super(parent,modal);
        initComponents();
        setLocationRelativeTo(parent);
        
        this.t = t;
        
        logistics.addAll(t.getResurseLogistice());
        
        refreshLogisticsTable();
        
    }
    
    private void updateComponents() {
        
        t.getResurseLogistice().clear();
        t.getResurseLogistice().addAll(logistics);
        
    }
    
    public boolean isOk() {
        return ok;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        logisticResourcesTable = new javax.swing.JTable();
        adaugaButton = new javax.swing.JButton();
        stergeButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        logisticResourcesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(logisticResourcesTable);

        adaugaButton.setText("Adauga");
        adaugaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaugaButtonActionPerformed(evt);
            }
        });

        stergeButton.setText("Sterge");
        stergeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stergeButtonActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adaugaButton)
                        .addGap(83, 83, 83)
                        .addComponent(stergeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adaugaButton)
                    .addComponent(stergeButton)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
       
        ok = true;
        
        updateComponents();
        
        dispose();
       
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void adaugaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adaugaButtonActionPerformed
        try {
            LogisticResourceDialog diag = new LogisticResourceDialog(this,true);
            diag.setVisible(true);
            
            if (diag.isOk()) {
                ResursaLogistica res = diag.getSelected();
                logistics.add(res);
                refreshLogisticsTable();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjectLogisticResources.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_adaugaButtonActionPerformed

    private void stergeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stergeButtonActionPerformed
       
        int row = logisticResourcesTable.getSelectedRow();
        
        logistics.remove(logistics.get(row));
        
        refreshLogisticsTable();
        
    }//GEN-LAST:event_stergeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adaugaButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable logisticResourcesTable;
    private javax.swing.JButton okButton;
    private javax.swing.JButton stergeButton;
    // End of variables declaration//GEN-END:variables

    private void refreshLogisticsTable() {
        logisticResourcesTable.setModel(new LogisticResourcesTableModel(logistics));
    }
}
