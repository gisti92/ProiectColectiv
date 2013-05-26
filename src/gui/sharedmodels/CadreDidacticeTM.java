/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.sharedmodels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.CadruDidactic;

/**
 *
 * @author Deea
 */
public class CadreDidacticeTM extends AbstractTableModel {

    private String[] header = {"Pozitia", "Denumire post", "Nume", "Functie", "Titular/Vacant"};
    private List<CadruDidactic> list = new ArrayList<CadruDidactic>();

    public CadreDidacticeTM(List<CadruDidactic> list){
        this.list=list;
        fireTableDataChanged();
    }
    
    public CadreDidacticeTM(){
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
                return list.get(rowIndex).getPozitia();
            case 1:
                return list.get(rowIndex).getDenumirePost();
            case 2:
                return list.get(rowIndex).getNume();
            case 3:
                return list.get(rowIndex).getFunctia();
            case 4:
                return list.get(rowIndex).getTitVac().equals("T")?"Titular":"Vacant" ;
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
