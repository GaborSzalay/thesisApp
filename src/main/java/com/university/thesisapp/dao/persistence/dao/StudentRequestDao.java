package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.StudentRequest;
import com.university.thesisapp.dao.persistence.model.StudentRequestState;
import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.dao.persistence.model.ThesisStudent;
import com.university.thesisapp.dao.persistence.provider.EntityManagerHolder;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.university.thesisapp.dao.persistence.model.StudentRequestState.DECLINED;
import static com.university.thesisapp.dao.persistence.model.StudentRequestState.SENT;

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
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisStudent thesisStudent = thesisStudentDao.findById(studentId);
        Thesis thesis = thesisDao.findById(thesisId);
        StudentRequest studentRequest = new StudentRequest();
        studentRequest.setCreationDate(new Date());
        studentRequest.setThesis(thesis);
        studentRequest.setThesisStudent(thesisStudent);
        studentRequest.setCurrentState(SENT.getState());
        entityManagerHolder.getEntityManager().persist(studentRequest);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
    }

    public List<StudentRequest> getSentStudentRequestsByTeacherId(long teacherId) {
        List<StudentRequest> allStudentRequests = getAllStudentRequests();
        List<StudentRequest> studentRequestsByTeacher = new ArrayList<StudentRequest>();
        for (StudentRequest studentRequest : allStudentRequests) {
            if (studentRequest.getThesis().getThesisTeacher().getThesisTeacherId().equals(teacherId) && studentRequest.getCurrentState().equals(SENT.getState())) {
                studentRequestsByTeacher.add(studentRequest);
            }
        }
        return studentRequestsByTeacher;
    }

    public StudentRequest findById(long studentRequestId) {
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        StudentRequest studentRequest = entityManagerHolder.getEntityManager().find(StudentRequest.class, studentRequestId);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
        return studentRequest;
    }

    public StudentRequest findByStudentAndThesis(Long thesisStudentId, Long thesisId) {
        List<StudentRequest> studentRequests = getAllStudentRequests();
        StudentRequest foundStudentRequest = null;
        for (StudentRequest studentRequest : studentRequests) {
            if (studentRequest.getThesisStudent().getThesisStudentId().equals(thesisStudentId) && studentRequest.getThesis().getThesisId().equals(thesisId)) {
                foundStudentRequest = studentRequest;
            }
        }
        return foundStudentRequest;
    }

    public List<StudentRequest> getAllStudentRequests() {
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        List<StudentRequest> studentRequests = entityManagerHolder.getEntityManager().createQuery("SELECT s FROM StudentRequest s", StudentRequest.class).getResultList();
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
        return studentRequests;
    }

    public void setState(Long studentRequestId, StudentRequestState studentRequestState) {
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        StudentRequest studentRequest = entityManagerHolder.getEntityManager().find(StudentRequest.class, studentRequestId);
        studentRequest.setCurrentState(studentRequestState.getState());
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
    }

    public List<StudentRequest> getDeclinedStudentRequestsByTeacherId(long teacherId) {
        List<StudentRequest> allStudentRequests = getAllStudentRequests();
        List<StudentRequest> studentRequestsByTeacher = new ArrayList<StudentRequest>();
        for (StudentRequest studentRequest : allStudentRequests) {
            if (studentRequest.getThesis().getThesisTeacher().getThesisTeacherId().equals(teacherId) && studentRequest.getCurrentState().equals(DECLINED.getState())) {
                studentRequestsByTeacher.add(studentRequest);
            }
        }
        return studentRequestsByTeacher;
    }

    public void cancelStudentRequest(Long thesisStudentId, Long thesisId) {
        StudentRequest studentRequest = findByStudentAndThesis(thesisStudentId, thesisId);
        setState(studentRequest.getStudentRequestId(), StudentRequestState.CANCELED);
    }
}
