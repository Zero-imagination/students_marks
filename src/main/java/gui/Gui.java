package gui;

import gui.boxes.BoxSearchBar;
import gui.boxes.BoxStudent;
import gui.tables.TableStudents;

import javax.swing.*;
import java.awt.*;

public class Gui {
    private static final JFrame mainFrame = new JFrame();

    public static JFrame getMainFrame() {
        return mainFrame;
    }

    public static void createGui()
    {
        mainFrame.setTitle("Students and marks");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Box contents = new Box(BoxLayout.Y_AXIS);

        JScrollPane scrollTableStudents = new JScrollPane(TableStudents.create());
        Box boxStudent = BoxStudent.create();
        Box boxSearchBar = BoxSearchBar.create();

        scrollTableStudents.setMaximumSize(new Dimension(4000, 300));

        contents.add(boxSearchBar);
        contents.add(scrollTableStudents);
        contents.add(boxStudent);

        mainFrame.getContentPane().add(contents);
        mainFrame.setSize(700,700);
        mainFrame.setVisible(true);
    }
}
