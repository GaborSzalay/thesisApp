package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.StudentRequest;
import com.university.thesisapp.dao.persistence.model.StudentRequestState;
import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.dao.persistence.model.ThesisStudent;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public List<StudentRequest> getStudentRequestsByTeacherId(long teacherId) {
        List<StudentRequest> allStudentRequests = getAllStudentRequests();
        List<StudentRequest> studentRequestsByTeacher = new ArrayList<StudentRequest>();
        for (StudentRequest studentRequest : allStudentRequests) {
            if (studentRequest.getThesis().getThesisTeacher().getThesisTeacherId().equals(teacherId)) {
                studentRequestsByTeacher.add(studentRequest);
            }
        }
        return studentRequestsByTeacher;
    }

    public List<StudentRequest> getAllStudentRequests() {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        List<StudentRequest> studentRequests = entityManagerParams.getEntityManager().createQuery("SELECT s FROM StudentRequest s", StudentRequest.class).getResultList();
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return studentRequests;
    }
}
