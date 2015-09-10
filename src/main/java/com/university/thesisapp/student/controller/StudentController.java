package com.university.thesisapp.student.controller;

import com.university.thesisapp.dao.persistence.dao.ThesisDao;
import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Gábor on 2015.09.11..
 */
@Controller
public class StudentController {
    @Autowired
    ThesisDao thesisDao;

    @RequestMapping(value = UrlProvider.STUDENT_HOME_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView showHomePage(Model model, HttpServletRequest request) {
        return new ModelAndView("/student/student-home", model.asMap());
    }

    @RequestMapping(value = UrlProvider.STUDENT_RECOMMENDED_THESES_URL, method = RequestMethod.GET)
    public ModelAndView showRecommendedThesesPage(Model model, HttpServletRequest request) {
        return new ModelAndView("/student/recommended-theses", model.asMap());
    }

    @RequestMapping(value = UrlProvider.STUDENT_ALL_THESES_URL, method = RequestMethod.GET)
    public ModelAndView showAllThesesPage(Model model, HttpServletRequest request) {
        List<Thesis> theses = thesisDao.getAllThesises();
        model.addAttribute("theses", theses);
        return new ModelAndView("/student/all-theses", model.asMap());
    }
}
