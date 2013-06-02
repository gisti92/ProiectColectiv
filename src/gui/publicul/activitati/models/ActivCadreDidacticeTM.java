/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.publicul.activitati.models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.CadruDidactic;

/**
 *
 * @author Deea
 */
public class ActivCadreDidacticeTM extends AbstractTableModel{

      private String[] header = {"Denumire post", "Nume"};
    private List<CadruDidactic> list = new ArrayList<CadruDidactic>();

    public ActivCadreDidacticeTM(List<CadruDidactic> list){
        this.list=list;
        fireTableDataChanged();
    }
    
    public ActivCadreDidacticeTM(){
    }
    
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
            return list.get(rowIndex).getId();
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getDenumirePost();
            case 1:
                return list.get(rowIndex).getNume();
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

    public void addRow(CadruDidactic row) {
        list.add(row);
        fireTableDataChanged();
    }

    public void setList(List<CadruDidactic> list) {
        this.list = list;
        fireTableDataChanged();
    }
    
}
