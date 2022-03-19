package gui.boxes;

import authentication.model.Role;
import gui.Gui;
import gui.buttons.ButtonControlStudent;
import gui.buttons.TypeButton;
import gui.tables.model.TableModelStudents;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoxStudentInfo {
    private static Box boxControlStudent;
    private static final ArrayList<JTextField> infoTextFields = new ArrayList<>();
    private static final JLabel selectedSubjectName = new JLabel("Название предмета");

    public static Box getBoxControlStudent() {
        return boxControlStudent;
    }

    public static ArrayList<JTextField> getInfoTextFields() {
        return infoTextFields;
    }
    public static JLabel getSelectedSubjectName() {
        return selectedSubjectName;
    }

    public static Box create(){
        Font primaryFont = new Font("TimesRoman", Font.PLAIN, 14);

        JPanel gridPanelFields = new JPanel();
        gridPanelFields.setLayout(new GridLayout(13,1,10,0));
        gridPanelFields.setBorder((BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        gridPanelFields.setMaximumSize(new Dimension(200,600));

        JLabel labelStudentTitle = new JLabel("Студент");
        labelStudentTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));

        gridPanelFields.add(labelStudentTitle);

        ArrayList<JLabel> infoLabels = new ArrayList<>();
        for (int i = 0; i<6; i++){
            infoLabels.add(new JLabel((String) TableModelStudents.getColumnsHeader()[i]));
            infoLabels.get(i).setMaximumSize(new Dimension(200, 20));
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

        boxControlStudent = new Box(BoxLayout.LINE_AXIS);
        boxControlStudent.setMaximumSize(new Dimension(300,70));
        JButton btnUpdateStudent = ButtonControlStudent.createButton(TypeButton.UPDATE);
        btnUpdateStudent.setText("Редактировать");
        JButton btnCreateStudent = ButtonControlStudent.createButton(TypeButton.CREATE);
        btnCreateStudent.setText("Создать");
        JButton btnDeleteStudent = ButtonControlStudent.createButton(TypeButton.DELETE);
        btnDeleteStudent.setText("Удалить");
        boxControlStudent.add(btnUpdateStudent);
        boxControlStudent.add(btnCreateStudent);
        boxControlStudent.add(btnDeleteStudent);

        Box boxStudentInfo = new Box(BoxLayout.PAGE_AXIS);
        boxStudentInfo.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        boxStudentInfo.setMaximumSize(new Dimension(300,500));
        boxStudentInfo.add(gridPanelFields);
        boxStudentInfo.add(boxControlStudent);

        return boxStudentInfo;
    }
}
