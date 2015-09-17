package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.Major;
import com.university.thesisapp.dao.persistence.model.StudentLimit;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import com.university.thesisapp.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Gábor on 2015.07.24..
 */
@Service("studentLimitDao")
public class StudentLimitDao {
    @Autowired
    private EntityManagerProvider entityManagerProvider;
    @Autowired
    private MajorDao majorDao;

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

    public StudentLimit provideStudentLimit(Long majorId, Long limitOfStudents) {
        StudentLimit resultStudentLimit = null;
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        List<StudentLimit> studentLimits = getAllStudentLimits();
        for (StudentLimit studentLimit : studentLimits) {
            if (studentLimit.getMajor().getMajorId().equals(majorId) && studentLimit.getLimitOfStudents().equals(limitOfStudents)) {
                resultStudentLimit = studentLimit;
            }
        }
        if (Validation.empty(resultStudentLimit)) {
            resultStudentLimit = createStudentLimit(majorDao.findById(majorId), limitOfStudents);
        }
        return resultStudentLimit;
    }

    public List<StudentLimit> getAllStudentLimits() {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        List<StudentLimit> studentLimits = entityManagerParams.getEntityManager().createQuery("SELECT s FROM StudentLimit s", StudentLimit.class).getResultList();
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return studentLimits;
    }

    public void tryToDeleteStudentLimit(Long studentLimitId) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        StudentLimit studentLimit = entityManagerParams.getEntityManager().find(StudentLimit.class, studentLimitId);
        if (Validation.notEmpty(studentLimit)) {
            entityManagerParams.getEntityManager().remove(studentLimit);
        }
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
    }

    public void tryToDeleteAllStudentLimits() {
        List<StudentLimit> allStudentLimits = getAllStudentLimits();
        for (StudentLimit studentLimit : allStudentLimits) {
            tryToDeleteStudentLimit(studentLimit.getStudentLimitId());
        }
    }
}
