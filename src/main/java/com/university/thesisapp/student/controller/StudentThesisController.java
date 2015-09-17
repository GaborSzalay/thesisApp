package com.university.thesisapp.student.controller;

import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.09.18..
 */
@Controller
public class StudentThesisController {
    @RequestMapping(value = UrlProvider.STUDENT_THESIS_HOMEPAGE_URL, method = RequestMethod.GET)
    public ModelAndView showThesisHomePage(Model model, HttpServletRequest request) {
        return new ModelAndView("student/thesis_home", model.asMap());
    }
}
