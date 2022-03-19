package gui;

import authentication.model.Role;
import gui.boxes.*;
import gui.tables.TableStudents;
import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class Gui {
    private static final JPanel panelAuthentication = new JPanel(new BorderLayout());
    private static final JFrame mainFrame = new JFrame();
    private static JPanel panelStudents;
    private static JTabbedPane tabbedPaneMenu;


    public static JPanel getPanelAuthentication() {
        return panelAuthentication;
    }


    public static JFrame getMainFrame() {
        return mainFrame;
    }

    public static void createGui()
    {
        mainFrame.setTitle("Students and marks");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPaneMenu = new JTabbedPane(JTabbedPane.TOP);
        panelAuthentication.add(BoxLogin.create());
        tabbedPaneMenu.addTab("<html><i>Авторизация", null, panelAuthentication, "Авторизация пользователя");

        JScrollPane scrollTableStudents = new JScrollPane(TableStudents.create());
        scrollTableStudents.setMaximumSize(new Dimension(4000, 300));
        Box boxStudent = new Box(BoxLayout.X_AXIS);
        boxStudent.add(BoxStudentInfo.create());
        boxStudent.add(BoxMarkInfo.create());

        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(BoxSearchBar.create());
        contents.add(scrollTableStudents);
        contents.add(boxStudent);

        panelStudents = new JPanel(new BorderLayout());
        panelStudents.add(contents);

        mainFrame.getContentPane().add(tabbedPaneMenu);
        mainFrame.setSize(800,700);
        mainFrame.setVisible(true);
    }

    public static void addPanelStudents(){
        tabbedPaneMenu.setTitleAt(0,"Пользователь");
        tabbedPaneMenu.addTab("<html><i>Студенты", null, panelStudents, "Поиск студентов, просмотр оценок");
        tabbedPaneMenu.setSelectedIndex(1);
    }
    public static void removePanelStudents(){
        tabbedPaneMenu.removeTabAt(1);
        tabbedPaneMenu.setTitleAt(0,"Авторизация");
    }
}
