package com.university.thesisapp.admin.coursepage.controller;

import com.university.thesisapp.admin.homepage.context.AdminMenuContextFactory;
import com.university.thesisapp.dao.persistence.dao.CourseDao;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.11.21..
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

    @RequestMapping(value = UrlProvider.CREATE_COURSE_URL, method = RequestMethod.GET)
    public ModelAndView showCreateCourseForm(Model model, HttpServletRequest request) {
        return new ModelAndView("admin/create_course_form");
    }

    @RequestMapping(value = UrlProvider.CREATE_COURSE_URL, method = RequestMethod.POST)
    public ModelAndView handleCreateCourseRequest(Model model, HttpServletRequest request) {
        return new ModelAndView(new RedirectView(UrlProvider.LIST_COURSES_URL));
    }
}
