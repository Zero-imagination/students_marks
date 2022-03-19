package gui.tables;

import gui.buttons.ButtonControlMark;
import gui.boxes.BoxMarkInfo;
import gui.boxes.BoxStudentInfo;
import evaluation.model.Mark;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;


//сделать сортировку оценок по умолчанию
public class TableSubjectMarks {
    private static JTable table;
    private static Mark selectedMark;
    public static Mark getSelectedMark() {
        return selectedMark;
    }
    public static JTable getTable() {
        return table;
    }

    public static JTable create(){
        JTable tableSubjectMarks = new JTable(){
            @Override
            public Class<?> getColumnClass(int column) {
                if(convertColumnIndexToModel(column)==0) return Object.class;
                return super.getColumnClass(column);
            }
        };
        Color green = new Color(153,204,153);
        Color lightGreen = new Color(231,255,206);
        Color lightOrange = new Color(242,219,180);
        Color lightRed = new Color(255,213,206);
        tableSubjectMarks.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);

                if (Double.parseDouble(value.toString()) >4.0) c.setBackground(green);
                else if (Double.parseDouble(value.toString()) >3.0) c.setBackground(lightGreen);
                else if (Double.parseDouble(value.toString()) >2.0) c.setBackground(lightOrange);
                else c.setBackground(lightRed);
                return c;
            }
        });
        tableSubjectMarks.setAutoCreateRowSorter(true);

        tableSubjectMarks.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tableSubjectMarks.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    double currentMark = Double.parseDouble(String.valueOf(tableSubjectMarks.getValueAt(row,0)));
                    String subjectName= BoxStudentInfo.getSelectedSubjectName().getText();
                    List<Mark> subjectMarks = TableStudents.getSelectedStudent().getAverageMarkSubject(subjectName).getSubjectMark();
                    for (Mark mark : subjectMarks){
                        if(mark.getCurrentMark()==currentMark)
                            selectedMark =mark;
                    }
                    ButtonControlMark.enableButtonUpdateDeleteMark(true);
                    ((JTextField) BoxMarkInfo.getInfoMarkFields().get(1)).setText(tableSubjectMarks.getValueAt(row,0).toString());
                    (BoxMarkInfo.getInfoMarkFields().get(0)).setEnabled(false);
                }
            }
        });
        table =tableSubjectMarks;
        return tableSubjectMarks;
    }

    public static void refresh(){
        ButtonControlMark.enableButtonUpdateDeleteMark(false);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

}
