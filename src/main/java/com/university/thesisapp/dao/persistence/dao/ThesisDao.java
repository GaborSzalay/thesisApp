package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.*;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Gábor on 2015.07.25..
 */
@Service("thesisDao")
public class ThesisDao {
    @Autowired
    private EntityManagerProvider entityManagerProvider;

    public Thesis creaateThesis(String titleHu, String titleEn, String descriptionHu, String descriptionEn, Long requiredSemesters, ThesisType thesisType, List<Course> courses, List<StudentLimit> studentLimits, ThesisTeacher thesisTeacher) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        Thesis thesis = new Thesis();
        Date date = new Date();
        thesis.setCreationDate(date);
        thesis.setLastModifiedDate(date);
        thesis.setTitleHu(titleHu);
        thesis.setTitleEn(titleEn);
        thesis.setDescriptionHu(descriptionHu);
        thesis.setDescriptionEn(descriptionEn);
        thesis.setRequiredSemesters(requiredSemesters);
        thesis.setThesisType(thesisType);
        thesis.setCourses(courses);
        thesis.setStudentLimits(studentLimits);
        thesis.setThesisTeacher(thesisTeacher);
        entityManagerParams.getEntityManager().persist(thesis);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return thesis;
    }

    public List<Thesis> getAllThesises() {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        List<Thesis> thesises = entityManagerParams.getEntityManager().createQuery("SELECT t FROM Thesis t", Thesis.class).getResultList();
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return thesises;
    }

    public List<Thesis> getThesisesByTeacher(ThesisTeacher thesisTeacher) {
        List<Thesis> ownThesises = new ArrayList<Thesis>();
        List<Thesis> allThesises = getAllThesises();
        for (Thesis thesis : allThesises) {
            if (thesis.getThesisTeacher().getThesisTeacherId().equals(thesisTeacher.getThesisTeacherId())) {
                ownThesises.add(thesis);
            }
        }
        return ownThesises;
    }
}
