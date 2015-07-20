package com.university.thesisapp.admin.adminpage.controller;

import com.university.thesisapp.admin.adminpage.context.AdminListContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gábor on 2015.07.20..
 */
@Component
public class AdminListControllerViewResolver {

    private static final String CONTEXT = "context";
    private static final String LIST_ADMINS_VIEW_NAME = "list-admins";

    public ModelAndView resolveView(Model model, AdminListContext adminListContext) {
        model.addAttribute(CONTEXT, adminListContext);
        return new ModelAndView(LIST_ADMINS_VIEW_NAME, model.asMap());
    }
}
