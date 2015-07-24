package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.Major;
import com.university.thesisapp.dao.persistence.model.StudentLimit;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Gábor on 2015.07.24..
 */
@Service("studentLimitDao")
public class StudentLimitDao {
    @Autowired
    private EntityManagerProvider entityManagerProvider;

    public StudentLimit createStudentLimit(Major major, Long limitOfStudents) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        StudentLimit studentLimit = new StudentLimit();
        Date date = new Date();
        studentLimit.setCreationDate(date);
        studentLimit.setLastModifiedDate(date);
        studentLimit.setLimitOfStudents(limitOfStudents);
        studentLimit.setMajor(major);
        entityManagerParams.getEntityManager().persist(studentLimit);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return studentLimit;
    }
}
