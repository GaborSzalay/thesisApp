package com.university.thesisapp.admin.studentpage.controller;

import com.university.thesisapp.admin.homepage.context.AdminMenuContext;
import com.university.thesisapp.admin.homepage.context.AdminMenuContextFactory;
import com.university.thesisapp.admin.studentpage.context.StudentListContext;
import com.university.thesisapp.admin.studentpage.context.StudentListContextFactory;
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
public class StudentListController {
    @Autowired
    private StudentListContextFactory studentListContextFactory;
    @Autowired
    private AdminMenuContextFactory adminMenuContextFactory;
    @Autowired
    private StudentListControllerViewResolver studentListControllerViewResolver;

    @RequestMapping(value = UrlProvider.LIST_STUDENTS_URL, method = RequestMethod.GET)
    public ModelAndView listStudents(Model model, HttpServletRequest request) {
        StudentListContext studentListContext = studentListContextFactory.create();
        AdminMenuContext adminMenuContext = adminMenuContextFactory.create();
        return studentListControllerViewResolver.resolveView(model, studentListContext, adminMenuContext);
    }
}
