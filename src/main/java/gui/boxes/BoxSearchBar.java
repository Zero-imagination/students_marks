package gui.boxes;

import gui.tables.model.TableModelStudents;
import gui.tables.TableStudents;

import javax.swing.*;
import java.awt.*;

public class BoxSearchBar {
    public static Box create(){
        JLabel labelSearchBar = new JLabel("Введите данные студента");
        labelSearchBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JTextField searchBar = new JTextField();
        searchBar.setMaximumSize(new Dimension(200,32));
        searchBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JButton btnUpdate = new JButton("Поиск");
        btnUpdate.addActionListener(e -> TableStudents.getTable().setModel(TableModelStudents.create(searchBar.getText())));

        Box boxSearchBar = new Box(BoxLayout.X_AXIS);
        boxSearchBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        boxSearchBar.add(labelSearchBar);
        boxSearchBar.add(searchBar);
        boxSearchBar.add(btnUpdate);
        return boxSearchBar;
    }
}
