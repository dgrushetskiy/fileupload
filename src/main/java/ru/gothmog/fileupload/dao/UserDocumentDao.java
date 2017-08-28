package ru.gothmog.fileupload.dao;

import ru.gothmog.fileupload.model.UserDocument;

import java.util.List;

/**
 * @author d.grushetskiy
 */
public interface UserDocumentDao {
    List<UserDocument> findAll();

    UserDocument findById(long id);

    void save(UserDocument document);

    List<UserDocument> findAllByUserId(long userId);

    void deleteById(long id);
}
