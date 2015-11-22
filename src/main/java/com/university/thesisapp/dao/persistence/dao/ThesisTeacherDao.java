package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.ThesisAuthority;
import com.university.thesisapp.dao.persistence.model.*;
import com.university.thesisapp.dao.persistence.provider.EntityManagerHolder;
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

    public ThesisTeacher createThesisTeacher(String email, String password, String name) {
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisUser thesisUser = thesisUserDao.createThesisUser(entityManagerHolder, email, password, ThesisAuthority.TEACHER.getRoleName(), name);
        ThesisTeacher thesisTeacher = new ThesisTeacher();
        thesisTeacher.setThesisUser(thesisUser);
        entityManagerHolder.getEntityManager().persist(thesisTeacher);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
        return thesisTeacher;
    }

    public ThesisTeacher createThesisTeacher(ThesisUser thesisUser) {
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisTeacher thesisTeacher = new ThesisTeacher();
        thesisTeacher.setThesisUser(thesisUser);
        entityManagerHolder.getEntityManager().persist(thesisTeacher);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
        return thesisTeacher;
    }

    public List<ThesisTeacher> getAllThesisTeachers() {
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        List<ThesisTeacher> thesisTeachers = entityManagerHolder.getEntityManager().createQuery("SELECT t FROM ThesisTeacher t", ThesisTeacher.class).getResultList();
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
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
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisTeacher thesisTeacher = entityManagerHolder.getEntityManager().find(ThesisTeacher.class, teacherId);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
        return thesisTeacher;
    }
}
