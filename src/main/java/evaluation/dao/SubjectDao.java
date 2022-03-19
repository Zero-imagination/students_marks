package evaluation.dao;

import evaluation.model.Subject;

import java.util.List;

public interface SubjectDao {
    void create(Subject subject);
    Subject read(String subjectName);
    void update(Subject subject);
    void delete(int id);
    List<Subject> listSubjects();
}
