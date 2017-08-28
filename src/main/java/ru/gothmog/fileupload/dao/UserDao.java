package ru.gothmog.fileupload.dao;

import ru.gothmog.fileupload.model.User;

import java.util.List;

/**
 * @author d.grushetskiy
 */
public interface UserDao {
    User findById(long id);

    User findBySSO(String sso);

    void save(User user);

    void deleteBySSO(String sso);

    List<User> findAllUsers();
}
