package evaluation.services;

import evaluation.dao.SubjectDaoImpl;
import evaluation.model.Subject;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SubjectServiceImpl implements SubjectService{
    private final SubjectDaoImpl subjectDao;
    public SubjectServiceImpl() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        this.subjectDao = new SubjectDaoImpl(factory);
    }

    @Override
    public void createSubject(Subject subject) {
        this.subjectDao.create(subject);
    }

    @Override
    public Subject readSubject(String subjectName) {
        return this.subjectDao.read(subjectName);
    }

    @Override
    public void updateSubject(Subject subject) {
        this.subjectDao.update(subject);
    }

    @Override
    public void deleteSubject(int id) {
        this.subjectDao.delete(id);
    }

    @Override
    public List<Subject> readListSubjects() {
        return this.subjectDao.listSubjects();
    }
}
