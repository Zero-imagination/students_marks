package gui.boxes;

import gui.tables.TableModelStudents;

import javax.swing.*;
import java.awt.*;

public class BoxSearchBar {
    public static Box createBox(JTable tableStudents) {
        Box boxSearchBar = new Box(BoxLayout.X_AXIS);
        JLabel labelSearchBar = new JLabel("Введите данные студента");
        JTextField searchBar = new JTextField();
        JButton btnUpdate = new JButton("Поиск");

        boxSearchBar.add(labelSearchBar);
        boxSearchBar.add(searchBar);
        boxSearchBar.add(btnUpdate);

        btnUpdate.addActionListener(e -> tableStudents.setModel(TableModelStudents.createTableModelStudents(searchBar.getText())));

        boxSearchBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        labelSearchBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        searchBar.setMaximumSize(new Dimension(200,32));
        searchBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return boxSearchBar;
    }
}
