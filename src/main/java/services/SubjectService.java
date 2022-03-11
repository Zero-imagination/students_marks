package services;

import models.Student;
import models.Subject;

import java.util.List;

public interface SubjectService {
    void createSubject(Subject subject);
    Subject readSubject(String subjectName);
    void updateSubject(Subject subject);
    void deleteSubject(int id);
    List<Subject> readListSubjects();
}
