package dao;

import com.sun.istack.NotNull;
import models.Mark;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class MarkDaoImpl implements MarkDao{
    private SessionFactory factory;

    public MarkDaoImpl(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Mark mark) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.save(mark);

            session.getTransaction().commit();
        }
    }

    @Override
    public List<Mark> read(@NotNull final int id) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();
            List<Mark> markList = session.createQuery(
                    "from Mark as mark " +
                            //"left join fetch mark.currentMark" +
                            "where mark.id = :id").setParameter("id", id).getResultList();
            session.getTransaction().commit();
            return markList;
            /*final Mark mark = session.get(Mark.class, id);
            if (mark!=null){
                Hibernate.initialize(mark.getStudent());
            }
            return mark;*/
        }
    }


    @Override
    public void update(Mark mark) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(mark);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(int id) {
        try (final Session session = factory.openSession()) {

            final Mark mark = session.get(Mark.class, id);
            session.beginTransaction();
            if (mark!=null){
                session.delete(mark);
            }
            session.getTransaction().commit();
        }
    }
}
