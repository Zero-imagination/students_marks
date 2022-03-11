package gui;

import gui.boxes.BoxStudent;
import gui.tables.TableAvgMarks;
import gui.tables.TableStudents;
import gui.tables.TableSubjectMarks;
import gui.tables.model.TableModelAvgMarks;
import gui.tables.model.TableModelSubjectMarks;
import models.Mark;
import models.Student;
import services.MarkServiceImpl;
import services.StudentServiceImpl;
import services.SubjectServiceImpl;

import javax.swing.*;
import java.util.Objects;


public class ButtonControlMark {
    private static JButton buttonUpdate;

    private static JButton buttonDelete;

    public static void enableButtonDeleteUpdate(boolean enable){
        buttonUpdate.setEnabled(enable);
        buttonDelete.setEnabled(enable);
    }

    public static JButton create(TypeButton typeButton){

        JButton button = new JButton();
        if (typeButton==TypeButton.DELETE){
            button.setEnabled(false);
            buttonDelete = button;
        }
        if (typeButton==TypeButton.UPDATE){
            button.setEnabled(false);
            buttonUpdate = button;
        }
        button.addActionListener(e -> {
            String messageWhatChange = "";
            try {
                if(BoxStudent.getInfoTextFields().get(1).getText()==null || BoxStudent.getInfoTextFields().get(1).getText().length()==0){
                    throw new IllegalArgumentException();
                }
                SubjectServiceImpl subjectService = new SubjectServiceImpl();
                StudentServiceImpl studentService = new StudentServiceImpl();
                //придумать как избавиться от имплементации лишних сервисов, как можно считать id предмета из комбо бокса без запроса к бд
                MarkServiceImpl markService = new MarkServiceImpl();
                Mark mark = new Mark();
                if (TableSubjectMarks.getSelectedSubjectMark()!=null)
                    mark.setId(TableSubjectMarks.getSelectedSubjectMark().getId());
                mark.setStudentId(TableStudents.getSelectedStudent().getId());
                //считываем из комбобокса название предмета и ищем его в бд
                mark.setSubject(subjectService.readSubject(Objects.requireNonNull(((JComboBox<?>) BoxStudent.getInfoMarkFields().get(0)).getSelectedItem()).toString()));
                mark.setCurrentMark(Double.parseDouble(((JTextField) BoxStudent.getInfoMarkFields().get(1)).getText()));

                switch (typeButton){
                    case UPDATE -> {
                        messageWhatChange = "Оценка "+TableSubjectMarks.getSelectedSubjectMark()+"\nбыла изменена на " + mark;
                        markService.updateMark(mark);
                        //TableSubjectMarks.updateRow(TableModelSubjectMarks.getDataSubjectMarks(mark));
                    }
                    case CREATE -> {
                        messageWhatChange = "Оценка "+mark+" добавлена студенту "+TableStudents.getSelectedStudent().onlyFullName();
                        markService.createMark(mark);
                        //TableSubjectMarks.addRow(TableModelSubjectMarks.getDataSubjectMarks(mark));
                        /*TableSubjectMarks.refresh();
                        TableAvgMarks.refresh();*/
                    }
                    case DELETE -> {
                        messageWhatChange = "Оценка " + mark +" удалена";
                        markService.deleteMark(mark.getId());
                        //TableSubjectMarks.deleteRow();
                        /*TableSubjectMarks.refresh();
                        TableAvgMarks.refresh();*/
                    }
                }
                Student student = studentService.readStudent(TableStudents.getSelectedStudent().getId());
                TableStudents.setSelectedStudent(student);
                TableAvgMarks.getTable().setModel(TableModelAvgMarks.create());
                TableSubjectMarks.getTable().setModel(TableModelSubjectMarks.create());
                JOptionPane.showMessageDialog(Gui.getMainFrame(), "Данные успешно отредактированы! \n"+messageWhatChange);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(Gui.getMainFrame(), "Введены не все данные!");
            }
        });

        return button;
    }
}
