package gui.boxes;

import gui.ButtonControlMark;
import gui.ButtonControlStudent;
import gui.ComboBoxSubjects;
import gui.TypeButton;
import gui.tables.TableAvgMarks;
import gui.tables.model.TableModelStudents;
import gui.tables.TableSubjectMarks;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoxStudent {
    private static final ArrayList<JTextField> infoTextFields = new ArrayList<>();
    private static final ArrayList<JComponent> infoMarkFields = new ArrayList<>();
    public static ArrayList<JComponent> getInfoMarkFields(){return infoMarkFields;}
    public static ArrayList<JTextField> getInfoTextFields() {
        return infoTextFields;
    }

    public static Box create(){
        Font primaryFont = new Font("TimesRoman", Font.PLAIN, 14);
        Box boxStudent = new Box(BoxLayout.X_AXIS);
        Box boxStudentInfo = new Box(BoxLayout.PAGE_AXIS);
        JLabel labelStudentTitle = new JLabel("Студент");
        JButton btnUpdateStudent = ButtonControlStudent.createButton(TypeButton.UPDATE);
        btnUpdateStudent.setText("Редактировать");
        JButton btnCreateStudent = ButtonControlStudent.createButton(TypeButton.CREATE);
        btnCreateStudent.setText("Создать");
        JButton btnDeleteStudent = ButtonControlStudent.createButton(TypeButton.DELETE);
        btnDeleteStudent.setText("Удалить");

        JPanel gridPanelFields = new JPanel();
        gridPanelFields.setLayout(new GridLayout(13,1,10,0));
        gridPanelFields.setBorder((BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        gridPanelFields.setMaximumSize(new Dimension(200,600));

        gridPanelFields.add(labelStudentTitle);

        ArrayList<JLabel> infoLabels = new ArrayList<>();
        for (int i = 0; i<6; i++){
            infoLabels.add(new JLabel((String) TableModelStudents.getColumnsHeader()[i]));
            //infoLabels.get(i).setFont(primaryFont);
            infoLabels.get(i).setMaximumSize(new Dimension(200, 20));

            //infoLabels.get(i).setBorder(BorderFactory.createEmptyBorder(0, -50, 0, 0));
        }
        for (int i = 0; i<6; i++){
            infoTextFields.add(new JTextField());
            infoTextFields.get(i).setFont(primaryFont);
            infoTextFields.get(i).setMaximumSize(new Dimension(170, 20));
        }
        infoTextFields.get(0).setEditable(false);
        for (int i = 0; i<6; i++){
            gridPanelFields.add(infoLabels.get(i));
            gridPanelFields.add(infoTextFields.get(i));
        }

        Box boxControlStudent = new Box(BoxLayout.LINE_AXIS);
        boxControlStudent.setMaximumSize(new Dimension(300,70));
        boxControlStudent.add(btnUpdateStudent);
        boxControlStudent.add(btnCreateStudent);
        boxControlStudent.add(btnDeleteStudent);

        boxStudentInfo.add(gridPanelFields);
        boxStudentInfo.add(boxControlStudent);

        JPanel panelGridControlMark = new JPanel();
        panelGridControlMark.setLayout(new GridLayout(4,2));
        JLabel labelMark = new JLabel("Оценка");
        JLabel labelSubject = new JLabel("Предмет");
        infoMarkFields.add(ComboBoxSubjects.create());
        infoMarkFields.add(new JTextField());


        JButton buttonCreateMark = ButtonControlMark.create(TypeButton.CREATE);
        buttonCreateMark.setText("Добавить");
        JButton buttonUpdateMark = ButtonControlMark.create(TypeButton.UPDATE);
        buttonUpdateMark.setText("Редактировать");
        JButton buttonDeleteMark = ButtonControlMark.create(TypeButton.DELETE);
        buttonDeleteMark.setText("Удалить");


        panelGridControlMark.add(labelSubject);
        panelGridControlMark.add(infoMarkFields.get(0));
        panelGridControlMark.add(labelMark);
        panelGridControlMark.add(infoMarkFields.get(1));
        panelGridControlMark.add(buttonCreateMark);
        panelGridControlMark.add(buttonUpdateMark);
        panelGridControlMark.add(buttonDeleteMark);


        JScrollPane scrollTableAvgMarks = new JScrollPane(TableAvgMarks.create());
        JScrollPane scrollTableSubjectMarks = new JScrollPane(TableSubjectMarks.create());


        Box boxTableMarks = new Box(BoxLayout.Y_AXIS);
        Box boxTables = new Box(BoxLayout.X_AXIS);
        boxTables.add(scrollTableAvgMarks);
        boxTables.add(scrollTableSubjectMarks);

        boxTableMarks.add(boxTables);
        boxTableMarks.add(panelGridControlMark);


        boxStudent.add(boxStudentInfo);
        boxStudent.add(boxTableMarks);

        gridPanelFields.setMaximumSize(new Dimension(200, 400));
        labelStudentTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
        boxStudentInfo.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panelGridControlMark.setMaximumSize(new Dimension(300,400));
        panelGridControlMark.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        scrollTableSubjectMarks.setMaximumSize(new Dimension(150,400));
        scrollTableAvgMarks.setMaximumSize(new Dimension(300,400));
        scrollTableAvgMarks.setMinimumSize(new Dimension(200,400));
        boxTables.setMaximumSize(new Dimension(350,400));
        return boxStudent;
    }
}
