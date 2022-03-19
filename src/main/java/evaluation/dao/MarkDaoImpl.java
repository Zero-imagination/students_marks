package evaluation.dao;

import com.sun.istack.NotNull;
import evaluation.model.Mark;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class MarkDaoImpl implements MarkDao{
    private final SessionFactory factory;

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
    public Mark read(@NotNull final int id) {
        try (final Session session = factory.openSession()) {
            return session.get(Mark.class, id);
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
