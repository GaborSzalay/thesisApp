package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.*;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import com.university.thesisapp.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Gábor on 2015.07.25..
 */
@Service("thesisStudentDao")
public class ThesisStudentDao {
    @Autowired
    private EntityManagerProvider entityManagerProvider;
    @Autowired
    private ThesisUserDao thesisUserDao;
    @Autowired
    private MajorDao majorDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private ThesisDao thesisDao;

    public ThesisStudent createThesisStudent(Course course, Major major, ThesisUser thesisUser) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisStudent thesisStudent = new ThesisStudent();
        thesisStudent.setCourse(course);
        thesisStudent.setMajor(major);
        thesisStudent.setThesisUser(thesisUserDao.getThesisUserByIdWithoutTransactionManagement(entityManagerParams, thesisUser.getThesisUserId()));
        entityManagerParams.getEntityManager().persist(thesisStudent);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return thesisStudent;
    }

    public ThesisStudent createThesisStudent(String email, String password, Long majorId, Long courseId) {
        ThesisUser thesisUser = thesisUserDao.createStudent(email, password);
        return createThesisStudent(courseDao.findById(courseId), majorDao.findById(majorId), thesisUser);
    }

    public List<ThesisStudent> getAllThesisStudents() {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        List<ThesisStudent> thesisStudents = entityManagerParams.getEntityManager().createQuery("SELECT t FROM ThesisStudent t", ThesisStudent.class).getResultList();
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return thesisStudents;
    }

    public ThesisStudent findById(long id) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisStudent thesisStudent = entityManagerParams.getEntityManager().find(ThesisStudent.class, id);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return thesisStudent;
    }

    public ThesisStudent findByThesisUser(ThesisUser thesisUser) {
        ThesisStudent resultThesisStudent = null;
        List<ThesisStudent> thesisStudents = getAllThesisStudents();
        for (ThesisStudent thesisStudent : thesisStudents) {
            if (thesisStudent.getThesisUser().getThesisUserId().equals(thesisUser.getThesisUserId())) {
                resultThesisStudent = thesisStudent;
            }
        }
        return resultThesisStudent;
    }

    public void registerThesis(Long thesisStudentId, Long thesisId) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisStudent thesisStudent = entityManagerParams.getEntityManager().find(ThesisStudent.class, thesisStudentId);
        Thesis thesis = thesisDao.findById(thesisId);
        thesisStudent.setThesis(thesis);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
    }

    public void tryToDeleteThesisStudent(Long studentId) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisStudent thesisStudent = entityManagerParams.getEntityManager().find(ThesisStudent.class, studentId);
        if (Validation.notEmpty(thesisStudent)) {
            entityManagerParams.getEntityManager().remove(thesisStudent);
        }
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
    }
}
