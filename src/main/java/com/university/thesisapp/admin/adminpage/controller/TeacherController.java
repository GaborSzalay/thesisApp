package com.university.thesisapp.admin.adminpage.controller;

import com.google.common.primitives.Longs;
import com.university.thesisapp.admin.adminpage.service.CreateUserService;
import com.university.thesisapp.dao.persistence.dao.ThesisTeacherDao;
import com.university.thesisapp.dao.persistence.dao.ThesisUserDao;
import com.university.thesisapp.dao.persistence.model.ThesisTeacher;
import com.university.thesisapp.homepage.controller.EmailSenderService;
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
 * Created by Gábor on 2015.09.12..
 */
@Controller
public class TeacherController {
    @Autowired
    CreateUserService createUserService;
    @Autowired
    ThesisTeacherDao thesisTeacherDao;
    @Autowired
    EmailSenderService emailSenderService;
    @Autowired
    ThesisUserDao thesisUserDao;

    @RequestMapping(value = UrlProvider.ADMIN_TEACHER_HTML, method = RequestMethod.GET)
    public ModelAndView showCreateTeacherForm(Model model, HttpServletRequest request) {
        return new ModelAndView("admin/teacher-creation-form", model.asMap());
    }

    @RequestMapping(value = UrlProvider.ADMIN_TEACHER_HTML, method = RequestMethod.POST)
    public ModelAndView handleCreateTeacherRequest(Model model, HttpServletRequest request) {
        if (thesisUserDao.isRegistrationEnabled(request.getParameter("email"))) {
            ThesisTeacher teacher = createUserService.createTeacher(request);
            emailSenderService.sendMailAfterRegistration(teacher.getThesisUser().getEmail(), request);
        }
        return new ModelAndView(new RedirectView(UrlProvider.LIST_TEACHERS_URL), model.asMap());
    }

    @RequestMapping(value = UrlProvider.ADMIN_DELETE_TEACHER_HTML, method = RequestMethod.GET)
    public ModelAndView deleteTeacher(Model model, HttpServletRequest request) {
        thesisTeacherDao.tryToDeleteThesisTeacher(Longs.tryParse(request.getParameter("teacher")));
        return new ModelAndView(new RedirectView(UrlProvider.LIST_TEACHERS_URL), model.asMap());
    }
}
