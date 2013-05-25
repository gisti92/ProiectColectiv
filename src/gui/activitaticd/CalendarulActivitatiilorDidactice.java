/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.activitaticd;

import businessLogic.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.publicul.filters.AnFilter;
import model.publicul.filters.CDFilter;
import model.publicul.filters.FormatieFilter;

/**
 *
 * @author Deea
 */
public class CalendarulActivitatiilorDidactice extends javax.swing.JDialog {

    private Controller contr = Controller.getInstance();

    /**
     * Creates new form CalendarulActivitatiilor
     */
    public CalendarulActivitatiilorDidactice(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        clearTableResurse();
        bindEvents();
        try {
            contr.refreshCalendarActivitati(null);
            tabel.setModel(contr.getCalendarActivitatiTM());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex, "Eroare in Calendarul Activitatiilor", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void bindEvents() {
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jComboBox1SelectionChanged(jComboBox1.getSelectedIndex());
            }
        });
    }

    private void jComboBox1SelectionChanged(int selectedItem) {
        try {
            switch (selectedItem) {
                case 0: {
                    contr.refreshCalendarActivitati(null);
                    tabel.setModel(contr.getCalendarActivitatiTM());
                    break;
                }
                case 1: {
                    SelectCadruDidacticDialog dialog = new SelectCadruDidacticDialog(this, true);
                    dialog.setVisible(true);
                    int selectedCDId = dialog.getSelectedCDId();
                    if (selectedCDId != -1) {
                        contr.refreshCalendarActivitati(new CDFilter(selectedCDId));
                        tabel.setModel(contr.getCalendarActivitatiTM());
                    }
                    break;
                }
                case 2: {
                    SelectFormatieDialog dialogf = new SelectFormatieDialog(this, true);
                    dialogf.setVisible(true);
                    int selectedFormatieId = dialogf.getSelectedFormatieId();
                    if (selectedFormatieId != -1) {
                        contr.refreshCalendarActivitati(new FormatieFilter(selectedFormatieId));
                        tabel.setModel(contr.getCalendarActivitatiTM());
                    }
                    break;
                }
                case 3: {
                    SelectAnDialog dialogan = new SelectAnDialog(this, true);
                    dialogan.setVisible(true);
                    int selectedAn = dialogan.getSelectedAn();
                    if (selectedAn != -1) {
                        contr.refreshCalendarActivitati(new AnFilter(selectedAn));
                        tabel.setModel(contr.getCalendarActivitatiTM());
                    }
                    break;
                }
                //TODO adauga restul
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex, "Eroare in Calendarul Activitatiilor", JOptionPane.ERROR_MESSAGE);
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

        jComboBox1 = new javax.swing.JComboBox();
        btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Calendarul Activitatiilor");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "....Filtrare....", "Filtrare dupa cadre didactice", "Filtrare dupa formatie", "Filtrare dupa an" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        btn.setText("Close");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel.setName("tabel"); // NOI18N
        jScrollPane1.setViewportView(tabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(404, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables

    private void clearTableResurse() {
        DefaultTableModel tm = new DefaultTableModel();
        tabel.setModel(tm);
    }
}
