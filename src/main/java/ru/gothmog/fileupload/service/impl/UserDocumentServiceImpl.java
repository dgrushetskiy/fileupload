package ru.gothmog.fileupload.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gothmog.fileupload.dao.UserDocumentDao;
import ru.gothmog.fileupload.model.UserDocument;
import ru.gothmog.fileupload.service.UserDocumentService;

import java.util.List;

/**
 * @author d.grushetskiy
 */
@Service("userDocumentService")
@Transactional
public class UserDocumentServiceImpl implements UserDocumentService {
    @Autowired
    private UserDocumentDao userDocumentDao;

    @Override
    public UserDocument findById(long id) {
        return userDocumentDao.findById(id);
    }

    @Override
    public List<UserDocument> findAll() {
        return userDocumentDao.findAll();
    }

    @Override
    public List<UserDocument> findAllByUserId(long id) {
        return userDocumentDao.findAllByUserId(id);
    }

    @Override
    public void saveDocument(UserDocument document) {
        userDocumentDao.save(document);
    }

    @Override
    public void deleteById(long id) {
        userDocumentDao.deleteById(id);
    }
}
