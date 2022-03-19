package gui.tables;

import gui.buttons.ButtonControlMark;
import gui.boxes.BoxMarkInfo;
import gui.boxes.BoxStudentInfo;
import gui.tables.model.TableModelSubjectMarks;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class TableAvgMarks {
    private static JTable table;

    public static JTable getTable() {
        return table;
    }

    public static JTable create() {
        JTable tableAvgMarks = new JTable();
        tableAvgMarks.setAutoCreateRowSorter(true);
        tableAvgMarks.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tableAvgMarks.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    String selectedSubject = String.valueOf(tableAvgMarks.getValueAt(row,0));
                    BoxStudentInfo.getSelectedSubjectName().setText(selectedSubject);
                    TableSubjectMarks.getTable().setModel(TableModelSubjectMarks.create());
                    ButtonControlMark.enableButtonCreateMark(true);
                    ButtonControlMark.enableButtonUpdateDeleteMark(false);
                    (BoxMarkInfo.getInfoMarkFields().get(0)).setEnabled(true);
                    ((JComboBox<?>) BoxMarkInfo.getInfoMarkFields().get(0)).setSelectedItem((tableAvgMarks.getValueAt(row,0).toString()));
                }
            }
        });
        table=tableAvgMarks;
        return  tableAvgMarks;
    }
    public static void refresh(){
        ButtonControlMark.enableButtonUpdateDeleteMark(false);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }
}
