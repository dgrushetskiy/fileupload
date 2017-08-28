package ru.gothmog.fileupload.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import ru.gothmog.fileupload.dao.AbstractDao;
import ru.gothmog.fileupload.dao.UserDocumentDao;
import ru.gothmog.fileupload.model.UserDocument;

import java.util.List;

/**
 * @author d.grushetskiy
 */
public class UserDocumentDaoImpl extends AbstractDao<Long, UserDocument> implements UserDocumentDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<UserDocument> findAll() {
        Criteria crit = createEntityCriteria();
        return (List<UserDocument>)crit.list();
    }

    @Override
    public UserDocument findById(long id) {
        return getByKey(id);
    }

    @Override
    public void save(UserDocument document) {
        persist(document);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserDocument> findAllByUserId(long userId) {
        Criteria crit = createEntityCriteria();
        Criteria userCriteria = crit.createCriteria("user");
        userCriteria.add(Restrictions.eq("id", userId));
        return (List<UserDocument>)crit.list();
    }

    @Override
    public void deleteById(long id) {
        UserDocument document =  getByKey(id);
        delete(document);
    }
}
