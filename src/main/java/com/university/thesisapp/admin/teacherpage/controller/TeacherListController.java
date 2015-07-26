package com.university.thesisapp.admin.teacherpage.controller;

import com.university.thesisapp.admin.homepage.context.AdminMenuContext;
import com.university.thesisapp.admin.homepage.context.AdminMenuContextFactory;
import com.university.thesisapp.admin.teacherpage.context.TeacherListContext;
import com.university.thesisapp.admin.teacherpage.context.TeacherListContextFactory;
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
public class TeacherListController {
    @Autowired
    private AdminMenuContextFactory adminMenuContextFactory;
    @Autowired
    private TeacherListContextFactory teacherListContextFactory;
    @Autowired
    private TeacherListControllerViewResolver teacherListControllerViewResolver;

    @RequestMapping(value = UrlProvider.LIST_TEACHERS_URL, method = RequestMethod.GET)
    public ModelAndView listTeachers(Model model, HttpServletRequest request) {
        TeacherListContext teacherListContext = teacherListContextFactory.create();
        AdminMenuContext adminMenuContext = adminMenuContextFactory.create();

        return teacherListControllerViewResolver.resolveView(model, teacherListContext, adminMenuContext);
    }
}
