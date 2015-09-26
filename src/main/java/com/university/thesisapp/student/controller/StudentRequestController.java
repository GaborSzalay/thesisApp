package com.university.thesisapp.student.controller;

import com.google.common.primitives.Longs;
import com.university.thesisapp.dao.persistence.dao.StudentRequestDao;
import com.university.thesisapp.dao.persistence.dao.ThesisStudentDao;
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

/**
 * Created by Gábor on 2015.09.14..
 */
@Controller
public class StudentRequestController {
    @Autowired
    private StudentRequestControllerViewResolver studentRequestControllerViewResolver;
    @Autowired
    private ThesisStudentDao thesisStudentDao;
    @Autowired
    private ThesisUserProvider thesisUserProvider;
    @Autowired
    private StudentRequestDao studentRequestDao;

    @RequestMapping(value = UrlProvider.STUDENT_STUDENT_REQUEST_HTML, method = RequestMethod.GET)
    public ModelAndView handleStudentRequest(Model model, HttpServletRequest request) {
        ThesisStudent thesisStudent = thesisStudentDao.findByThesisUser(thesisUserProvider.getSignedInUser());
        studentRequestDao.createStudentRequest(thesisStudent.getThesisStudentId(), Longs.tryParse(request.getParameter("thesis")));
        return studentRequestControllerViewResolver.resolveView(request, model);
    }

    @RequestMapping(value = UrlProvider.STUDENT_CANCEL_REQUEST_URL, method = RequestMethod.GET)
    public ModelAndView cancelStudentRequest(Model model, HttpServletRequest request) {
        ThesisStudent thesisStudent = thesisStudentDao.findByThesisUser(thesisUserProvider.getSignedInUser());
        studentRequestDao.cancelStudentRequest(thesisStudent.getThesisStudentId(), Longs.tryParse(request.getParameter("thesis")));
        return studentRequestControllerViewResolver.resolveView(request, model);
    }
}
