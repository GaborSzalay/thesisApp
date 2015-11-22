package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.Major;
import com.university.thesisapp.dao.persistence.model.StudentLimit;
import com.university.thesisapp.dao.persistence.provider.EntityManagerHolder;
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
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        StudentLimit studentLimit = new StudentLimit();
        Date date = new Date();
        studentLimit.setCreationDate(date);
        studentLimit.setLastModifiedDate(date);
        studentLimit.setLimitOfStudents(limitOfStudents);
        studentLimit.setMajor(major);
        entityManagerHolder.getEntityManager().persist(studentLimit);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
        return studentLimit;
    }

    public StudentLimit provideStudentLimit(Long majorId, Long limitOfStudents) {
        StudentLimit resultStudentLimit = null;
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
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        List<StudentLimit> studentLimits = entityManagerHolder.getEntityManager().createQuery("SELECT s FROM StudentLimit s", StudentLimit.class).getResultList();
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
        return studentLimits;
    }

}
