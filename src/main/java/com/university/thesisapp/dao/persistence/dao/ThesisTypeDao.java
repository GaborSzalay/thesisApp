package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.ThesisType;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Gábor on 2015.07.25..
 */
@Service("thesisTypetDao")
public class ThesisTypeDao {
    @Autowired
    private EntityManagerProvider entityManagerProvider;

    public ThesisType createThesisType(String typeName) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisType thesisType = new ThesisType();
        Date date = new Date();
        thesisType.setCreationDate(date);
        thesisType.setLastModifiedDate(date);
        thesisType.setTypeName(typeName);
        entityManagerParams.getEntityManager().persist(thesisType);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return thesisType;
    }
}