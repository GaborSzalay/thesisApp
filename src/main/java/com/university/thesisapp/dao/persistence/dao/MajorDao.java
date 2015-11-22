package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.Major;
import com.university.thesisapp.dao.persistence.provider.EntityManagerHolder;
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
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        Date date = new Date();
        Major major = new Major();
        major.setMajorName(majorName);
        major.setCreationDate(date);
        major.setLastModifiedDate(date);
        entityManagerHolder.getEntityManager().persist(major);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
        return major;
    }

    public List<Major> getAllMajors() {
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        List<Major> majors = getAllMajors(entityManagerHolder);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
        return majors;
    }

    public List<Major> getAllMajors(EntityManagerHolder entityManagerParams) {
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
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        List<Major> majors = getAllMajors(entityManagerHolder);
        Major major = findById(majorId, majors);
        major.setMajorName(majorName);
        major.setLastModifiedDate(new Date());
        entityManagerHolder.getEntityManager().persist(major);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
    }
}
