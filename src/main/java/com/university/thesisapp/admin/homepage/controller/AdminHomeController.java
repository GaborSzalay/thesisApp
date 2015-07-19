package com.university.thesisapp.admin.homepage.controller;

import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gábor on 2015.07.19..
 */
@Controller
public class AdminHomeController {

    @RequestMapping(value = UrlProvider.ADMIN_HOME_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView showAdminHomePage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("admin");

        return model;

    }
}
