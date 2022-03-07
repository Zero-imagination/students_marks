package gui.tables;

import models.Mark;
import models.Student;
import services.StudentServiceImpl;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Set;

public class TableModelMarks {
    private static final Object[] columnsHeader = new String[] {"Предмет", "Оценка"};
    public static TableModel createTableModelMark(int id){
        DefaultTableModel tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        tableModel.setColumnIdentifiers(columnsHeader);

        StudentServiceImpl studentService = new StudentServiceImpl();

        Student student = studentService.readStudent(id);
        Set<Mark> marks = student.getAllMarks();

        for (Mark mark : marks){
            System.out.println(student);
            Object[] arrayMark = new String[]{
                    mark.getSubject().getSubjectName(),
                    String.valueOf(mark.getCurrentMark())
                    };

            tableModel.addRow(arrayMark);
        }
        return tableModel;
    }

}
