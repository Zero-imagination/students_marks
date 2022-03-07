package gui.tables;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TableStudents {
    private static ArrayList<JTextField> infoTextFields = new ArrayList<>();
    private static int clickedRow;
    private static JTable currentTableStudents;

    public static void setInfoTextFields(ArrayList<JTextField> infoTextFields) {
        TableStudents.infoTextFields = infoTextFields;
    }

    public static JTable createTable(JTable tableMarks){
        JTable tableStudents = new JTable();
        tableStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tableStudents.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    clickedRow=row;
                    tableMarks.setModel(TableModelMarks.createTableModelMark(Integer.parseInt(tableStudents.getValueAt(row,0).toString())));
                    for (int i = 0; i < 6; i++){
                        infoTextFields.get(i).setText(tableStudents.getValueAt(row,i).toString());
                    }
                }
            }
        });
        currentTableStudents=tableStudents;
        return tableStudents;
    }
    public static void deleteRowTableStudents(){
        ((DefaultTableModel)currentTableStudents.getModel()).removeRow(clickedRow);
    }
}
