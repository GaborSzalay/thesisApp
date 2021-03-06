package com.university.thesisapp.teacher.controller;

import com.google.common.primitives.Longs;
import com.university.thesisapp.dao.persistence.dao.CourseDao;
import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.teacher.context.ThesisForm;
import com.university.thesisapp.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.08.05..
 */
@Component
public class ThesisTransformer {
    @Autowired
    CourseDao courseDao;
    @Autowired
    private StudentLimitTransformer studentLimitTransformer;

    public Thesis transform(ThesisForm thesisForm) {
        Thesis thesis = new Thesis();
        if (Validation.notEmpty(thesisForm.getThesisIdInput())) {
            thesis.setThesisId(Longs.tryParse(thesisForm.getThesisIdInput()));
        }
        thesis.setTitleHu(thesisForm.getTitleHuInput());
        thesis.setTitleEn(thesisForm.getTitleEnInput());
        thesis.setCourses(courseDao.findByIdInputs(thesisForm.getCourseIds()));
        thesis.setRequiredSemesters(Longs.tryParse(thesisForm.getRequiredSemestersInput()));
        thesis.setDescriptionHu(thesisForm.getDescriptionHuInput());
        thesis.setDescriptionEn(thesisForm.getDescriptionEnInput());
        thesis.setStudentLimits(studentLimitTransformer.transform(thesisForm));
        return thesis;
    }
}
