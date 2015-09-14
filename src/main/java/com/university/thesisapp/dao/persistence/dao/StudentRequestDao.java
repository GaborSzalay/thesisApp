package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.StudentRequest;
import com.university.thesisapp.dao.persistence.model.StudentRequestState;
import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.dao.persistence.model.ThesisStudent;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Gábor on 2015.09.14..
 */
@Service("studentRequestDao")
public class StudentRequestDao {
    @Autowired
    private EntityManagerProvider entityManagerProvider;
    @Autowired
    private ThesisStudentDao thesisStudentDao;
    @Autowired
    private ThesisDao thesisDao;

    public void createStudentRequest(Long studentId, Long thesisId) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisStudent thesisStudent = thesisStudentDao.findById(studentId);
        Thesis thesis = thesisDao.findById(thesisId);
        StudentRequest studentRequest = new StudentRequest();
        studentRequest.setCreationDate(new Date());
        studentRequest.setThesis(thesis);
        studentRequest.setThesisStudent(thesisStudent);
        studentRequest.setCurrentState(StudentRequestState.SENT.getState());
        entityManagerParams.getEntityManager().persist(studentRequest);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
    }
}
