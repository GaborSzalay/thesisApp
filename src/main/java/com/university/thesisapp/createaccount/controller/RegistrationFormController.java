package com.university.thesisapp.createaccount.controller;

import com.university.thesisapp.dao.persistence.dao.CourseDao;
import com.university.thesisapp.dao.persistence.dao.MajorDao;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gábor on 2015.07.07..
 */
@Controller
public class RegistrationFormController {
    @Autowired
    MajorDao majorDao;
    @Autowired
    CourseDao courseDao;

    @RequestMapping(value = UrlProvider.REGISTRATION_URL, method = RequestMethod.GET)
    public ModelAndView showRegistrationForm(Model model) {
        model.addAttribute("majors", majorDao.getAllMajors());
        model.addAttribute("courses", courseDao.getAllCourses());
        return new ModelAndView("registration", model.asMap());
    }
}
