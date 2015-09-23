package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.Comment;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import com.university.thesisapp.dao.persistence.provider.ThesisUserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Gábor on 2015.09.24..
 */
@Service("commentDao")
public class CommentDao {
    @Autowired
    ThesisDao thesisDao;
    @Autowired
    ThesisUserProvider thesisUserProvider;
    @Autowired
    EntityManagerProvider entityManagerProvider;

    public void createComment(String commentMessage, Long thesisId) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        Comment comment = new Comment();
        comment.setCreationDate(new Date());
        comment.setThesisUser(thesisUserProvider.getSignedInUser());
        comment.setThesis(thesisDao.findById(thesisId));
        comment.setCommentMessage(commentMessage);
        entityManagerParams.getEntityManager().persist(comment);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
    }
}
