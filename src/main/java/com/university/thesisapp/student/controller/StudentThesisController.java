package com.university.thesisapp.student.controller;

import com.university.thesisapp.dao.persistence.dao.ThesisDao;
import com.university.thesisapp.dao.persistence.dao.ThesisStudentDao;
import com.university.thesisapp.dao.persistence.model.Comment;
import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.dao.persistence.model.ThesisStudent;
import com.university.thesisapp.dao.persistence.provider.ThesisUserProvider;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * Created by Gábor on 2015.09.18..
 */
@Controller
public class StudentThesisController {
    @Autowired
    ThesisDao thesisDao;
    @Autowired
    ThesisUserProvider thesisUserProvider;
    @Autowired
    ThesisStudentDao thesisStudentDao;

    @RequestMapping(value = UrlProvider.STUDENT_THESIS_HOMEPAGE_URL, method = RequestMethod.GET)
    public ModelAndView showThesisHomePage(Model model, HttpServletRequest request) {
        addThesisToModel(model);
        return new ModelAndView("student/thesis_home", model.asMap());
    }

    @RequestMapping(value = UrlProvider.STUDENT_COMMENTS_URL, method = RequestMethod.GET)
    public ModelAndView showCommentsPage(Model model, HttpServletRequest request) {
        addThesisToModel(model);
        model.addAttribute("commentTarget", "student_thesis");
        return new ModelAndView("/student/comments", model.asMap());
    }

    private void addThesisToModel(Model model) {
        ThesisStudent thesisStudent = thesisStudentDao.findByThesisUser(thesisUserProvider.getSignedInUser());
        Thesis thesis = thesisDao.findById(thesisStudent.getThesis().getThesisId());
        List<Comment> comments = thesis.getComments();
        Collections.sort(comments);
        model.addAttribute("comments", comments);
        model.addAttribute("thesis", thesis);
    }
}
