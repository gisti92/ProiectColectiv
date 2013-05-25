/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.publicul.activitaticd.models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Formatie;

/**
 *
 * @author Deea
 */
public class FormatiiTM extends AbstractTableModel {

    private String[] header = {" Id Formatie ", "Denumire formatie", "Id Sectie", "An ", " Grupa"};
    private List<Formatie> list = new ArrayList<Formatie>();

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    public int getIdByRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= list.size()) {
            return -1;
        } else {
            return list.get(rowIndex).getId_Formatie();
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId_Formatie();
            case 1:
                return list.get(rowIndex).getDenumire();
            case 2:
                return list.get(rowIndex).getId_Sectie();
            case 3:
                return list.get(rowIndex).getAn();
            case 4:
                return list.get(rowIndex).getGrupa();
            default:
                return null;
        }
    }
    
    public String[] getHeader() {
        return header;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    public void clear() {
        list.clear();
        fireTableDataChanged();
    }

    public void addRow(Formatie row) {
        list.add(row);
        fireTableDataChanged();
    }

    public void setList(List<Formatie> list) {
        this.list = list;
        fireTableDataChanged();
    }
}
