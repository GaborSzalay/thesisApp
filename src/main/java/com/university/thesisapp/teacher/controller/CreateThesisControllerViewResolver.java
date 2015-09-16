package com.university.thesisapp.teacher.controller;

import com.university.thesisapp.teacher.context.CreateThesisContext;
import com.university.thesisapp.teacher.context.TeacherMenuContext;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by Gábor on 2015.07.27..
 */
@Component
public class CreateThesisControllerViewResolver {

    private static final String THESIS_CREATION_FORM_VIEW_NAME = "teacher/thesis-creation-form";

    public ModelAndView resolveView(Model model, TeacherMenuContext teacherMenuContext, CreateThesisContext createThesisContext) {
        model.addAttribute("menu", teacherMenuContext);
        model.addAttribute("context", createThesisContext);
        return new ModelAndView(THESIS_CREATION_FORM_VIEW_NAME, model.asMap());
    }

    public ModelAndView resolveCreationView(Model model) {

        View view = new RedirectView(UrlProvider.TEACHER_OWN_THESIS_LIST_PAGE_URL);
        return new ModelAndView(view, model.asMap());
    }
}
