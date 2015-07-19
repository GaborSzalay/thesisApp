package com.university.thesisapp.admin.homepage.controller;

import com.university.thesisapp.admin.homepage.context.AdminHomeContext;
import com.university.thesisapp.admin.homepage.context.AdminHomeContextFactory;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.19..
 */
@Controller
public class AdminHomeController {
    @Autowired
    private AdminHomeContextFactory adminHomeContextFactory;
    @Autowired
    private AdminHomeControllerViewResolver adminHomeControllerViewResolver;

    @RequestMapping(value = UrlProvider.ADMIN_HOME_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView showAdminHomePage(Model model, HttpServletRequest request) {
        AdminHomeContext adminHomeContext = adminHomeContextFactory.create();
        return adminHomeControllerViewResolver.resolveView(model, adminHomeContext);

    }
}
