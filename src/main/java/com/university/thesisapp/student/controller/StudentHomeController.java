package com.university.thesisapp.student.controller;

import com.university.thesisapp.ThesisAuthority;
import com.university.thesisapp.student.factory.StudentHomeContextFactory;
import com.university.thesisapp.student.model.StudentHomeContext;
import com.university.thesisapp.student.view.StudentHomeControllerViewResolver;
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
 * Created by Gábor on 2015.07.15..
 */
@Controller
public class StudentHomeController {
    @Autowired
    private StudentHomeContextFactory studentHomeContextFactory;
    @Autowired
    private StudentHomeControllerViewResolver studentHomeControllerViewResolver;
    @Autowired
    private UserCookieManager userCookieManager;

    @RequestMapping(value = UrlProvider.STUDENT_PREFIX + UrlProvider.INDEX_URL, method = RequestMethod.GET)
    public ModelAndView showStudentHomePage(Model model, HttpServletRequest request, HttpServletResponse response) {
        StudentHomeContext studentHomeContext = studentHomeContextFactory.create(request);
        userCookieManager.createUserCookie(request, response, ThesisAuthority.STUDENT);
        return studentHomeControllerViewResolver.resolveView(model, studentHomeContext);
    }
}
