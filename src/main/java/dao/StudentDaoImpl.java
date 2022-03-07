package dao;

import com.sun.istack.NotNull;
import models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class StudentDaoImpl implements StudentDao{
    private final SessionFactory factory;

    public StudentDaoImpl(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Student student) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public Student read(Integer id) {
        try (final Session session = factory.openSession()) {
            return session.get(Student.class, id);
        }
    }


    @Override
    public void update(Student student) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void delete(int id) {
        try (final Session session = factory.openSession()) {
            Student student =session.get(Student.class, id);
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public List<Student> listStudent() {
        try (final Session session = factory.openSession()) {
            return session.createQuery("from Student", Student.class).getResultList();
        }
    }
    @Override
    public List<Student> listStudent(String searchQuery){
        try (final Session session = factory.openSession()) {
            String query = "from Student where name like :searchQuery or surname like :searchQuery or patronymic like :searchQuery";
            return session.createQuery(query, Student.class).setParameter("searchQuery", "%"+searchQuery+"%").getResultList();
        }
    }
}
