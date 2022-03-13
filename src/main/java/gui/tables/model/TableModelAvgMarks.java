package gui.tables.model;

import gui.tables.TableStudents;
import models.AverageMarkSubject;
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
        List<AverageMarkSubject> averageMarkSubjects = TableStudents.getSelectedStudent().getAverageMarkSubjects();
        for (AverageMarkSubject currentAvgMark : averageMarkSubjects){
            tableModel.addRow(new String[]{currentAvgMark.getSubject().getSubjectName(),
                    String.format(Locale.ENGLISH,"%.2f", currentAvgMark.averageMark())});
        }
        return tableModel;
    }
}
