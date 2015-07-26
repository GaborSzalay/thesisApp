package com.university.thesisapp.admin.studentpage.controller;

import com.university.thesisapp.admin.homepage.context.AdminMenuContext;
import com.university.thesisapp.admin.studentpage.context.StudentListContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gábor on 2015.07.26..
 */
@Component
public class StudentListControllerViewResolver {

    private static final String CONTEXT = "context";
    private static final String MENU = "menu";
    private static final String LIST_STUDENTS_VIEW_NAME = "list-students";

    public ModelAndView resolveView(Model model, StudentListContext studentListContext, AdminMenuContext adminMenuContext) {
        model.addAttribute(CONTEXT, studentListContext);
        model.addAttribute(MENU, adminMenuContext);
        return new ModelAndView(LIST_STUDENTS_VIEW_NAME, model.asMap());
    }
}
