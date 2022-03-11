package gui.tables.model;

import gui.tables.TableStudents;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.*;


public class TableModelAvgMarks {
    private static final Object[] columnsHeader = new String[] {"Предмет", "Средний бал"};
    public static TableModel create(){
        DefaultTableModel tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        tableModel.setColumnIdentifiers(columnsHeader);
        ArrayList<String[]> subjectAvgMarks = TableStudents.getSelectedStudent().getSubjectAvgMarks();

        for (String[] subject : subjectAvgMarks){
            tableModel.addRow(subject);
        }

        return tableModel;
    }

}
