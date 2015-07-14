package com.university.thesisapp.homepage.controller;

import com.university.thesisapp.homepage.factory.HomeContextFactory;
import com.university.thesisapp.homepage.model.HomeContext;
import com.university.thesisapp.homepage.view.HomeControllerViewResolver;
import com.university.thesisapp.web.provider.UrlProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private HomeContextFactory homeContextFactory;
    @Autowired
    private HomeControllerViewResolver homeControllerViewResolver;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = UrlProvider.HOME_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView showHomePage(Model model, HttpServletRequest request) {
        HomeContext homeContext = homeContextFactory.create(request);
        return homeControllerViewResolver.resolveView(model, homeContext);
    }

}
