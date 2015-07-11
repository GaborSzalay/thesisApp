package com.university.thesisapp.teacher.view;

import com.university.thesisapp.teacher.model.TeacherHomeContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gábor on 2015.07.11..
 */
@Component
public class TeacherHomeControllerViewResolver {

    private static final String TEACH_HOME_VIEW_NAME = "teacher";

    public ModelAndView resolveView(Model model, TeacherHomeContext teacherHomeContext) {
        model.addAttribute("context", teacherHomeContext);
        return new ModelAndView(TEACH_HOME_VIEW_NAME, model.asMap());
    }
}
