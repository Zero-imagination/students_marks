package authentication.dao;

import com.sun.istack.NotNull;
import authentication.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.NoResultException;

public class UserDaoImpl implements UserDao{

    private final SessionFactory factory;

    public UserDaoImpl(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void save(User user) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public User findByUsername(String username) {
        try (final Session session = factory.openSession()) {
            String query = "from User where username=:username";
            return session.createQuery(query, User.class).setParameter("username", username).getSingleResult();
        } catch (NoResultException ignored){}
        return null;
    }
}
