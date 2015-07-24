package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.Major;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Gábor on 2015.07.24..
 */
@Service("majorDao")
public class MajorDao {
    @Autowired
    private EntityManagerProvider entityManagerProvider;

    public void createMajor(Major major) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        entityManagerParams.getEntityManager().persist(major);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
    }
}
