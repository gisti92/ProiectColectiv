/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director.programestudiu;

import gui.director.programestudiu.models.SectiiTableModel;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.director.programestudiu.SectieModel;
import persistence.DirectorRepositoryDB;

/**
 *
 * @author Nicu
 */
public class SectiiDialog extends javax.swing.JDialog {

    /**
     * Creates new form SectiiDialog
     */
    
    private List<SectieModel> sectii;
    
    public SectiiDialog() {
        
        initComponents();
        try {
            sectii = DirectorRepositoryDB.getInstance().getSectii();
            sectiiTable.setModel(new SectiiTableModel(sectii));
        } catch (SQLException ex) {
//            Logger.getLogger(ProgrameDeStudiu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sectiiTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        modificaButton = new javax.swing.JButton();
        stergeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setText("Sectii:");

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        sectiiTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(sectiiTable);

        addButton.setText("Adauga");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        modificaButton.setText("Modifica");
        modificaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaButtonActionPerformed(evt);
            }
        });

        stergeButton.setText("Sterge");
        stergeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stergeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stergeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(addButton)
                    .addComponent(modificaButton)
                    .addComponent(stergeButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
       dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
            SectieModel model = new SectieModel();
            
            SectieDialog diag = new SectieDialog(model, false, true);
            diag.setVisible(true);
            if (diag.isOk()){
                DirectorRepositoryDB.getInstance().insertSectie(model);

                sectii = DirectorRepositoryDB.getInstance().getSectii();
                sectiiTable.setModel(new SectiiTableModel(sectii));    
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SectiiDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void modificaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaButtonActionPerformed
        int row = sectiiTable.getSelectedRow();
        if (row != -1){
            SectieModel model = sectii.get(row);

            SectieDialog sectieDialog = new SectieDialog(model, true, true);
            sectieDialog.setVisible(true);
            if (sectieDialog.isOk()){
                try {
                  DirectorRepositoryDB.getInstance().updateSectie(model);
                  sectii = DirectorRepositoryDB.getInstance().getSectii();
                  sectiiTable.setModel(new SectiiTableModel(sectii));
              } catch (SQLException ex) {
                  Logger.getLogger(SectiiDialog.class.getName()).log(Level.SEVERE, null, ex);
              }
            }
            
        }
        
        
    }//GEN-LAST:event_modificaButtonActionPerformed

    private void stergeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stergeButtonActionPerformed
        
        int row = sectiiTable.getSelectedRow();
        if (row != -1){
            SectieModel model = sectii.get(row);
            try {
                DirectorRepositoryDB.getInstance().deleteSectie(model);

                sectii = DirectorRepositoryDB.getInstance().getSectii();
                sectiiTable.setModel(new SectiiTableModel(sectii));
            } catch (SQLException ex) {
                Logger.getLogger(SectiiDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_stergeButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificaButton;
    private javax.swing.JButton okButton;
    private javax.swing.JTable sectiiTable;
    private javax.swing.JButton stergeButton;
    // End of variables declaration//GEN-END:variables
}
