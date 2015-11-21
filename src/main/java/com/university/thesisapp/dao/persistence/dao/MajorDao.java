package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.Major;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    public List<Major> getAllMajors() {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        List<Major> majors = getAllMajors(entityManagerParams);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return majors;
    }

    public List<Major> getAllMajors(EntityManagerParams entityManagerParams) {
        return entityManagerParams.getEntityManager().createQuery("SELECT m FROM Major m", Major.class).getResultList();
    }

    public Major findById(Long id) {
        List<Major> majors = getAllMajors();
        return findById(id, majors);
    }

    public Major findById(Long id, List<Major> majors) {
        Major resultMajor = null;
        for (Major major : majors) {
            if (major.getMajorId().equals(id)) {
                resultMajor = major;
            }
        }
        return resultMajor;
    }

    public void editMajor(Long majorId, String majorName) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        List<Major> majors = getAllMajors(entityManagerParams);
        Major major = findById(majorId, majors);
        major.setMajorName(majorName);
        major.setLastModifiedDate(new Date());
        entityManagerParams.getEntityManager().persist(major);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
    }
}
