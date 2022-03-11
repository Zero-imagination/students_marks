package gui.tables;

import gui.ButtonControlMark;
import gui.boxes.BoxStudent;
import models.Mark;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Set;


public class TableSubjectMarks {
    private static JTable table;
    private static Mark selectedSubjectMark;
    //private static int selectedRow;

    public static Mark getSelectedSubjectMark() {

        return selectedSubjectMark;
    }

    public static JTable getTable() {
        return table;
    }

    public static JTable create(){
        JTable tableSubjectMarks = new JTable();

        tableSubjectMarks.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tableSubjectMarks.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    Set<Mark> marks = TableStudents.getSelectedStudent().getAllMarks();
                    for (Mark mark : marks){
                        if (mark.getCurrentMark()==Double.parseDouble(tableSubjectMarks.getValueAt(row,0).toString())){
                            TableSubjectMarks.selectedSubjectMark=mark;
                            break;
                        }
                    }
                    //selectedRow =row;

                    ButtonControlMark.enableButtonDeleteUpdate(true);

                    ((JTextField)BoxStudent.getInfoMarkFields().get(1)).setText(tableSubjectMarks.getValueAt(row,0).toString());
                }
            }
        });
        table =tableSubjectMarks;
        return tableSubjectMarks;
    }

    public static void refresh(){
        ButtonControlMark.enableButtonDeleteUpdate(false);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }
    /*public static void deleteRow(){
        ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
    }
    public static void addRow(Object[] rowData)
    {
        ((DefaultTableModel) table.getModel()).addRow(rowData);
    }
    public static void updateRow(Object[] rowData){
        ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
        ((DefaultTableModel) table.getModel()).insertRow(selectedRow, rowData);
    }*/
}
