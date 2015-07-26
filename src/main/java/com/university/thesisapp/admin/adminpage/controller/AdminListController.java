package com.university.thesisapp.admin.adminpage.controller;

import com.university.thesisapp.admin.adminpage.context.AdminListContext;
import com.university.thesisapp.admin.adminpage.context.AdminListContextFactory;
import com.university.thesisapp.admin.homepage.context.AdminMenuContext;
import com.university.thesisapp.admin.homepage.context.AdminMenuContextFactory;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.20..
 */
@Controller
public class AdminListController {
    @Autowired
    private AdminListContextFactory adminListContextFactory;
    @Autowired
    private AdminMenuContextFactory adminMenuContextFactory;
    @Autowired
    private AdminListControllerViewResolver adminListControllerViewResolver;

    @RequestMapping(value = UrlProvider.LIST_ADMINS_URL, method = RequestMethod.GET)
    public ModelAndView listAdmins(Model model, HttpServletRequest request) {
        AdminListContext adminListContext = adminListContextFactory.create();
        AdminMenuContext adminMenuContext = adminMenuContextFactory.create();
        return adminListControllerViewResolver.resolveView(model, adminListContext, adminMenuContext);
    }
}
