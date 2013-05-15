/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tableModels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.OrarDisplay;

/**
 *
 * @author Deea
 */
public class CalendarulActivitatiTM extends AbstractTableModel {

    private String[] header = {"Ziua", "Ora", "Frecventa", "Disciplina", "Tip", "Cadrul Didactic", "Sala", "Sectie", "Formatie"};
    private List<OrarDisplay> list = new ArrayList<OrarDisplay>();

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
                switch (list.get(rowIndex).getZiua()) {
                    case 1:
                        return "Luni";
                    case 2:
                        return "Marti";
                    case 3:
                        return "Miercuri";
                    case 4:
                        return "Joi";
                    case 5:
                        return "Vineri";
                    case 6:
                        return "Sambata";
                    case 7:
                        return "Duminica";
                }

            case 1:
                int dela = (int) list.get(rowIndex).getOra_inceput();
                int panala = (int) list.get(rowIndex).getOra_sfarsit();
                return (dela < 10 ? ("0" + dela) : dela) + " - " + (panala < 10 ? ("0" + panala) : panala);
            case 2:
                return list.get(rowIndex).getFrecventa();
            case 3:
                return list.get(rowIndex).getDisciplina();
            case 4:
                return list.get(rowIndex).getTip();
            case 5:
                return list.get(rowIndex).getCadru_Didactic();
            case 6:
                return list.get(rowIndex).getSala();
            case 7:
                return list.get(rowIndex).getSectie();
            case 8:
                return list.get(rowIndex).getFormatie();
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

    public void addRow(OrarDisplay row) {
        list.add(row);
        fireTableDataChanged();
    }

    public void setList(List<OrarDisplay> list) {
        this.list = list;
        fireTableDataChanged();
    }
}
