package gui.boxes;

import authentication.UserPermissions;
import authentication.model.User;
import authentication.services.UserAuthorization;
import gui.Gui;

import javax.swing.*;
import java.awt.*;

public class BoxLogin {
    public static Box create(){
        Font primaryFont = new Font("TimesRoman", Font.PLAIN, 14);
        JLabel labelError = new JLabel("Введен неверный логин или пароль");
        labelError.setForeground(Color.RED);
        labelError.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        labelError.setVisible(false);
        JLabel labelUsername = new JLabel("Логин");
        labelUsername.setFont(primaryFont);
        JLabel labelPassword = new JLabel("Пароль");
        labelPassword.setFont(primaryFont);
        JTextField fieldUsername = new JTextField();
        fieldUsername.setFont(primaryFont);
        fieldUsername.setPreferredSize(new Dimension(150,20));
        JPasswordField fieldPassword = new JPasswordField();
        fieldPassword.setFont(primaryFont);
        fieldPassword.setPreferredSize(new Dimension(150,20));
        fieldPassword.setEchoChar('*');


        JButton buttonLogin = new JButton("Вход");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(buttonLogin);
        JPanel contents = new JPanel(new GridLayout(7,1,0,5));
        contents.setMaximumSize(new Dimension(200,350));
        contents.add(labelError);
        contents.add(labelUsername);
        contents.add(fieldUsername);
        contents.add(labelPassword);
        contents.add(fieldPassword);
        contents.add(buttonPanel);

        buttonLogin.addActionListener(e -> {
            UserAuthorization userAuthorization = new UserAuthorization();
            User user = userAuthorization.getAuthenticatedUser(fieldUsername.getText(), new String(fieldPassword.getPassword()));
            if (user!=null)
            {
                Gui.getPanelAuthentication().remove(0);
                Gui.getPanelAuthentication().add(BoxLogout.create(user.getUsername()));
                UserPermissions.setUserRole(user.getRoles());
                UserPermissions.createPermissions();
                Gui.addPanelStudents();
                labelError.setVisible(false);
            } else {
                labelError.setVisible(true);
            }
        });

        JPanel toCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        toCenter.setMaximumSize(new Dimension(6000,250));
        toCenter.add(contents);

        Box boxAuthentication = new Box(BoxLayout.X_AXIS);
        boxAuthentication.add(toCenter);
        return boxAuthentication;
    }
}
