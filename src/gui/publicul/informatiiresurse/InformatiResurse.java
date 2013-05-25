/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.publicul.informatiiresurse;

import businessLogic.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author S7eve
 */
public class InformatiResurse extends javax.swing.JDialog {

    private Controller contr = Controller.getInstance();

    /**
     * Creates new form InformatiResurse
     */
    public InformatiResurse(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        clearTableResurse();
        bindEvents();
        setLocationRelativeTo(null);
    }

    private void bindEvents() { 
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxSelectionChanged(comboBox.getSelectedIndex());
            }
        });
    }

    private void comboBoxSelectionChanged(int selectedItem) {
        try {
            switch (selectedItem) {
                case 0:
                    clearTableResurse();
                    break;
                case 1:
                     contr.refreshResurseUmaneTM();
                     tabelResurse.setModel(contr.getResurseUmaneTM());
                    break;
                case 2:
                    contr.refreshSaliTM();
                    tabelResurse.setModel(contr.getSaliTM());
                    break;
                case 3:
                    contr.refreshEchipamenteTM();
                    tabelResurse.setModel(contr.getEchipamenteTM());
                    break;
                //TODO adauga restul
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Eroare In Informatii Resurse", JOptionPane.ERROR_MESSAGE);
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

        btnClose = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelResurse = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informatii resurse umane si logistice");

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...Alegeti informatiile pe care doriti sa le obtineti...", "Informaţii despre resursele umane ale departamentului", "Informatii despre salile departamentului", "Informatii despre echipamentele departamentului" }));
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        tabelResurse.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelResurse);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClose)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JComboBox comboBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelResurse;
    // End of variables declaration//GEN-END:variables

    private void clearTableResurse() {
        DefaultTableModel tm = new DefaultTableModel();
        tabelResurse.setModel(tm);
    }
}
