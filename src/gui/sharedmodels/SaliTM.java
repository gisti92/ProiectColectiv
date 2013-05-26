/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.sharedmodels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Sala;

/**
 *
 * @author Deea
 */
public class SaliTM extends AbstractTableModel {

    private String[] header = {"Id sala", "Denumire sala", "Capacitate"};
    private List<Sala> list = new ArrayList<Sala>();

    public SaliTM(List<Sala> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public SaliTM() {
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
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getDenumire();
            case 2:
                return list.get(rowIndex).getCapacitate();
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

    public void addRow(Sala row) {
        list.add(row);
        fireTableDataChanged();
    }

    public void setList(List<Sala> list) {
        this.list = list;
        fireTableDataChanged();
    }
}
