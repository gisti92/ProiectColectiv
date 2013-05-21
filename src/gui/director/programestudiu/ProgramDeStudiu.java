/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director.programestudiu;

import gui.director.programestudiu.models.CercuriStudentestiTableModel;
import gui.director.programestudiu.models.SemestreTableModel;
import java.util.ArrayList;
import java.util.List;
import model.director.programestudiu.CercStudentesc;
import model.director.programestudiu.Semestru;

/**
 *
 * @author Artiom.Casapu
 */
public class ProgramDeStudiu extends javax.swing.JDialog {

    private boolean ok = false;
    private model.director.programestudiu.ProgramDeStudiuModel program;
    
    private List<Semestru> semestre = new ArrayList<Semestru>();
    private List<CercStudentesc> cercuri = new ArrayList<CercStudentesc>();
    
    /**
     * Creates new form ProgramDeStudiu
     */
    public ProgramDeStudiu(java.awt.Frame parent, boolean modal, model.director.programestudiu.ProgramDeStudiuModel program, boolean update) {
        super(parent, modal);
        initComponents();
        
        this.program = program;

        semestre.addAll(program.getSemestre());
        cercuri.addAll(program.getCercuri());
        
        semesteTable.setModel(new SemestreTableModel(semestre));
        cercuriTable.setModel(new CercuriStudentestiTableModel(cercuri));
        
        if (update) {
            updateComponents();
        }
    }
    
    private void updateComponents() {
        denumireTextField.setText(program.getDenumire());
    }
    
    private void updateProgram() {
        program.setDenumire(denumireTextField.getText());
        program.getCercuri().clear();
        program.getCercuri().addAll(cercuri);
        program.getSemestre().clear();
        program.getSemestre().addAll(semestre);
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

        jLabel1 = new javax.swing.JLabel();
        denumireTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        semesteTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        cercuriTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        adaugaSemestruButton = new javax.swing.JButton();
        modificaSemestruButton = new javax.swing.JButton();
        stergeSemestruButton = new javax.swing.JButton();
        adaugaCercuriButton = new javax.swing.JButton();
        modificaCercuriButton = new javax.swing.JButton();
        stergeCercuriButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Denumire:");

        semesteTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(semesteTable);

        cercuriTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(cercuriTable);

        jLabel2.setText("Semestre:");

        jLabel3.setText("Cercuri studentesti");

        adaugaSemestruButton.setText("Adauga");
        adaugaSemestruButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaugaSemestruButtonActionPerformed(evt);
            }
        });

        modificaSemestruButton.setText("Modifica");
        modificaSemestruButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaSemestruButtonActionPerformed(evt);
            }
        });

        stergeSemestruButton.setText("Sterge");
        stergeSemestruButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stergeSemestruButtonActionPerformed(evt);
            }
        });

        adaugaCercuriButton.setText("Adauga");
        adaugaCercuriButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaugaCercuriButtonActionPerformed(evt);
            }
        });

        modificaCercuriButton.setText("Modifica");
        modificaCercuriButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaCercuriButtonActionPerformed(evt);
            }
        });

        stergeCercuriButton.setText("Sterge");
        stergeCercuriButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stergeCercuriButtonActionPerformed(evt);
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(denumireTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(adaugaSemestruButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modificaSemestruButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stergeSemestruButton))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(adaugaCercuriButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modificaCercuriButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stergeCercuriButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(denumireTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adaugaSemestruButton)
                    .addComponent(modificaSemestruButton)
                    .addComponent(stergeSemestruButton))
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adaugaCercuriButton)
                    .addComponent(modificaCercuriButton)
                    .addComponent(stergeCercuriButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        
        ok = true;
        
        updateProgram();
        
        dispose();
        
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void adaugaSemestruButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adaugaSemestruButtonActionPerformed
        Semestru sem = new Semestru();
        
        SemestruDialog diag = new SemestruDialog(null, true, sem, false);
        diag.setVisible(true);
        
        if (diag.isOk()) {
            
            semestre.add(sem);
            semesteTable.setModel(new SemestreTableModel(semestre));
            
        }
        
        
    }//GEN-LAST:event_adaugaSemestruButtonActionPerformed

    private void modificaSemestruButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaSemestruButtonActionPerformed
        
        int row = semesteTable.getSelectedRow();
        
        Semestru sem = semestre.get(row);
        
        SemestruDialog diag = new SemestruDialog(null, true, sem, true);
        diag.setVisible(true);
        
        if (diag.isOk()) {
            
//            semestre.add(sem);
            semesteTable.setModel(new SemestreTableModel(semestre));
            
        }
        
    }//GEN-LAST:event_modificaSemestruButtonActionPerformed

    private void stergeSemestruButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stergeSemestruButtonActionPerformed
        
        int row = semesteTable.getSelectedRow();
        
        Semestru sem = semestre.get(row);
        
        semestre.remove(sem);
        
        semesteTable.setModel(new SemestreTableModel(semestre));
        
    }//GEN-LAST:event_stergeSemestruButtonActionPerformed

    private void adaugaCercuriButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adaugaCercuriButtonActionPerformed
        
        CercStudentesc cerc = new CercStudentesc();
        
        CercStudentescDialog diag = new CercStudentescDialog(null, true, cerc, false);
        diag.setVisible(true);
        
        if (diag.isOk()) {
            
            cercuri.add(cerc);
            cercuriTable.setModel(new CercuriStudentestiTableModel(cercuri));
            
        }
        
    }//GEN-LAST:event_adaugaCercuriButtonActionPerformed

    private void modificaCercuriButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaCercuriButtonActionPerformed
        
        int row = cercuriTable.getSelectedRow();
        
        CercStudentesc cerc = cercuri.get(row);
        
        CercStudentescDialog diag = new CercStudentescDialog(null, true, cerc, true);
        diag.setVisible(true);
        
        if (diag.isOk()) {
            
            cercuriTable.setModel(new CercuriStudentestiTableModel(cercuri));
            
        }
        
    }//GEN-LAST:event_modificaCercuriButtonActionPerformed

    private void stergeCercuriButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stergeCercuriButtonActionPerformed
        
        int row = cercuriTable.getSelectedRow();
        
        CercStudentesc cerc = cercuri.get(row);
        
        cercuri.remove(cerc);
        
        cercuriTable.setModel(new CercuriStudentestiTableModel(cercuri));
        
    }//GEN-LAST:event_stergeCercuriButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adaugaCercuriButton;
    private javax.swing.JButton adaugaSemestruButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable cercuriTable;
    private javax.swing.JTextField denumireTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modificaCercuriButton;
    private javax.swing.JButton modificaSemestruButton;
    private javax.swing.JButton okButton;
    private javax.swing.JTable semesteTable;
    private javax.swing.JButton stergeCercuriButton;
    private javax.swing.JButton stergeSemestruButton;
    // End of variables declaration//GEN-END:variables
}
