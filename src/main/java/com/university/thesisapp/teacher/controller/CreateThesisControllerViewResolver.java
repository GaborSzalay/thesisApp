package com.university.thesisapp.teacher.controller;

import com.university.thesisapp.teacher.context.CreateThesisContext;
import com.university.thesisapp.teacher.context.TeacherMenuContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gábor on 2015.07.27..
 */
@Component
public class CreateThesisControllerViewResolver {

    private static final String THESIS_CREATION_FORM_VIEW_NAME = "thesis-creation-form";

    public ModelAndView resolveView(Model model, TeacherMenuContext teacherMenuContext, CreateThesisContext createThesisContext) {
        model.addAttribute("menu", teacherMenuContext);
        model.addAttribute("context", createThesisContext);
        return new ModelAndView(THESIS_CREATION_FORM_VIEW_NAME, model.asMap());
    }
}
