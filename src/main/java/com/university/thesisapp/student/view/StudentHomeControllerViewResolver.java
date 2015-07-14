package com.university.thesisapp.student.view;

import com.university.thesisapp.student.model.StudentHomeContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gábor on 2015.07.15..
 */
@Component
public class StudentHomeControllerViewResolver {

    private static final String STUDENT_HOME_VIEW_NAME = "student";

    public ModelAndView resolveView(Model model, StudentHomeContext studentHomeContext) {
        model.addAttribute("context", studentHomeContext);
        return new ModelAndView(STUDENT_HOME_VIEW_NAME, model.asMap());
    }
}
