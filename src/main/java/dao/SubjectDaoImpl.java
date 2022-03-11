package dao;

import com.sun.istack.NotNull;
import models.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SubjectDaoImpl implements SubjectDao{
    private final SessionFactory factory;
    public SubjectDaoImpl(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Subject subject) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(subject);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public Subject read(String subjectName) {
        try (final Session session = factory.openSession()) {
            String query = "from Subject where subjectName=:subjectName";
            return session.createQuery(query, Subject.class).setParameter("subjectName", subjectName).getSingleResult();
        }
    }



    @Override
    public void update(Subject subject) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(subject);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void delete(int id) {
        try (final Session session = factory.openSession()) {
            Subject subject =session.get(Subject.class, id);
            session.beginTransaction();
            session.delete(subject);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public List<Subject> listSubjects() {
        try (final Session session = factory.openSession()) {
            return session.createQuery("from Subject", Subject.class).getResultList();
        }
    }
}
