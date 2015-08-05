package com.university.thesisapp.teacher.controller;

import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.teacher.context.ThesisForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by Gábor on 2015.08.05..
 */
@Component
public class ThesisProvider {
    @Autowired
    private ThesisTransformer thesisTransformer;

    public Thesis getThesis(HttpServletRequest request) {
        ThesisForm thesisForm = new ThesisForm();
        thesisForm.setThesisIdInput(request.getParameter("thesisId"));
        thesisForm.setTitleHuInput(request.getParameter("titleHuInput"));
        thesisForm.setTitleEnInput(request.getParameter("titleEnInput"));
        thesisForm.setThesisTypeInput(request.getParameter("thesisTypeInput"));
        thesisForm.setCourseIds(Arrays.asList(request.getParameterValues("courseIds")));
        thesisForm.setRequiredSemestersInput(request.getParameter("requiredSemestersInput"));
        thesisForm.setDescriptionHuInput(request.getParameter("descriptionHuInput"));
        thesisForm.setDescriptionEnInput(request.getParameter("descriptionEnInput"));


        return thesisTransformer.transform(thesisForm);
    }
}
