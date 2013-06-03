/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director.programestudiu;

import gui.director.CercuriStudentestiDialog;
import gui.director.programestudiu.models.PlanuriTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import model.director.programestudiu.PlanInv;
import model.director.programestudiu.SectieModel;

/**
 *
 * @author Nicu
 */

public class SectieDialog extends javax.swing.JDialog {
   private SectieModel sectie;
   private String[] comboBArray = {"1", "2", "3", "4", "5", "6", "7", "8"};
   private List<PlanInv> planuriInvTmp = new ArrayList<PlanInv>();
   private boolean ok;
    /**
     * Creates new form SectieDialog
     */
    public SectieDialog(SectieModel sectie, boolean update, boolean modal) {
        setModal(modal);
        initComponents();
        this.sectie = sectie;
        
        nrSemestreComboBox.setModel(new DefaultComboBoxModel(comboBArray));
        nrSemestreComboBox.setSelectedIndex(sectie.getNrSemestre()-1);
        
        planuriInvTmp.addAll(sectie.getPlanuriDeInvatamint());
        planuriInvTable.setModel(new PlanuriTableModel(planuriInvTmp));
        
        if (update) {
            updateComponents();
        }
    }
    
    public SectieDialog() {
        initComponents();
        nrSemestreComboBox.setModel(new DefaultComboBoxModel(comboBArray));
    }
    
    private void updateComponents() {
        sectieNameField.setText(sectie.getDenumire());
        nrSemestreComboBox.setSelectedItem(String.valueOf(sectie.getNrSemestre()));
    }
    
    private void updateSectie() {
        sectie.setDenumire(sectieNameField.getText());
        sectie.setNrSemestre(Integer.valueOf((String)nrSemestreComboBox.getSelectedItem()));
        sectie.getPlanuriDeInvatamint().clear();
        sectie.getPlanuriDeInvatamint().addAll(planuriInvTmp);
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
        planuriInvTable = new javax.swing.JTable();
        sectieNameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nrSemestreComboBox = new javax.swing.JComboBox();
        modificaButton = new javax.swing.JButton();
        adaugaPrStudiuButton = new javax.swing.JButton();
        stergePrStudiuButton = new javax.swing.JButton();
        salveazaButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cercuriDeStudentiButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        planuriInvTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(planuriInvTable);

        jLabel1.setText("Denumire sectie:");

        jLabel2.setText("Nr. Semestre");

        nrSemestreComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        nrSemestreComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nrSemestreComboBoxActionPerformed(evt);
            }
        });

        modificaButton.setText("Modifica");
        modificaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaButtonActionPerformed(evt);
            }
        });

        adaugaPrStudiuButton.setText("Adauga");
        adaugaPrStudiuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaugaPrStudiuButtonActionPerformed(evt);
            }
        });

        stergePrStudiuButton.setText("Sterge");
        stergePrStudiuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stergePrStudiuButtonActionPerformed(evt);
            }
        });

        salveazaButton.setText("Salveaza");
        salveazaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salveazaButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cercuriDeStudentiButton.setText("Cercuri de Studenti");
        cercuriDeStudentiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cercuriDeStudentiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adaugaPrStudiuButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modificaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stergePrStudiuButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cercuriDeStudentiButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(sectieNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(nrSemestreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salveazaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(13, 13, 13))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sectieNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nrSemestreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(151, 151, 151))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificaButton)
                            .addComponent(adaugaPrStudiuButton)
                            .addComponent(stergePrStudiuButton)
                            .addComponent(cercuriDeStudentiButton))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salveazaButton)
                            .addComponent(jButton1))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nrSemestreComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nrSemestreComboBoxActionPerformed
        // TODO add your hasndling code here:
    }//GEN-LAST:event_nrSemestreComboBoxActionPerformed

    private void salveazaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salveazaButtonActionPerformed
        if (!"".equals(sectieNameField.getText())){
            ok = true;
            updateSectie();
            dispose();
        }
        
        
    }//GEN-LAST:event_salveazaButtonActionPerformed

    private void modificaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaButtonActionPerformed
       int row = planuriInvTable.getSelectedRow();
       if (row != -1){
        PlanInv plan = planuriInvTmp.get(planuriInvTable.getSelectedRow());
        
        ProgramDeStudiuDialog diag = new ProgramDeStudiuDialog(plan, true, null, true);
        diag.setVisible(true);
        
        if (diag.isOK()) {
            planuriInvTable.setModel(new PlanuriTableModel(planuriInvTmp));
        }   
       }
        
        
    }//GEN-LAST:event_modificaButtonActionPerformed

    private void adaugaPrStudiuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adaugaPrStudiuButtonActionPerformed
        
        PlanInv plan = new PlanInv();
        
        ProgramDeStudiuDialog diag = new ProgramDeStudiuDialog(plan, false, null, true);
        diag.setVisible(true);
        
        if (diag.isOK()) {
            planuriInvTmp.add(plan);
            planuriInvTable.setModel(new PlanuriTableModel(planuriInvTmp));
        }
        
    }//GEN-LAST:event_adaugaPrStudiuButtonActionPerformed

    private void stergePrStudiuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stergePrStudiuButtonActionPerformed
       int row = planuriInvTable.getSelectedRow();
       if (row != -1){
        planuriInvTmp.remove(row);
        planuriInvTable.setModel(new PlanuriTableModel(planuriInvTmp));
       }
        
        
    }//GEN-LAST:event_stergePrStudiuButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok = false;
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cercuriDeStudentiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cercuriDeStudentiButtonActionPerformed

      
    }//GEN-LAST:event_cercuriDeStudentiButtonActionPerformed
    public boolean isOk(){
        return ok;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adaugaPrStudiuButton;
    private javax.swing.JButton cercuriDeStudentiButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificaButton;
    private javax.swing.JComboBox nrSemestreComboBox;
    private javax.swing.JTable planuriInvTable;
    private javax.swing.JButton salveazaButton;
    private javax.swing.JTextField sectieNameField;
    private javax.swing.JButton stergePrStudiuButton;
    // End of variables declaration//GEN-END:variables
}
