package gui;

import gui.boxes.BoxSearchBar;
import gui.boxes.BoxStudent;
import gui.tables.TableStudents;

import javax.swing.*;
import java.awt.*;

public class Gui {
    public static void createGui()
    {
        JFrame frame = new JFrame("Students and marks");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable tableMarks = new JTable();
        JTable tableStudents = TableStudents.createTable(tableMarks);

        Box contents = new Box(BoxLayout.Y_AXIS);

        JScrollPane scrollTableStudents = new JScrollPane(tableStudents);
        Box boxStudent = BoxStudent.createBox(frame, tableMarks);
        Box boxSearchBar = BoxSearchBar.createBox(tableStudents);
        scrollTableStudents.setMaximumSize(new Dimension(4000, 300));

        contents.add(boxSearchBar);
        contents.add(scrollTableStudents);
        contents.add(boxStudent);

        frame.getContentPane().add(contents);
        frame.setSize(700,700);
        frame.setVisible(true);
    }
}
