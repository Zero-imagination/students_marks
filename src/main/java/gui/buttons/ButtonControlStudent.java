package gui.buttons;

import gui.Gui;
import gui.boxes.BoxStudentInfo;
import gui.tables.TableAvgMarks;
import gui.tables.TableSubjectMarks;
import gui.tables.model.TableModelStudents;
import gui.tables.TableStudents;
import evaluation.model.Mark;
import evaluation.model.Student;
import evaluation.services.MarkServiceImpl;
import evaluation.services.StudentServiceImpl;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ButtonControlStudent {
    public static JButton createButton(TypeButton typeButton){
        JButton button = new JButton();
        button.addActionListener(e -> {
            {
                try {
                    for (int i = 1; i< BoxStudentInfo.getInfoTextFields().size(); i++){
                        if(BoxStudentInfo.getInfoTextFields().get(i).getText() == null || BoxStudentInfo.getInfoTextFields().get(i).getText().length() == 0){
                            throw new IllegalArgumentException();
                        }
                    }
                    Student student = new Student();
                    StudentServiceImpl studentService = new StudentServiceImpl();
                    if (TableStudents.getSelectedStudent()!=null)
                        student = TableStudents.getSelectedStudent();
                    student.setSurname(BoxStudentInfo.getInfoTextFields().get(1).getText());
                    student.setName(BoxStudentInfo.getInfoTextFields().get(2).getText());
                    student.setPatronymic(BoxStudentInfo.getInfoTextFields().get(3).getText());
                    student.setDateStartLearning(LocalDate.parse(BoxStudentInfo.getInfoTextFields().get(4).getText()));
                    student.setDateEndLearning(LocalDate.parse(BoxStudentInfo.getInfoTextFields().get(5).getText()));
                    switch (typeButton){
                        case UPDATE -> {
                            studentService.updateStudent(student);
                            TableStudents.updateRow(TableModelStudents.getDataStudent(student));
                        }
                        case CREATE -> {
                            student.setAllMarks(null);
                            studentService.createStudent(student);
                            BoxStudentInfo.getInfoTextFields().get(0).setText(String.valueOf(student.getId()));
                            student=studentService.readStudent(Integer.parseInt(BoxStudentInfo.getInfoTextFields().get(0).getText()));
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
