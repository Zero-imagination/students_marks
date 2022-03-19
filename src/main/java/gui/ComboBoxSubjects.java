package gui;


import evaluation.model.Subject;
import evaluation.services.SubjectServiceImpl;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComboBoxSubjects {
    public static JComboBox<Object> create(){
        SubjectServiceImpl subjectService = new SubjectServiceImpl();
        List<Subject> subjects = subjectService.readListSubjects();

        ArrayList<String> items = new ArrayList<>();
        for (Subject subject : subjects){
            items.add(subject.getSubjectName());
        }
        Collections.sort(items);
        return new JComboBox<>(items.toArray());
    }
}
