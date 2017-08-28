package ru.gothmog.fileupload.service;

import ru.gothmog.fileupload.model.User;

import java.util.List;

/**
 * @author d.grushetskiy
 */
public interface UserService {
    User findById(long id);

    User findBySSO(String sso);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserBySSO(String sso);

    List<User> findAllUsers();

    boolean isUserSSOUnique(Long id, String sso);
}
