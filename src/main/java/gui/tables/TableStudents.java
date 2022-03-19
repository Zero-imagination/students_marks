package gui.tables;

import gui.buttons.ButtonControlMark;
import gui.boxes.BoxMarkInfo;
import gui.boxes.BoxStudentInfo;
import gui.tables.model.TableModelAvgMarks;
import evaluation.model.Student;
import evaluation.services.StudentServiceImpl;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableStudents {
    private static Student selectedStudent;
    private static int selectedRow;
    private static JTable table;

    public static Student getSelectedStudent() {
        return selectedStudent;
    }
    public static void setSelectedStudent(Student student) {
        selectedStudent = student;
    }
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
                        BoxStudentInfo.getInfoTextFields().get(i).setText(tableStudents.getValueAt(row,i).toString());
                    }
                }
                ButtonControlMark.enableButtonCreateMark(true);
                (BoxMarkInfo.getInfoMarkFields().get(0)).setEnabled(true);
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
    public static void refresh(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

}
