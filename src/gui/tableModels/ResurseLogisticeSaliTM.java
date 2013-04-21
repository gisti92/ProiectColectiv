/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tableModels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Sali;

/**
 *
 * @author Deea
 */
public class ResurseLogisticeSaliTM extends AbstractTableModel{
    private String[] header = {"Id sala","Denumire sala","Capacitate"};
    private List<Sali> list = new ArrayList<Sali>();
    
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
        switch(columnIndex){
            case 0: return list.get(rowIndex).Id_Sala;
            case 1: return list.get(rowIndex).denumire;
            case 2: return list.get(rowIndex).capacitate;
            default: return null;
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
    
    public void addRow(Sali row){
        list.add(row);        
        fireTableDataChanged();
    }
    
    public void setList(List<Sali> list){
        this.list=list;
        fireTableDataChanged();
    }
    
}
