package dao;

import com.sun.istack.NotNull;
import models.Mark;
import models.Student;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.postgresql.core.Query;

import java.util.List;
import java.util.Set;

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


}
