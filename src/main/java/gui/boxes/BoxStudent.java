package gui.boxes;

import gui.ButtonControlStudent;
import gui.TypeButton;
import gui.tables.TableModelStudents;
import gui.tables.TableStudents;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoxStudent {
    public static Box createBox(JFrame mainFrame, JTable tableMarks){
        Box boxStudent = new Box(BoxLayout.X_AXIS);
        Box boxStudentInfo = new Box(BoxLayout.PAGE_AXIS);
        JLabel labelStudentTitle = new JLabel("Студент");
        JButton btnUpdateStudent = ButtonControlStudent.createButton(mainFrame, TypeButton.UPDATE);
        btnUpdateStudent.setText("Редактировать");
        JButton btnCreateStudent = ButtonControlStudent.createButton(mainFrame, TypeButton.CREATE);
        btnCreateStudent.setText("Создать");
        JButton btnDeleteStudent = ButtonControlStudent.createButton(mainFrame, TypeButton.DELETE);
        btnDeleteStudent.setText("Удалить");

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(13,1,10,0));
        grid.setBorder((BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        grid.setMaximumSize(new Dimension(200,600));

        grid.add(labelStudentTitle);

        ArrayList<JLabel> infoLabels = new ArrayList<>();
        for (int i = 0; i<6; i++){
            infoLabels.add(new JLabel((String) TableModelStudents.getColumnsHeader()[i]));
            infoLabels.get(i).setMaximumSize(new Dimension(170, 20));
            //infoLabels.get(i).setBorder(BorderFactory.createEmptyBorder(0, -50, 0, 0));
        }
        ArrayList<JTextField> infoTextFields = new ArrayList<>();
        for (int i = 0; i<6; i++){
            infoTextFields.add(new JTextField());
            infoTextFields.get(i).setMaximumSize(new Dimension(170, 20));
        }
        infoTextFields.get(0).setEditable(false);
        for (int i = 0; i<6; i++){
            grid.add(infoLabels.get(i));
            grid.add(infoTextFields.get(i));
        }

        TableStudents.setInfoTextFields(infoTextFields);
        ButtonControlStudent.setInfoTextFields(infoTextFields);

        Box buttonControlStudent = new Box(BoxLayout.LINE_AXIS);
        buttonControlStudent.setMaximumSize(new Dimension(300,70));
        buttonControlStudent.add(btnUpdateStudent);
        buttonControlStudent.add(btnCreateStudent);
        buttonControlStudent.add(btnDeleteStudent);

        boxStudentInfo.add(grid);
        boxStudentInfo.add(buttonControlStudent);

        JScrollPane scrollTableMarks = new JScrollPane(tableMarks);

        boxStudent.add(boxStudentInfo);
        boxStudent.add(scrollTableMarks);

        labelStudentTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
        boxStudentInfo.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        scrollTableMarks.setMaximumSize(new Dimension(300,400));
        return boxStudent;
    }
}
