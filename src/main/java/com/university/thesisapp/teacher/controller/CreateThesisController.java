package com.university.thesisapp.teacher.controller;

import com.university.thesisapp.teacher.context.CreateThesisContext;
import com.university.thesisapp.teacher.context.CreateThesisContextFactory;
import com.university.thesisapp.teacher.context.TeacherMenuContext;
import com.university.thesisapp.teacher.context.TeacherMenuContextFactory;
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
    @Autowired
    private TeacherMenuContextFactory teacherMenuContextFactory;
    @Autowired
    private CreateThesisControllerViewResolver createThesisControllerViewResolver;
    @Autowired
    private CreateThesisContextFactory createThesisContextFactory;

    @RequestMapping(value = UrlProvider.CREATE_THESIS_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView showCreateThesisForm(Model model, HttpServletRequest request) {
        TeacherMenuContext teacherMenuContext = teacherMenuContextFactory.create();
        CreateThesisContext createThesisContext = createThesisContextFactory.create();
        return createThesisControllerViewResolver.resolveView(model, teacherMenuContext, createThesisContext);
    }
}
