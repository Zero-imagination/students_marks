package gui;

import gui.tables.TableStudents;
import models.Student;
import services.StudentServiceImpl;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class ButtonControlStudent {

    private static ArrayList<JTextField> infoTextFields = new ArrayList<>();

    public static void setInfoTextFields(ArrayList<JTextField> infoTextFields) {
        ButtonControlStudent.infoTextFields = infoTextFields;
    }
    public static JButton createButton(JFrame frame, TypeButton typeButton){
        StudentServiceImpl studentService = new StudentServiceImpl();
        JButton button = new JButton();
        button.addActionListener(e -> {
            {
                try {
                    for (JTextField jTextField : infoTextFields){
                        if(jTextField.getText() == null || jTextField.getText().length() == 0){
                            throw new IllegalArgumentException();
                        }
                    }
                    int studentId =Integer.parseInt(infoTextFields.get(0).getText());
                    Student student = studentService.readStudent(studentId);
                    student.setSurname(infoTextFields.get(1).getText());
                    student.setName(infoTextFields.get(2).getText());
                    student.setPatronymic(infoTextFields.get(3).getText());
                    student.setDateStartLearning(LocalDate.parse(infoTextFields.get(4).getText()));
                    student.setDateEndLearning(LocalDate.parse(infoTextFields.get(5).getText()));
                    switch (typeButton){
                        case UPDATE -> studentService.updateStudent(student);
                        case CREATE -> {
                            student.setAllMarks(null);
                            studentService.createStudent(student);
                        }
                        case DELETE -> {
                            studentService.deleteStudent(studentId);
                            TableStudents.deleteRowTableStudents();
                        }
                    }
                    JOptionPane.showMessageDialog(frame, "Данные успешно отредактированы!");
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(frame, "Введена неверная дата!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Введены неверные данные!");
                }catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, "Введены не все данные!");
                }
            }
        });
        return button;
    }

}
