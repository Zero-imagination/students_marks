package gui.buttons;

import gui.Gui;
import gui.boxes.BoxMarkInfo;
import gui.boxes.BoxStudentInfo;
import gui.tables.TableAvgMarks;
import gui.tables.TableStudents;
import gui.tables.TableSubjectMarks;
import gui.tables.model.TableModelAvgMarks;
import gui.tables.model.TableModelSubjectMarks;
import evaluation.model.Mark;
import evaluation.model.Student;
import evaluation.services.MarkServiceImpl;
import evaluation.services.StudentServiceImpl;
import evaluation.services.SubjectServiceImpl;
import javax.swing.*;
import java.util.Objects;


public class ButtonControlMark {
    private static JButton buttonUpdate;
    private static JButton buttonDelete;
    private static JButton buttonCreate;

    public static void setButtonControlMark(JButton buttonCreate, JButton buttonUpdate, JButton buttonDelete){
        ButtonControlMark.buttonCreate = buttonCreate;
        ButtonControlMark.buttonUpdate = buttonUpdate;
        ButtonControlMark.buttonDelete = buttonDelete;
    }

    public static void enableButtonCreateMark(boolean enable){
        buttonCreate.setEnabled(enable);
    }
    public static void enableButtonUpdateDeleteMark(boolean enable){
        buttonUpdate.setEnabled(enable);
        buttonDelete.setEnabled(enable);
    }

    public static JButton create(TypeButton typeButton){
        JButton button = new JButton();
        button.setEnabled(false);
        button.addActionListener(e -> {
            String messageWhatChange = "";
            try {
                if (BoxStudentInfo.getInfoTextFields().get(1).getText() == null || BoxStudentInfo.getInfoTextFields().get(1).getText().length() == 0) {
                    throw new IllegalArgumentException();
                }
                String selectedSubject = BoxStudentInfo.getSelectedSubjectName().getText();
                Mark mark = new Mark();
                int selectedStudentId = TableStudents.getSelectedStudent().getId();
                //данный if нужен для того чтобы создавать поля у новой оценки без выделения уже существующих

                if ((BoxMarkInfo.getInfoMarkFields().get(0)).isEnabled()){
                    SubjectServiceImpl subjectService = new SubjectServiceImpl();
                    mark.setSubject(subjectService.readSubject(Objects.requireNonNull(((JComboBox<?>) BoxMarkInfo.getInfoMarkFields().get(0)).getSelectedItem()).toString()));
                }else {
                    if (TableSubjectMarks.getSelectedMark()!=null){
                        mark.setSubject(TableSubjectMarks.getSelectedMark().getSubject());
                        mark.setId(TableSubjectMarks.getSelectedMark().getId());
                    }else {
                        mark.setSubject(TableStudents.getSelectedStudent().getAverageMarkSubject(selectedSubject).getSubject());
                    }
                }

                mark.setStudentId(TableStudents.getSelectedStudent().getId());
                mark.setCurrentMark(Double.parseDouble(((JTextField) BoxMarkInfo.getInfoMarkFields().get(1)).getText()));
                switch (typeButton){
                    case CREATE -> {
                        messageWhatChange = "Оценка "+mark+" добавлена студенту "+TableStudents.getSelectedStudent().onlyFullName();
                        MarkServiceImpl markService = new MarkServiceImpl();
                        markService.createMark(mark);

                    }
                    case DELETE -> {
                        MarkServiceImpl markService = new MarkServiceImpl();
                        messageWhatChange = "Оценка " + mark +" удалена";
                        markService.deleteMark(mark.getId());
                        ButtonControlMark.enableButtonUpdateDeleteMark(false);
                    }
                    case UPDATE -> {
                        MarkServiceImpl markService = new MarkServiceImpl();
                        messageWhatChange = "Оценка "+TableSubjectMarks.getSelectedMark()+"\n была изменена на " + mark;
                        markService.updateMark(mark);
                        ButtonControlMark.enableButtonUpdateDeleteMark(false);
                    }
                }
                StudentServiceImpl studentService = new StudentServiceImpl();
                Student student = studentService.readStudent(selectedStudentId);
                TableStudents.setSelectedStudent(student);
                TableAvgMarks.getTable().setModel(TableModelAvgMarks.create());
                TableSubjectMarks.getTable().setModel(TableModelSubjectMarks.create());

                JOptionPane.showMessageDialog(Gui.getMainFrame(), "Данные успешно отредактированы! \n"+messageWhatChange);
            }catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(Gui.getMainFrame(), "Введены не корректные данные!");
            }
        });
        return button;
    }
}
