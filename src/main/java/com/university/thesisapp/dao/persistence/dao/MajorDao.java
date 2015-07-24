package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.Major;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Gábor on 2015.07.24..
 */
@Service("majorDao")
public class MajorDao {
    @Autowired
    private EntityManagerProvider entityManagerProvider;

    public Major createMajor(String majorName) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        Date date = new Date();
        Major major = new Major();
        major.setMajorName(majorName);
        major.setCreationDate(date);
        major.setLastModifiedDate(date);
        entityManagerParams.getEntityManager().persist(major);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return major;
    }
}
