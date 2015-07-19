package com.university.thesisapp.admin.homepage.controller;

import com.university.thesisapp.admin.homepage.context.AdminHomeContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gábor on 2015.07.19..
 */
@Component
public class AdminHomeControllerViewResolver {

    private static final String ADMIN_HOME_VIEW_NAME = "admin";
    private static final String CONTEXT = "context";

    public ModelAndView resolveView(Model model, AdminHomeContext adminHomeContext) {
        model.addAttribute(CONTEXT, adminHomeContext);
        return new ModelAndView(ADMIN_HOME_VIEW_NAME, model.asMap());
    }
}
