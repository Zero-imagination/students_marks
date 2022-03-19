package gui.boxes;

import authentication.UserPermissions;
import gui.Gui;
import gui.tables.TableAvgMarks;
import gui.tables.TableStudents;
import gui.tables.TableSubjectMarks;

import javax.swing.*;
import java.awt.*;

public class BoxLogout {
    public static Box create(String userLogin){
        JPanel contents = new JPanel(new GridLayout(6,1,0,7));
        contents.setMaximumSize(new Dimension(200,150));
        Font primaryFont = new Font("TimesRoman", Font.PLAIN, 14);
        JLabel labelTitleUsername = new JLabel("Пользователь:");
        labelTitleUsername.setFont(primaryFont);
        JLabel labelUsername = new JLabel(userLogin);
        labelUsername.setFont(primaryFont);
        JButton buttonLogout = new JButton("Выйти из аккаунта");

        contents.add(labelTitleUsername);
        contents.add(labelUsername);
        contents.add(buttonLogout);

        buttonLogout.addActionListener(e -> {
            TableAvgMarks.refresh();
            TableSubjectMarks.refresh();
            TableStudents.refresh();
            Gui.getPanelAuthentication().remove(0);
            Gui.getPanelAuthentication().add(BoxLogin.create());
            UserPermissions.setUserRole(null);
            Gui.removePanelStudents();
        });

        JPanel toCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        toCenter.setMaximumSize(new Dimension(6000,150));
        toCenter.add(contents);

        Box boxAuthentication = new Box(BoxLayout.X_AXIS);
        boxAuthentication.add(toCenter);
        return boxAuthentication;
    }
}
