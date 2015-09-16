package com.university.thesisapp.teacher.controller;

import com.university.thesisapp.teacher.context.TeacherMenuContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gábor on 2015.07.26..
 */
@Component
public class TeacherHomeControllerViewResolver {

    private static final String TEACHER_VIEW_NAME = "teacher/teacher";
    private static final String MENU = "menu";

    public ModelAndView resolveView(Model model, TeacherMenuContext teacherMenuContext) {
        model.addAttribute(MENU, teacherMenuContext);
        return new ModelAndView(TEACHER_VIEW_NAME, model.asMap());
    }
}
