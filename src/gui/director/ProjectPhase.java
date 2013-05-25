/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director;

import gui.director.models.TasksTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import model.director.Faza;
import model.director.Faza.PhaseType;
import model.director.Task;
import model.director.TimeInterval;

/**
 *
 * @author Artiom.Casapu
 */
public class ProjectPhase extends javax.swing.JDialog {

    /**
     * Creates new form ProjectPhases
     */
    
    private Faza faza;
    private List<Task> tasks = new ArrayList<Task>();
    private boolean ok = false;
    
    public ProjectPhase(JDialog parent,boolean modal,Faza f, boolean update,boolean readOnly) {
        super(parent,modal);
        initComponents();
        
        if (readOnly){
        modificaButton.setText("Vizualizeaza");
        denumireTextField.setEditable(false);
        descriereTextField.setEditable(false);
        dela.setEditable(false);
        panala.setEditable(false);
        adaugaButton.setVisible(false);
        stergeButton.setVisible(false);
        
        }
        
        if (f.getTip().equals(PhaseType.PHASE)) {
            jLabel3.setText("Activitati");
        }
        
        faza = f;
        tasks.addAll(faza.getTaskuri());
        
        tasksTable.setModel(new TasksTableModel(tasks));
        
        if (update) {
            updateComponents();
        }
    }
    
    private void updateComponents() {
         denumireTextField.setText(faza.getDenumire());
         descriereTextField.setText(faza.getDescriere());
         dela.setDate(faza.getInterval().getStart());
         panala.setDate(faza.getInterval().getEnd());
    }
    
    private void updatePhase() {
        
        faza.setDenumire(denumireTextField.getText());
        faza.setDescriere(descriereTextField.getText());
        TimeInterval interval = new TimeInterval();
        interval.setStart((Date)dela.getDate());
        interval.setEnd((Date)panala.getDate());
        faza.setInterval(interval);
        faza.getTaskuri().clear();
        faza.getTaskuri().addAll(tasks);
        
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

        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        denumireTextField = new javax.swing.JTextField();
        descriereTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tasksTable = new javax.swing.JTable();
        adaugaButton = new javax.swing.JButton();
        modificaButton = new javax.swing.JButton();
        stergeButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dela = new org.jdesktop.swingx.JXDatePicker();
        panala = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setText("Denumire:");

        jLabel2.setText("Descriere:");

        jLabel3.setText("Sarcini:");

        tasksTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tasksTable);

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

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Timp inceput:");

        jLabel5.setText("Timp sfirsit:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(denumireTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(adaugaButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modificaButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stergeButton)
                                .addGap(0, 137, Short.MAX_VALUE))
                            .addComponent(descriereTextField)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(denumireTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(descriereTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(panala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adaugaButton)
                    .addComponent(modificaButton)
                    .addComponent(stergeButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        ok = true;
        updatePhase();
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void adaugaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adaugaButtonActionPerformed
        
        Task t = new Task();
        if (faza.getTip().equals(Faza.PhaseType.ADMINISTRATIVE_ACTIVITY)) {
            t.setTip(Task.TaskType.ADMINISTRATIVE_TASK);
        } else {
            t.setTip(Task.TaskType.SCIENTIFIC_ACTIVITY);
        }
        try {
            ProjectTask taskDialog = new ProjectTask(this,true,t, false);
            taskDialog.setVisible(true);
            
            if (taskDialog.isOk()) {
                tasks.add(t);
                tasksTable.setModel(new TasksTableModel(tasks));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectPhase.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }//GEN-LAST:event_adaugaButtonActionPerformed

    private void modificaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaButtonActionPerformed
        
        int row = tasksTable.getSelectedRow();
        Task t = ((TasksTableModel)tasksTable.getModel()).getTask(row);
        
         try {
            ProjectTask taskDialog = new ProjectTask(this,true,t, true);
            taskDialog.setVisible(true);
            
            if (taskDialog.isOk()) {
                tasksTable.setModel(new TasksTableModel(tasks));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjectPhase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_modificaButtonActionPerformed

    private void stergeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stergeButtonActionPerformed
        
        int row = tasksTable.getSelectedRow();
        Task t = ((TasksTableModel)tasksTable.getModel()).getTask(row);
        
        tasks.remove(t);
        
        tasksTable.setModel(new TasksTableModel(tasks));      
    }//GEN-LAST:event_stergeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adaugaButton;
    private javax.swing.JButton cancelButton;
    private org.jdesktop.swingx.JXDatePicker dela;
    private javax.swing.JTextField denumireTextField;
    private javax.swing.JTextField descriereTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JButton modificaButton;
    private javax.swing.JButton okButton;
    private org.jdesktop.swingx.JXDatePicker panala;
    private javax.swing.JButton stergeButton;
    private javax.swing.JTable tasksTable;
    // End of variables declaration//GEN-END:variables
}
