package com.university.thesisapp.teacher.controller;

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

/**
 * Created by Gábor on 2015.08.05..
 */
@Controller
public class CreateThesisFormController {

    @Autowired
    private CreateThesisControllerViewResolver createThesisControllerViewResolver;
    @Autowired
    private ThesisProvider thesisProvider;

    @Autowired
    private ThesisDao thesisDao;

    @RequestMapping(value = UrlProvider.CREATE_THESIS_PAGE_URL, method = RequestMethod.POST)
    public ModelAndView handleCreateThesisForm(Model model, HttpServletRequest request) {

        Thesis thesis = thesisProvider.getThesis(request);
        thesisDao.creaateThesis(thesis);

        return createThesisControllerViewResolver.resolveCreationView(model);
    }
}
