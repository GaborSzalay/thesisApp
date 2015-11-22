package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.ThesisStatus;
import com.university.thesisapp.dao.persistence.model.*;
import com.university.thesisapp.dao.persistence.provider.EntityManagerHolder;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import com.university.thesisapp.dao.persistence.provider.ThesisUserProvider;
import com.university.thesisapp.util.Validation;
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
    @Autowired
    private ThesisUserProvider thesisUserProvider;
    @Autowired
    private ThesisTeacherDao thesisTeacherDao;

    public Thesis creaateThesis(Thesis thesis) {
        Date date = new Date();
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        if (Validation.notEmpty(thesis.getThesisId())) {
            Thesis existingThesis = entityManagerHolder.getEntityManager().find(Thesis.class, thesis.getThesisId());
            existingThesis.setLastModifiedDate(date);
            existingThesis.setTitleHu(thesis.getTitleHu());
            existingThesis.setTitleEn(thesis.getTitleEn());
            existingThesis.setCourses(thesis.getCourses());
            existingThesis.setRequiredSemesters(thesis.getRequiredSemesters());
            existingThesis.setDescriptionHu(thesis.getDescriptionHu());
            existingThesis.setDescriptionEn(thesis.getDescriptionEn());
            existingThesis.setStudentLimits(thesis.getStudentLimits());
        } else {
            thesis.setCreationDate(date);
            thesis.setStatus(ThesisStatus.NEW.getType());
            thesis.setThesisTeacher(thesisTeacherDao.getThesisTeacherByThesisUser(thesisUserProvider.getSignedInUser()));
            entityManagerHolder.getEntityManager().persist(thesis);
        }
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
        return thesis;
    }

    public Thesis creaateThesis(String titleHu, String titleEn, String descriptionHu, String descriptionEn, Long requiredSemesters, List<Course> courses, List<StudentLimit> studentLimits, ThesisTeacher thesisTeacher) {
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        Thesis thesis = new Thesis();
        Date date = new Date();
        thesis.setCreationDate(date);
        thesis.setLastModifiedDate(date);
        thesis.setTitleHu(titleHu);
        thesis.setTitleEn(titleEn);
        thesis.setDescriptionHu(descriptionHu);
        thesis.setDescriptionEn(descriptionEn);
        thesis.setRequiredSemesters(requiredSemesters);
        thesis.setCourses(courses);
        thesis.setStudentLimits(studentLimits);
        thesis.setStatus(ThesisStatus.NEW.getType());
        thesis.setThesisTeacher(thesisTeacher);
        entityManagerHolder.getEntityManager().persist(thesis);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
        return thesis;
    }

    public List<Thesis> getAllThesises() {
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        List<Thesis> thesises = entityManagerHolder.getEntityManager().createQuery("SELECT t FROM Thesis t", Thesis.class).getResultList();
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
        return thesises;
    }

    public Thesis findById(long thesisId, EntityManagerHolder entityManagerParams) {
        return entityManagerParams.getEntityManager().find(Thesis.class, thesisId);
    }

    public Thesis findById(long thesisId) {
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        Thesis thesis = findById(thesisId, entityManagerHolder);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
        return thesis;
    }

    public List<Thesis> getThesisesByTeacherAndStatus(ThesisTeacher thesisTeacher, ThesisStatus thesisStatus) {
        List<Thesis> thesisesByTeacherAndStatus = new ArrayList<Thesis>();
        List<Thesis> thesisesByTeacher = getThesisesByTeacher(thesisTeacher);
        for (Thesis thesis : thesisesByTeacher) {
            if (thesis.getStatus().equals(thesisStatus.getType())) {
                thesisesByTeacherAndStatus.add(thesis);
            }
        }
        return thesisesByTeacherAndStatus;
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

    public StudentLimit getStudentLimitByMajor(Thesis thesis, Major major) {
        StudentLimit result = null;
        for (StudentLimit studentLimit : thesis.getStudentLimits()) {
            if (studentLimit.getMajor().getMajorName().equals(major.getMajorName())) {
                result = studentLimit;
            }
        }
        return result;
    }

    public void setStatus(Long thesisId, ThesisStatus thesisStatus) {
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        Thesis thesis = findById(thesisId, entityManagerHolder);
        thesis.setStatus(thesisStatus.getType());
        entityManagerHolder.getEntityManager().persist(thesis);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
    }
}
