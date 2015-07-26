package com.university.thesisapp.admin.teacherpage.controller;

import com.university.thesisapp.admin.homepage.context.AdminMenuContext;
import com.university.thesisapp.admin.teacherpage.context.TeacherListContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gábor on 2015.07.26..
 */
@Component
public class TeacherListControllerViewResolver {

    private static final String CONTEXT = "context";
    private static final String MENU = "menu";
    private static final String LIST_TEACHERS_VIEW_NAME = "list-teachers";

    public ModelAndView resolveView(Model model, TeacherListContext teacherListContext, AdminMenuContext adminMenuContext) {
        model.addAttribute(CONTEXT, teacherListContext);
        model.addAttribute(MENU, adminMenuContext);
        return new ModelAndView(LIST_TEACHERS_VIEW_NAME, model.asMap());
    }
}
