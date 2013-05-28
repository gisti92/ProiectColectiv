/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.administrator.gestionezaresurse.models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.ResursaLogistica;
import model.director.ResursaFinanciara;

/**
 *
 * @author S7eve
 */
public class ResurseFinanciareTM extends AbstractTableModel {

    private String[] header = {"Descriere", "Suma", "Tipul"};
    private List<ResursaFinanciara> list = new ArrayList<ResursaFinanciara>();

    public ResurseFinanciareTM(List<ResursaFinanciara> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: {
                return list.get(rowIndex).getDescriere();
            }
            case 1: {
                return list.get(rowIndex).getSuma();
            }
            case 2: {
                final ResursaFinanciara.TipCheltuiala tip = list.get(rowIndex).getTip();
                return tip == null ? "" : tip.toString();
            }
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    public int getId(int rowIndex) {
        return list.get(rowIndex).getId();
    }
    public ResursaFinanciara.TipCheltuiala getTip(int rowIndex){
        return list.get(rowIndex).getTip();
    }

    public String[] getHeader() {
        return header;
    }
}
