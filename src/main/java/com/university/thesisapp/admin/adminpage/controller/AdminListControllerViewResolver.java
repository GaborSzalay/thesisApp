package com.university.thesisapp.admin.adminpage.controller;

import com.university.thesisapp.admin.adminpage.context.AdminListContext;
import com.university.thesisapp.admin.homepage.context.AdminMenuContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gábor on 2015.07.20..
 */
@Component
public class AdminListControllerViewResolver {

    private static final String CONTEXT = "context";
    private static final String LIST_ADMINS_VIEW_NAME = "admin/list-admins";
    private static final String MENU = "menu";

    public ModelAndView resolveView(Model model, AdminListContext adminListContext, AdminMenuContext adminMenuContext) {
        model.addAttribute(CONTEXT, adminListContext);
        model.addAttribute(MENU, adminMenuContext);
        return new ModelAndView(LIST_ADMINS_VIEW_NAME, model.asMap());
    }
}
