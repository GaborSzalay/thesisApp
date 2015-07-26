package com.university.thesisapp.teacher.controller;

import com.university.thesisapp.teacher.context.TeacherMenuContext;
import com.university.thesisapp.teacher.context.TeacherMenuContextFactory;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.26..
 */
@Controller
public class TeacherHomeController {
    @Autowired
    private TeacherMenuContextFactory teacherMenuContextFactory;
    @Autowired
    private TeacherHomeControllerViewResolver teacherHomeControllerViewResolver;

    @RequestMapping(value = UrlProvider.TEACHER_HOME_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView showTeacherHomePage(Model model, HttpServletRequest request) {
        TeacherMenuContext teacherMenuContext = teacherMenuContextFactory.create();
        return teacherHomeControllerViewResolver.resolveView(model, teacherMenuContext);

    }
}
