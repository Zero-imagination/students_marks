package authentication.services;

import authentication.dao.RoleDaoImpl;
import authentication.dao.UserDaoImpl;
import authentication.model.Role;
import authentication.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class UserServiceImpl implements UserService {
    private final UserDaoImpl userDao;
    private final RoleDaoImpl roleDao;

    public UserServiceImpl() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        this.userDao = new UserDaoImpl(factory);
        this.roleDao = new RoleDaoImpl(factory);
    }

    @Override
    public void save(User user) {
        user.setPassword("pass");
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.read(1));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
