package gui.tables;

import models.Student;
import services.StudentServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.List;

public class TableModelStudents extends JFrame {
    private static final Object[] columnsHeader = new String[] {"ID студента", "Фамилия", "Имя", "Отчество", "Дата начала обучения", "Дата окончания обучения"};

    public static Object[] getColumnsHeader() {
        return columnsHeader;
    }

    public static TableModel createTableModelStudents(String searchQuery){
        DefaultTableModel tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        tableModel.setColumnIdentifiers(columnsHeader);

        StudentServiceImpl studentService = new StudentServiceImpl();

        List<Student> studentList = studentService.readListStudents(searchQuery);

        for (Student student : studentList){
            System.out.println(student);
            Object[] arrayStudent = new String[]{
                    String.valueOf(student.getId()),
                    student.getSurname(), student.getName(), student.getPatronymic(),
                    String.valueOf(student.getDateStartLearning()), String.valueOf(student.getDateEndLearning())};

            tableModel.addRow(arrayStudent);            
        }
        return tableModel;
    }
}
