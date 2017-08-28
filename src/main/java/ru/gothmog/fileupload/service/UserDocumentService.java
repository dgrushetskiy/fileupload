package ru.gothmog.fileupload.service;

import ru.gothmog.fileupload.model.UserDocument;

import java.util.List;

/**
 * @author d.grushetskiy
 */
public interface UserDocumentService {
    UserDocument findById(long id);

    List<UserDocument> findAll();

    List<UserDocument> findAllByUserId(long id);

    void saveDocument(UserDocument document);

    void deleteById(long id);
}
