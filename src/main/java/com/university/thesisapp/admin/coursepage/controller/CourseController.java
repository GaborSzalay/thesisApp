package com.university.thesisapp.admin.coursepage.controller;

import com.google.common.primitives.Longs;
import com.university.thesisapp.admin.homepage.context.AdminMenuContextFactory;
import com.university.thesisapp.dao.persistence.dao.CourseDao;
import com.university.thesisapp.util.Validation;
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
        String editCourseParameter = request.getParameter("editCourse");
        if (Validation.notEmpty(editCourseParameter)) {
            Long courseId = Longs.tryParse(editCourseParameter);
            request.setAttribute("course", courseDao.findById(courseId));
        }
        return new ModelAndView("admin/create_course_form");
    }

    @RequestMapping(value = UrlProvider.CREATE_COURSE_URL, method = RequestMethod.POST)
    public ModelAndView handleCreateCourseRequest(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        String courseId = request.getParameter("courseId");
        if (Validation.notEmpty(courseId)) {
            courseDao.editCourse(Longs.tryParse(courseId), name, code);
        } else {
            courseDao.createCourse(name, code);
        }
        return new ModelAndView(new RedirectView(UrlProvider.LIST_COURSES_URL));
    }
}
