package com.university.thesisapp.teacher.controller;

import com.google.common.primitives.Longs;
import com.university.thesisapp.dao.persistence.dao.MajorDao;
import com.university.thesisapp.dao.persistence.model.Major;
import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.teacher.context.ThesisForm;
import com.university.thesisapp.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Gábor on 2015.08.05..
 */
@Component
public class ThesisProvider {
    @Autowired
    private ThesisTransformer thesisTransformer;
    @Autowired
    private MajorDao majorDao;

    public Thesis getThesis(HttpServletRequest request) {
        ThesisForm thesisForm = new ThesisForm();
        thesisForm.setThesisIdInput(request.getParameter("thesisId"));
        thesisForm.setTitleHuInput(request.getParameter("titleHuInput"));
        thesisForm.setTitleEnInput(request.getParameter("titleEnInput"));
        thesisForm.setThesisTypeInput(request.getParameter("thesisTypeInput"));
        thesisForm.setCourseIds(getCourseIds(request));
        thesisForm.setRequiredSemestersInput(request.getParameter("requiredSemestersInput"));
        thesisForm.setDescriptionHuInput(request.getParameter("descriptionHuInput"));
        thesisForm.setDescriptionEnInput(request.getParameter("descriptionEnInput"));
        thesisForm.setStudentLimits(getStudentLimits(request));

        return thesisTransformer.transform(thesisForm);
    }

    private Map<Long, Long> getStudentLimits(HttpServletRequest request) {
        HashMap<Long, Long> studentLimits = new HashMap<Long, Long>();
        List<Major> majors = majorDao.getAllMajors();
        for (Major major : majors) {
            String studentLimitParameter = request.getParameter("studentLimitNumber-" + major.getMajorId());
            if (Validation.notEmpty(studentLimitParameter)) {
                studentLimits.put(major.getMajorId(), Longs.tryParse(studentLimitParameter));
            }
        }
        return studentLimits;
    }

    private List<String> getCourseIds(HttpServletRequest request) {
        String[] courseIdParameters = request.getParameterValues("courseIds");
        List<String> courseIds = null;
        if (Validation.notEmpty(courseIdParameters)) {
            courseIds = Arrays.asList(courseIdParameters);
        } else {
            courseIds = new ArrayList<String>();
        }
        return courseIds;
    }
}
