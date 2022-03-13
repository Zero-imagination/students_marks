package gui.tables.model;

import gui.boxes.BoxStudent;
import gui.tables.TableStudents;
import models.Mark;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.List;


public class TableModelSubjectMarks {

    private static final Object[] columnsHeader = new String[] {"Оценки"};

    public static TableModel create() {
        DefaultTableModel tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        tableModel.setColumnIdentifiers(columnsHeader);
        String subjectName= BoxStudent.getSelectedSubjectName().getText();
        List<Mark> subjectMarks = TableStudents.getSelectedStudent().getAverageMarkSubject(subjectName).getSubjectMark();

        for (Mark mark : subjectMarks){
            tableModel.addRow(getDataSubjectMarks(mark));
        }
        return tableModel;
    }
    public static Object[] getDataSubjectMarks (Mark mark){
        return new String[]{String.valueOf(mark.getCurrentMark())};
    }
}
