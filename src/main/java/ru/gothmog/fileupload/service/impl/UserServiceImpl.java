package ru.gothmog.fileupload.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gothmog.fileupload.dao.UserDao;
import ru.gothmog.fileupload.model.User;
import ru.gothmog.fileupload.service.UserService;

import java.util.List;

/**
 * @author d.grushetskiy
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }

    @Override
    public User findBySSO(String sso) {
        User user = userDao.findBySSO(sso);
        return user;
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public void updateUser(User user) {
        User entity = userDao.findById(user.getId());
        if (entity != null){
            entity.setSsoId(user.getSsoId());
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setEmail(user.getEmail());
            entity.setUserDocuments(user.getUserDocuments());
        }
    }

    @Override
    public void deleteUserBySSO(String sso) {
        userDao.deleteBySSO(sso);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public boolean isUserSSOUnique(Long id, String sso) {
        User user = findBySSO(sso);
        return (user == null || ((id != null) && (user.getId() == id)));
    }
}
