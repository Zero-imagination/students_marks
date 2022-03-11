package gui.tables;

import gui.boxes.BoxStudent;
import gui.tables.model.TableModelAvgMarks;
import models.Student;
import services.StudentServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableStudents {
    private static int selectedRow;
    private static JTable table;

    public static Student getSelectedStudent() {
        return selectedStudent;
    }

    public static void setSelectedStudent(Student selectedStudent) {
        TableStudents.selectedStudent = selectedStudent;
    }

    private static Student selectedStudent;

    public static JTable getTable() {
        return table;
    }

    public static JTable create(){
        JTable tableStudents = new JTable();
        tableStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentServiceImpl studentService = new StudentServiceImpl();
                int row = tableStudents.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    selectedRow =row;
                    selectedStudent=studentService.readStudent(Integer.parseInt(tableStudents.getValueAt(row,0).toString()));
                    TableAvgMarks.getTable().setModel(TableModelAvgMarks.create());
                    for (int i = 0; i < 6; i++){
                        BoxStudent.getInfoTextFields().get(i).setText(tableStudents.getValueAt(row,i).toString());
                    }
                }
                TableSubjectMarks.refresh();
            }
        });
        table =tableStudents;
        return tableStudents;
    }
    public static void deleteRow(){
        ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
    }
    public static void addRow(Object[] rowData)
    {
        ((DefaultTableModel) table.getModel()).addRow(rowData);
    }
    public static void updateRow(Object[] rowData){
        ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
        ((DefaultTableModel) table.getModel()).insertRow(selectedRow, rowData);
    }
}
