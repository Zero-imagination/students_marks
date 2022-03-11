package gui;

import gui.boxes.BoxStudent;
import gui.tables.TableAvgMarks;
import gui.tables.TableSubjectMarks;
import gui.tables.model.TableModelStudents;
import gui.tables.TableStudents;
import models.Student;
import services.StudentServiceImpl;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ButtonControlStudent {
    public static JButton createButton(TypeButton typeButton){
        JButton button = new JButton();
        button.addActionListener(e -> {
            {
                try {
                    for (JTextField jTextField : BoxStudent.getInfoTextFields()){
                        if(jTextField.getText() == null || jTextField.getText().length() == 0){
                            throw new IllegalArgumentException();
                        }
                    }
                    StudentServiceImpl studentService = new StudentServiceImpl();
                    Student student = TableStudents.getSelectedStudent();
                    student.setSurname(BoxStudent.getInfoTextFields().get(1).getText());
                    student.setName(BoxStudent.getInfoTextFields().get(2).getText());
                    student.setPatronymic(BoxStudent.getInfoTextFields().get(3).getText());
                    student.setDateStartLearning(LocalDate.parse(BoxStudent.getInfoTextFields().get(4).getText()));
                    student.setDateEndLearning(LocalDate.parse(BoxStudent.getInfoTextFields().get(5).getText()));
                    switch (typeButton){
                        case UPDATE -> {
                            studentService.updateStudent(student);
                            TableStudents.updateRow(TableModelStudents.getDataStudent(student));
                        }
                        case CREATE -> {
                            student.setAllMarks(null);
                            studentService.createStudent(student);
                            TableStudents.addRow(TableModelStudents.getDataStudent(student));
                            BoxStudent.getInfoTextFields().get(0).setText(String.valueOf(student.getId()));
                            TableSubjectMarks.refresh();
                            TableAvgMarks.refresh();
                        }
                        case DELETE -> {
                            studentService.deleteStudent(student.getId());
                            TableStudents.deleteRow();
                            TableSubjectMarks.refresh();
                            TableAvgMarks.refresh();
                        }
                    }
                    JOptionPane.showMessageDialog(Gui.getMainFrame(), "Данные успешно отредактированы!");
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(Gui.getMainFrame(), "Введена неверная дата!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Gui.getMainFrame(), "Введены неверные данные!");
                }catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(Gui.getMainFrame(), "Введены не все данные!");
                }
            }
        });
        return button;
    }

}
