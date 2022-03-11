package gui.tables;

import gui.ButtonControlMark;
import gui.boxes.BoxStudent;
import gui.tables.model.TableModelSubjectMarks;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableAvgMarks {
    private static JTable table;
    private  static String selectedSubject;

    public static String getSelectedSubject() {
        return selectedSubject;
    }

    public static JTable getTable() {
        return table;
    }

    public static JTable create() {
        JTable tableAvgMarks = new JTable();
        tableAvgMarks.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tableAvgMarks.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    selectedSubject =tableAvgMarks.getValueAt(row,0).toString();
                    ButtonControlMark.enableButtonDeleteUpdate(false);
                    TableSubjectMarks.getTable().setModel(TableModelSubjectMarks.create());
                    ((JComboBox<?>) BoxStudent.getInfoMarkFields().get(0)).setSelectedItem((tableAvgMarks.getValueAt(row,0).toString()));
                    ((JTextField)BoxStudent.getInfoMarkFields().get(1)).setText("");
                }
            }
        });
        table=tableAvgMarks;
        return  tableAvgMarks;
    }
    public static void refresh(){
        ButtonControlMark.enableButtonDeleteUpdate(false);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }
}
