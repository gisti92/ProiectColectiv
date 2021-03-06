/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.administrator.gestionezaresurse;

import businessLogic.AdministratorController;
import gui.sharedmodels.CadreDidacticeTM;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

/**
 *
 * @author S7eve
 */
public class GestioneazaResurseUmane extends javax.swing.JDialog {

    private AdministratorController contr = AdministratorController.getInstance();
    private CadreDidacticeTM resurseUmaneTM = new CadreDidacticeTM();

    /**
     * Creates new form GestioneazaResurseUmaneDialog
     */
    public GestioneazaResurseUmane(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tabelCadreDidactice.setModel(resurseUmaneTM);
        setLocationRelativeTo(null);
        refreshResurseUmaneTable();
        bindEvents();
    }

    private void refreshResurseUmaneTable() {
        try {
            resurseUmaneTM.setList(contr.getResurseUmane());
        } catch (Exception ex) {
            Logger.getLogger(GestioneazaResurseUmane.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Eroare la incarcare lista de carde didactice!", "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void bindEvents() {
        ListSelectionModel rowSelectionModel = tabelCadreDidactice.getSelectionModel();
        rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = tabelCadreDidactice.getSelectedRow();
                if (selectedRow >= 0) {
                    TableModel model = tabelCadreDidactice.getModel();
                    txtPozitia.setText((String) model.getValueAt(selectedRow, 0));
                    txtDenumirePost.setText((String) model.getValueAt(selectedRow, 1));
                    txtNume.setText((String) model.getValueAt(selectedRow, 2));
                    txtFunctia.setText((String) model.getValueAt(selectedRow, 3));
                    cbTitular.setSelectedIndex(model.getValueAt(selectedRow, 4).equals("Titular") ? 0 : 1);
                }
            }
        });
    }

    private boolean rowSelected() {
        int selectedRow = tabelCadreDidactice.getSelectedRow();
        return selectedRow >= 0;
    }

    private boolean fieldsNotEmpty() {
        return !(txtPozitia.getText().isEmpty()
                || txtDenumirePost.getText().isEmpty()
                || txtNume.getText().isEmpty()
                || txtFunctia.getText().isEmpty());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnAdauga = new javax.swing.JButton();
        btnModifica = new javax.swing.JButton();
        txtPozitia = new javax.swing.JTextField();
        txtDenumirePost = new javax.swing.JTextField();
        txtNume = new javax.swing.JTextField();
        txtFunctia = new javax.swing.JTextField();
        cbTitular = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelCadreDidactice = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSterge = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAdauga.setText("Adauga");
        btnAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdaugaActionPerformed(evt);
            }
        });

        btnModifica.setText("Modifica");
        btnModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaActionPerformed(evt);
            }
        });

        cbTitular.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Titular", "Vacant" }));

        tabelCadreDidactice.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelCadreDidactice);

        jLabel1.setText("Pozitia");

        jLabel3.setText("Denumire Post");

        jLabel4.setText("Nume");

        jLabel5.setText("Functia");

        jLabel6.setText("Titulat/Vacant");

        btnSterge.setText("Sterge");
        btnSterge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStergeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPozitia, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDenumirePost, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNume, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFunctia, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel3)
                                .addGap(98, 98, 98)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTitular, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdauga, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModifica, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSterge, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPozitia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDenumirePost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFunctia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModifica)
                    .addComponent(btnAdauga)
                    .addComponent(btnSterge))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaActionPerformed
        if (!rowSelected()) {
            JOptionPane.showMessageDialog(this, "Selectati o linie! ", "Eroare ", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!fieldsNotEmpty()) {
            JOptionPane.showMessageDialog(this, "Completati toate fieldurile! ", "Eroare ", JOptionPane.ERROR_MESSAGE);
            return;
        }
        CadreDidacticeTM model = (CadreDidacticeTM) tabelCadreDidactice.getModel();
        int row = tabelCadreDidactice.getSelectedRow();
        final String tit_vac = ((String) cbTitular.getSelectedItem()).substring(0, 1);
        contr.modificaCadruDidactic(model.getIdByRow(row), txtPozitia.getText(), txtDenumirePost.getText(), txtNume.getText(), txtFunctia.getText(), tit_vac);
        refreshResurseUmaneTable();
    }//GEN-LAST:event_btnModificaActionPerformed
    public String getBlabla() {
        return txtDenumirePost.getText();
    }

    private void btnAdaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdaugaActionPerformed

        if (!fieldsNotEmpty()) {
            JOptionPane.showMessageDialog(this, "Completati toate fieldurile! ", "Eroare ", JOptionPane.ERROR_MESSAGE);
            return;
        }
        CadreDidacticeTM model = (CadreDidacticeTM) tabelCadreDidactice.getModel();
        int row = tabelCadreDidactice.getSelectedRow();
        String tit_vac = ((String) cbTitular.getSelectedItem()).substring(0, 1);
        contr.adaugaCadruDidactic(model.getIdByRow(row), txtPozitia.getText(), txtDenumirePost.getText(), txtNume.getText(), txtFunctia.getText(), tit_vac);
        refreshResurseUmaneTable();
    }//GEN-LAST:event_btnAdaugaActionPerformed

    private void btnStergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStergeActionPerformed
        if (!rowSelected()) {
            JOptionPane.showMessageDialog(this, "Selectati o linie! ", "Eroare ", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(this, "Sigur vreti sa efectuati stergerea? ", "?", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.NO_OPTION) {
            return;
        }
        CadreDidacticeTM model = (CadreDidacticeTM) tabelCadreDidactice.getModel();
        int row = tabelCadreDidactice.getSelectedRow();
        contr.stergeCadruDidactic(model.getIdByRow(row));
        refreshResurseUmaneTable();
    }//GEN-LAST:event_btnStergeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdauga;
    private javax.swing.JButton btnModifica;
    private javax.swing.JButton btnSterge;
    private javax.swing.JComboBox cbTitular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelCadreDidactice;
    private javax.swing.JTextField txtDenumirePost;
    private javax.swing.JTextField txtFunctia;
    private javax.swing.JTextField txtNume;
    private javax.swing.JTextField txtPozitia;
    // End of variables declaration//GEN-END:variables
}
