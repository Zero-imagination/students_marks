package gui.boxes;

import gui.buttons.ButtonControlMark;
import gui.ComboBoxSubjects;
import gui.buttons.TypeButton;
import gui.tables.TableAvgMarks;
import gui.tables.TableSubjectMarks;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoxMarkInfo {
    private static final ArrayList<JComponent> infoMarkFields = new ArrayList<>();
    public static ArrayList<JComponent> getInfoMarkFields(){
        return infoMarkFields;
    }
    public static Box create(){
        Box boxMarkInfo = new Box(BoxLayout.Y_AXIS);

        JLabel subjectName = BoxStudentInfo.getSelectedSubjectName();
        JPanel panelHeaderSubjectName = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelHeaderSubjectName.setMaximumSize(new Dimension(320,30));
        panelHeaderSubjectName.add(subjectName);

        JScrollPane scrollTableAvgMarks = new JScrollPane(TableAvgMarks.create());
        scrollTableAvgMarks.setMaximumSize(new Dimension(400, 1000));
        scrollTableAvgMarks.setMinimumSize(new Dimension(250, 100));
        JScrollPane scrollTableSubjectMarks = new JScrollPane(TableSubjectMarks.create());
        scrollTableSubjectMarks.setMaximumSize(new Dimension(150,1000));

        Box boxTables = new Box(BoxLayout.X_AXIS);
        boxTables.setMaximumSize(new Dimension(400,1000));
        boxTables.add(scrollTableAvgMarks);
        boxTables.add(scrollTableSubjectMarks);

        infoMarkFields.add(ComboBoxSubjects.create());
        infoMarkFields.add(new JTextField());
        JLabel labelMark = new JLabel("Оценка");
        JButton buttonCreateMark = ButtonControlMark.create(TypeButton.CREATE);
        buttonCreateMark.setText("Добавить");
        JButton buttonUpdateMark = ButtonControlMark.create(TypeButton.UPDATE);
        buttonUpdateMark.setText("Редактировать");
        JButton buttonDeleteMark = ButtonControlMark.create(TypeButton.DELETE);
        buttonDeleteMark.setText("Удалить");
        ButtonControlMark.setButtonControlMark(buttonCreateMark, buttonUpdateMark, buttonDeleteMark);

        JPanel panelGridControlMark = new JPanel(new GridLayout(2,3));
        panelGridControlMark.setMaximumSize(new Dimension(350,100));
        panelGridControlMark.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panelGridControlMark.add(labelMark);
        panelGridControlMark.add(infoMarkFields.get(1));
        panelGridControlMark.add(infoMarkFields.get(0));
        panelGridControlMark.add(buttonCreateMark);
        panelGridControlMark.add(buttonUpdateMark);
        panelGridControlMark.add(buttonDeleteMark);

        boxMarkInfo.add(panelHeaderSubjectName);
        boxMarkInfo.add(boxTables);
        boxMarkInfo.add(panelGridControlMark);
        return boxMarkInfo;
    }
}
