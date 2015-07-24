package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.*;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Gábor on 2015.07.25..
 */
@Service("thesisStudentDao")
public class ThesisStudentDao {
    @Autowired
    private EntityManagerProvider entityManagerProvider;

    public ThesisStudent createThesisStudent(ThesisType thesisType, Course course, Major major, ThesisUser thesisUser) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisStudent thesisStudent = new ThesisStudent();
        thesisStudent.setThesisType(thesisType);
        thesisStudent.setCourse(course);
        thesisStudent.setMajor(major);
        thesisStudent.setThesisUser(thesisUser);
        entityManagerParams.getEntityManager().persist(thesisStudent);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return thesisStudent;
    }
}
