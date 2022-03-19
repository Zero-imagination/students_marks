package authentication.dao;

import authentication.model.User;

public interface UserDao {
    void save(User user);
    User findByUsername(String username);
}
