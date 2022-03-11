package gui.tables.model;

import gui.tables.TableAvgMarks;
import gui.tables.TableStudents;
import models.Mark;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Objects;
import java.util.Set;

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
        Set<Mark> marks = TableStudents.getSelectedStudent().getAllMarks();


        for (Mark mark : marks){
            if (Objects.equals(mark.getSubject().getSubjectName(), TableAvgMarks.getSelectedSubject())){
                //TableSubjectMarks.setSelectedSubjectMark(mark);
                tableModel.addRow(getDataSubjectMarks(mark));
            }
        }
        return tableModel;
    }
    public static Object[] getDataSubjectMarks (Mark mark){
        return new String[]{String.valueOf(mark.getCurrentMark())};
    }
}
