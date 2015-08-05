package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.ThesisType;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import com.university.thesisapp.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

    public ThesisType findById(long thesisTypeId) {
        List<ThesisType> thesisTypes = getAllThesisTypes();
        Iterator<ThesisType> thesisTypeIterator = thesisTypes.iterator();
        ThesisType thesisType = null;
        while (thesisTypeIterator.hasNext() && Validation.empty(thesisType)) {
            ThesisType actualThesisType = thesisTypeIterator.next();
            if (actualThesisType.getThesisTypeId().equals(thesisTypeId)) {
                thesisType = actualThesisType;
            }
        }

        return thesisType;
    }

    public List<ThesisType> getAllThesisTypes() {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        List<ThesisType> thesisTypes = entityManagerParams.getEntityManager().createQuery("SELECT t FROM ThesisType t", ThesisType.class).getResultList();
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return thesisTypes;
    }
}
