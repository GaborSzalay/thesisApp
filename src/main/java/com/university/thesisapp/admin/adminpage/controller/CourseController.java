package com.university.thesisapp.admin.adminpage.controller;

import com.university.thesisapp.admin.homepage.context.AdminMenuContextFactory;
import com.university.thesisapp.dao.persistence.dao.CourseDao;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.09.12..
 */
@Controller
public class CourseController {
    @Autowired
    CourseDao courseDao;
    @Autowired
    AdminMenuContextFactory adminMenuContextFactory;
    @RequestMapping(value = UrlProvider.LIST_COURSES_URL, method = RequestMethod.GET)
    public ModelAndView showCourseList(Model model, HttpServletRequest request) {
        model.addAttribute("courses", courseDao.getAllCourses());
        model.addAttribute("menu",adminMenuContextFactory.create());
        return new ModelAndView("admin/list-courses", model.asMap());
    }
}
