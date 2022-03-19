package evaluation.services;
import evaluation.dao.StudentDaoImpl;
import evaluation.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentDaoImpl studentDao;

    public StudentServiceImpl() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        this.studentDao = new StudentDaoImpl(factory);
    }
    @Override
    public void createStudent(Student student) {
        this.studentDao.create(student);
    }

    @Override
    public Student readStudent(int id) {
        return this.studentDao.read(id);
    }

    @Override
    public void updateStudent(Student student) {
        this.studentDao.update(student);
    }

    @Override
    public void deleteStudent(int id) {
        this.studentDao.delete(id);
    }

    @Override
    public List<Student> readListStudents() {
        return this.studentDao.listStudent();
    }
    @Override
    public List<Student> readListStudents(String searchQuery) {
        return this.studentDao.listStudent(searchQuery);
    }
}
