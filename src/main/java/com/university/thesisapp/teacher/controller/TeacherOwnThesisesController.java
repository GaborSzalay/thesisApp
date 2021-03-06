package com.university.thesisapp.teacher.controller;

import com.google.common.primitives.Longs;
import com.university.thesisapp.dao.persistence.ThesisStatus;
import com.university.thesisapp.dao.persistence.dao.ThesisDao;
import com.university.thesisapp.homepage.controller.EmailSenderService;
import com.university.thesisapp.teacher.context.*;
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
 * Created by Gábor on 2015.07.27..
 */
@Controller
public class TeacherOwnThesisesController {
    @Autowired
    private TeacherMenuContextFactory teacherMenuContextFactory;
    @Autowired
    private TeacherOwnThesisesControllerViewResolver teacherOwnThesisesControllerViewResolver;
    @Autowired
    private TeacherOwnThesisesContextFactory teacherOwnThesisesContextFactory;
    @Autowired
    private ThesisDao thesisDao;
    @Autowired
    private EmailSenderService emailSenderService;

    @RequestMapping(value = UrlProvider.TEACHER_NEW_OWN_THESIS_LIST_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView listNewOwnThesises(Model model, HttpServletRequest request) {
        TeacherMenuContext teacherMenuContext = teacherMenuContextFactory.create();
        model.addAttribute("currentMenu", "newOwnThesises");
        TeacherOwnThesisesContext teacherOwnThesisesContext = teacherOwnThesisesContextFactory.create(ThesisStatus.NEW);
        return teacherOwnThesisesControllerViewResolver.resolveView(model, teacherMenuContext, teacherOwnThesisesContext);
    }

    @RequestMapping(value = UrlProvider.TEACHER_IN_PROGRESS_OWN_THESIS_LIST_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView listInProgressOwnThesises(Model model, HttpServletRequest request) {
        TeacherMenuContext teacherMenuContext = teacherMenuContextFactory.create();
        model.addAttribute("currentMenu", "inProgressThesises");
        TeacherOwnThesisesContext teacherOwnThesisesContext = teacherOwnThesisesContextFactory.create(ThesisStatus.IN_PROGRESS);
        return teacherOwnThesisesControllerViewResolver.resolveView(model, teacherMenuContext, teacherOwnThesisesContext);
    }

    @RequestMapping(value = UrlProvider.TEACHER_CLOSED_OWN_THESIS_LIST_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView listClosedOwnThesises(Model model, HttpServletRequest request) {
        TeacherMenuContext teacherMenuContext = teacherMenuContextFactory.create();
        model.addAttribute("currentMenu", "closedThesises");
        TeacherOwnThesisesContext teacherOwnThesisesContext = teacherOwnThesisesContextFactory.create(ThesisStatus.ACCEPTED);
        return teacherOwnThesisesControllerViewResolver.resolveView(model, teacherMenuContext, teacherOwnThesisesContext);
    }

    @RequestMapping(value = UrlProvider.TEACHER_ACCEPT_THESIS_URL, method = RequestMethod.GET)
    public ModelAndView acceptThesises(Model model, HttpServletRequest request) {
        Long thesisId = Longs.tryParse(request.getParameter("thesis"));
        thesisDao.setStatus(thesisId, ThesisStatus.ACCEPTED);
        emailSenderService.sendMailAfterAcceptedThesis(thesisDao.findById(thesisId));
        return new ModelAndView(new RedirectView(UrlProvider.TEACHER_CLOSED_OWN_THESIS_LIST_PAGE_URL));
    }

    @RequestMapping(value = UrlProvider.TEACHER_DECLINE_THESIS_URL, method = RequestMethod.GET)
    public ModelAndView declineThesises(Model model, HttpServletRequest request) {
        Long thesisId = Longs.tryParse(request.getParameter("thesis"));
        thesisDao.setStatus(thesisId, ThesisStatus.DECLINED);
        emailSenderService.sendMailAfterDeclinedThesis(thesisDao.findById(thesisId));
        return new ModelAndView(new RedirectView(UrlProvider.TEACHER_CLOSED_OWN_THESIS_LIST_PAGE_URL));
    }
}
