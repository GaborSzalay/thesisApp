package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.ThesisAuthority;
import com.university.thesisapp.dao.persistence.model.*;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import com.university.thesisapp.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Gábor on 2015.07.27..
 */
@Service("thesisTeacherDao")
public class ThesisTeacherDao {
    @Autowired
    private EntityManagerProvider entityManagerProvider;
    @Autowired
    private ThesisUserDao thesisUserDao;

    public ThesisTeacher createThesisTeacher(String email, String password) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisUser thesisUser = thesisUserDao.createThesisUserWithoutTransactionManagement(entityManagerParams, email, password, ThesisAuthority.TEACHER.getRoleName());
        ThesisTeacher thesisTeacher = new ThesisTeacher();
        thesisTeacher.setThesisUser(thesisUser);
        entityManagerParams.getEntityManager().persist(thesisTeacher);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return thesisTeacher;
    }

    public ThesisTeacher createThesisTeacher(ThesisUser thesisUser) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisTeacher thesisTeacher = new ThesisTeacher();
        thesisTeacher.setThesisUser(thesisUser);
        entityManagerParams.getEntityManager().persist(thesisTeacher);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return thesisTeacher;
    }

    public List<ThesisTeacher> getAllThesisTeachers() {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        List<ThesisTeacher> thesisTeachers = entityManagerParams.getEntityManager().createQuery("SELECT t FROM ThesisTeacher t", ThesisTeacher.class).getResultList();
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return thesisTeachers;
    }

    public ThesisTeacher getThesisTeacherByEmail(String email) {
        ThesisTeacher thesisTeacher = null;
        List<ThesisTeacher> thesisTeachers = getAllThesisTeachers();
        Iterator<ThesisTeacher> thesisTeacherIterator = thesisTeachers.iterator();
        while (thesisTeacherIterator.hasNext() && Validation.empty(thesisTeacher)) {
            ThesisTeacher actualThesisTeacher = thesisTeacherIterator.next();
            if (actualThesisTeacher.getThesisUser().getEmail().equals(email)) {
                thesisTeacher = actualThesisTeacher;
            }
        }
        return thesisTeacher;
    }

    public ThesisTeacher getThesisTeacherByThesisUser(ThesisUser thesisUser) {
        ThesisTeacher thesisTeacher = null;
        List<ThesisTeacher> thesisTeachers = getAllThesisTeachers();
        Iterator<ThesisTeacher> thesisTeacherIterator = thesisTeachers.iterator();
        while (thesisTeacherIterator.hasNext() && Validation.empty(thesisTeacher)) {
            ThesisTeacher actualThesisTeacher = thesisTeacherIterator.next();
            if (actualThesisTeacher.getThesisUser().getThesisUserId().equals(thesisUser.getThesisUserId())) {
                thesisTeacher = actualThesisTeacher;
            }
        }
        return thesisTeacher;
    }

    public ThesisTeacher getThesisTeacherById(Long teacherId) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisTeacher thesisTeacher = entityManagerParams.getEntityManager().find(ThesisTeacher.class, teacherId);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return thesisTeacher;
    }

    public void tryToDeleteThesisTeacher(Long thesisTeacherId) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisTeacher thesisTeacher = entityManagerParams.getEntityManager().find(ThesisTeacher.class, thesisTeacherId);
        if (Validation.notEmpty(thesisTeacher)) {
            Long thesisUserId = thesisTeacher.getThesisUser().getThesisUserId();
            entityManagerParams.getEntityManager().remove(thesisTeacher);
            thesisUserDao.tryToDeleteThesisUser(thesisUserId);
        }
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
    }
}
