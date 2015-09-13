package com.university.thesisapp.student.controller;

import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.09.14..
 */
@Controller
public class StudentRequestController {
    @Autowired
    private StudentRequestControllerViewResolver studentRequestControllerViewResolver;

    @RequestMapping(value = UrlProvider.STUDENT_STUDENT_REQUEST_HTML, method = RequestMethod.GET)
    public ModelAndView handleStudentRequest(Model model, HttpServletRequest request) {

        return studentRequestControllerViewResolver.resolveView(request, model);
    }
}
