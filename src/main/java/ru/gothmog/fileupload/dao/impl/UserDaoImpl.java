package ru.gothmog.fileupload.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.gothmog.fileupload.dao.AbstractDao;
import ru.gothmog.fileupload.dao.UserDao;
import ru.gothmog.fileupload.model.User;

import java.util.List;

/**
 * @author d.grushetskiy
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {
    @Override
    public User findById(long id) {
        User user = getByKey(id);
        return user;
    }

    @Override
    public User findBySSO(String sso) {
        System.out.println("SSO : "+sso);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        User user = (User)crit.uniqueResult();
        return user;
    }

    @Override
    public void save(User user) {
        persist(user);
    }

    @Override
    public void deleteBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        User user = (User)crit.uniqueResult();
        delete(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<User> users = (List<User>) criteria.list();

        return users;
    }
}
