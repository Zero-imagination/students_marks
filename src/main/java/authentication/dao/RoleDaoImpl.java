package authentication.dao;

import com.sun.istack.NotNull;
import authentication.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RoleDaoImpl implements RoleDao{
    private final SessionFactory factory;

    public RoleDaoImpl(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public Role read(int id) {
        try (final Session session = factory.openSession()) {
            return session.get(Role.class, id);
        }
    }
}
