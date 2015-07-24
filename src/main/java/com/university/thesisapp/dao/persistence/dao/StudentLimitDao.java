package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.StudentLimit;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Gábor on 2015.07.24..
 */
@Service("studentLimitDao")
public class StudentLimitDao {
    @Autowired
    private EntityManagerProvider entityManagerProvider;

    public void createStudentLimit(StudentLimit studentLimit) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        entityManagerParams.getEntityManager().persist(studentLimit);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
    }
}
