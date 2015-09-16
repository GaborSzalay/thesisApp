package com.university.thesisapp.teacher.context;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gábor on 2015.07.27..
 */
@Component
public class TeacherOwnThesisesControllerViewResolver {

    private static final String MENU = "menu";
    private static final String CONTEXT = "context";
    private static final String LIST_OWN_THESISES_VIEW_NAME = "teacher/list-own-thesises";

    public ModelAndView resolveView(Model model, TeacherMenuContext teacherMenuContext, TeacherOwnThesisesContext teacherOwnThesisesContext) {
        model.addAttribute(CONTEXT, teacherOwnThesisesContext);
        model.addAttribute(MENU, teacherMenuContext);
        return new ModelAndView(LIST_OWN_THESISES_VIEW_NAME, model.asMap());
    }
}
