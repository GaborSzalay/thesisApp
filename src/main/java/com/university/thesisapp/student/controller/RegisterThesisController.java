package com.university.thesisapp.student.controller;

import com.google.common.primitives.Longs;
import com.university.thesisapp.dao.persistence.dao.ThesisStudentDao;
import com.university.thesisapp.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.09.11..
 */
@Controller
public class RegisterThesisController {
    @Autowired
    ThesisStudentDao thesisStudentDao;

    @RequestMapping(value = "/admin/registerThesis", method = RequestMethod.GET)
    public ModelAndView register(Model model, HttpServletRequest request) {
        String thesisId = request.getParameter("thesisId");
        String studentId = request.getParameter("studentId");
        if (Validation.notEmpty(thesisId) && Validation.notEmpty(studentId)) {
            thesisStudentDao.registerThesis(Longs.tryParse(studentId), Longs.tryParse(thesisId));
        }
        return new ModelAndView(new RedirectView("/"));
    }
}
