/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director.programestudiu;

import gui.director.programestudiu.models.ProgrameDeStudiuTableModel;
import java.awt.Frame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.director.programestudiu.ProgramDeStudiuModel;
import persistence.DirectorRepositoryDB;

/**
 *
 * @author Artiom.Casapu
 */
public class ProgrameDeStudiu extends javax.swing.JDialog {

    /**
     * Creates new form ProgrameDeStudiu
     */
    
    public ProgrameDeStudiu(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
        try {
            programeTable.setModel(new ProgrameDeStudiuTableModel(DirectorRepositoryDB.getInstance().getPrograme()));
        } catch (SQLException ex) {
            Logger.getLogger(ProgrameDeStudiu.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        programeTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        adaugaButton = new javax.swing.JButton();
        modificaButton = new javax.swing.JButton();
        stergeButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        programeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(programeTable);

        jLabel1.setText("Programe de studiu:");

        adaugaButton.setText("Adauga");
        adaugaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaugaButtonActionPerformed(evt);
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

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(adaugaButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(modificaButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stergeButton)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adaugaButton)
                    .addComponent(modificaButton)
                    .addComponent(stergeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_okButtonActionPerformed

    private void adaugaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adaugaButtonActionPerformed
       
        ProgramDeStudiuModel program = new ProgramDeStudiuModel();
        ProgramDeStudiu stud = new ProgramDeStudiu(null, true, program, false);
        stud.setVisible(true);
        
        if (stud.isOk()) {
            try {
                DirectorRepositoryDB.getInstance().addProgramDeStudiu(program);
            } catch (SQLException ex) {
                Logger.getLogger(ProgrameDeStudiu.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                programeTable.setModel(new ProgrameDeStudiuTableModel(DirectorRepositoryDB.getInstance().getPrograme()));
            } catch (SQLException ex) {
                Logger.getLogger(ProgrameDeStudiu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_adaugaButtonActionPerformed

    private void modificaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaButtonActionPerformed
        
        int row = programeTable.getSelectedRow();
        
        ProgramDeStudiuModel program = ((ProgrameDeStudiuTableModel)programeTable.getModel()).getProgram(row);
        
        ProgramDeStudiu stud = new ProgramDeStudiu(null, true, program, true);
        
        stud.setVisible(true);
        
        if (stud.isOk()) {
            
            try {
                DirectorRepositoryDB.getInstance().updateProgramDeStudiu(program);
            } catch (SQLException ex) {
                Logger.getLogger(ProgrameDeStudiu.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                programeTable.setModel(new ProgrameDeStudiuTableModel(DirectorRepositoryDB.getInstance().getPrograme()));
            } catch (SQLException ex) {
                Logger.getLogger(ProgrameDeStudiu.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }//GEN-LAST:event_modificaButtonActionPerformed

    private void stergeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stergeButtonActionPerformed
        
        int row = programeTable.getSelectedRow();
        
        ProgramDeStudiuModel program = ((ProgrameDeStudiuTableModel)programeTable.getModel()).getProgram(row);
        try {
            DirectorRepositoryDB.getInstance().removeProgramDeStudiu(program);
        } catch (SQLException ex) {
            Logger.getLogger(ProgrameDeStudiu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            programeTable.setModel(new ProgrameDeStudiuTableModel(DirectorRepositoryDB.getInstance().getPrograme()));
        } catch (SQLException ex) {
            Logger.getLogger(ProgrameDeStudiu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_stergeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adaugaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificaButton;
    private javax.swing.JButton okButton;
    private javax.swing.JTable programeTable;
    private javax.swing.JButton stergeButton;
    // End of variables declaration//GEN-END:variables
}
