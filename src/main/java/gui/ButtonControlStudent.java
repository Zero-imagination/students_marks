package gui;

import gui.boxes.BoxStudent;
import gui.tables.TableAvgMarks;
import gui.tables.TableSubjectMarks;
import gui.tables.model.TableModelStudents;
import gui.tables.TableStudents;
import models.Mark;
import models.Student;
import services.MarkServiceImpl;
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
                    for (int i=1; i<BoxStudent.getInfoTextFields().size(); i++){
                        if(BoxStudent.getInfoTextFields().get(i).getText() == null || BoxStudent.getInfoTextFields().get(i).getText().length() == 0){
                            throw new IllegalArgumentException();
                        }
                    }
                    Student student = new Student();
                    StudentServiceImpl studentService = new StudentServiceImpl();
                    if (TableStudents.getSelectedStudent()!=null)
                        student = TableStudents.getSelectedStudent();
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
                            BoxStudent.getInfoTextFields().get(0).setText(String.valueOf(student.getId()));
                            student=studentService.readStudent(Integer.parseInt(BoxStudent.getInfoTextFields().get(0).getText()));
                            TableStudents.addRow(TableModelStudents.getDataStudent(student));
                            TableSubjectMarks.refresh();
                            TableAvgMarks.refresh();
                        }
                        case DELETE -> {
                            MarkServiceImpl markService = new MarkServiceImpl();
                            for (Mark mark : student.getAllMarks()){
                                markService.deleteMark(mark.getId());
                            }
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
