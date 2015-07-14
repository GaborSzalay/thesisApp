package com.university.thesisapp.teacher.controller;

import com.university.thesisapp.ThesisAuthority;
import com.university.thesisapp.teacher.factory.TeacherHomeContextFactory;
import com.university.thesisapp.teacher.model.TeacherHomeContext;
import com.university.thesisapp.teacher.view.TeacherHomeControllerViewResolver;
import com.university.thesisapp.web.cookie.UserCookieManager;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Gábor on 2015.07.11..
 */
@Controller
public class TeacherHomeController {
    @Autowired
    private TeacherHomeContextFactory teacherHomeContextFactory;
    @Autowired
    private TeacherHomeControllerViewResolver teacherHomeControllerViewResolver;
    @Autowired
    private UserCookieManager userCookieManager;

    @RequestMapping(value = UrlProvider.TEACHER_PREFIX + UrlProvider.INDEX_URL, method = RequestMethod.GET)
    public ModelAndView showTeacherHomePage(Model model, HttpServletRequest request, HttpServletResponse response) {
        TeacherHomeContext teacherHomeContext = teacherHomeContextFactory.create(request);
        userCookieManager.createUserCookie(request, response, ThesisAuthority.TEACHER);
        return teacherHomeControllerViewResolver.resolveView(model, teacherHomeContext);
    }
}
