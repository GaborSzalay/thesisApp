package com.university.thesisapp.teacher.controller;

import com.university.thesisapp.teacher.context.*;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.27..
 */
@Controller
public class TeacherOwnThesisesController {
    @Autowired
    private TeacherMenuContextFactory teacherMenuContextFactory;
    @Autowired
    private TeacherOwnThesisesControllerViewResolver teacherOwnThesisesControllerViewResolver;
    @Autowired
    private TeacherOwnThesisesContextFactory teacherOwnThesisesContextFactory;

    @RequestMapping(value = UrlProvider.TEACHER_OWN_THESIS_LIST_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView listOwnThesises(Model model, HttpServletRequest request) {
        TeacherMenuContext teacherMenuContext = teacherMenuContextFactory.create();
        TeacherOwnThesisesContext teacherOwnThesisesContext = teacherOwnThesisesContextFactory.create();
        return teacherOwnThesisesControllerViewResolver.resolveView(model, teacherMenuContext, teacherOwnThesisesContext);
    }
}
