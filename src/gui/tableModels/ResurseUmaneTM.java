/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tableModels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cadru_Didactic;

/**
 *
 * @author Deea
 */
public class ResurseUmaneTM extends AbstractTableModel{
    private String[] header = {"Pozitia","Denumire post","Nume","Functie","Titular/Vacant"};
    private List<Cadru_Didactic> list = new ArrayList<Cadru_Didactic>();
    
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
        switch (columnIndex){
            case 0: return list.get(rowIndex).getPozitia();
            case 1: return list.get(rowIndex).getDen_post();
            case 2: return list.get(rowIndex).getNume();
            case 3: return list.get(rowIndex).getFunctia();
            case 4: return list.get(rowIndex).getTit_vac();
            default : return null;       
        }
    }

    public String[] getHeader() {
        return header;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
        
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }
    
    public void addRow(Cadru_Didactic row){
        list.add(row);        
        fireTableDataChanged();
    }
    
    public void setList(List<Cadru_Didactic> list){
        this.list=list;
        fireTableDataChanged();
    }
}
