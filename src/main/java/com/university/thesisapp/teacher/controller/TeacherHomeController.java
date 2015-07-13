package com.university.thesisapp.teacher.controller;

import com.university.thesisapp.teacher.factory.TeacherHomeContextFactory;
import com.university.thesisapp.teacher.model.TeacherHomeContext;
import com.university.thesisapp.teacher.view.TeacherHomeControllerViewResolver;
import com.university.thesisapp.web.url.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.11..
 */
@Controller
public class TeacherHomeController {
    @Autowired
    private TeacherHomeContextFactory teacherHomeContextFactory;
    @Autowired
    private TeacherHomeControllerViewResolver teacherHomeControllerViewResolver;

    @RequestMapping(value = UrlProvider.TEACHER_PREFIX + UrlProvider.INDEX_URL, method = RequestMethod.GET)
    public ModelAndView showTeacherHomePage(Model model, HttpServletRequest request) {
        TeacherHomeContext teacherHomeContext = teacherHomeContextFactory.create(request);
        return teacherHomeControllerViewResolver.resolveView(model, teacherHomeContext);
    }
}
