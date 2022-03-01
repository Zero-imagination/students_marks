package dao;

import com.sun.istack.NotNull;
import models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDaoImpl implements StudentDao{
    private SessionFactory factory;

    public StudentDaoImpl(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Student student) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();
        }
    }

    @Override
    public Student read(Integer id) {
        try (final Session session = factory.openSession()) {

            final Student student = session.get(Student.class, id);

            return student;
        }
    }


    @Override
    public void update(Student student) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(student);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(int id) {
        try (final Session session = factory.openSession()) {

            final Student student = session.get(Student.class, id);
            if (student!=null){
                session.delete(student);
            }
        }
    }

    @Override
    public List<Student> listStudent() {
        try (final Session session = factory.openSession()) {
            return session.createQuery("from Student").list();
        }
    }
}
