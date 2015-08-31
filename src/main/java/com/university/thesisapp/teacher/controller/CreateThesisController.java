package com.university.thesisapp.teacher.controller;

import com.google.common.primitives.Longs;
import com.university.thesisapp.dao.persistence.dao.ThesisDao;
import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.teacher.context.*;
import com.university.thesisapp.util.Validation;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.27..
 */
@Controller
public class CreateThesisController {
    private static final String EDIT_THESIS = "editThesis";
    @Autowired
    private TeacherMenuContextFactory teacherMenuContextFactory;
    @Autowired
    private CreateThesisControllerViewResolver createThesisControllerViewResolver;
    @Autowired
    private CreateThesisContextFactory createThesisContextFactory;
    @Autowired
    private ThesisDao thesisDao;
    @Autowired
    private ThesisProvider thesisProvider;

    @RequestMapping(value = UrlProvider.CREATE_THESIS_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView showCreateThesisForm(Model model, HttpServletRequest request) {
        TeacherMenuContext teacherMenuContext = teacherMenuContextFactory.create();
        CreateThesisContext createThesisContext = createThesisContextFactory.create();
        String thesisParameter = request.getParameter(EDIT_THESIS);
        if (Validation.notEmpty(thesisParameter)) {
            model.addAttribute("thesis", thesisDao.findById(Longs.tryParse(thesisParameter)));
        }
        return createThesisControllerViewResolver.resolveView(model, teacherMenuContext, createThesisContext);
    }

    @RequestMapping(value = UrlProvider.CREATE_THESIS_PAGE_URL, method = RequestMethod.POST)
    public ModelAndView handleCreateThesisForm(Model model, HttpServletRequest request) {

        Thesis thesis = thesisProvider.getThesis(request);
        thesisDao.creaateThesis(thesis);

        return createThesisControllerViewResolver.resolveCreationView(model);
    }
}
