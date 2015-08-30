package com.university.thesisapp.admin.adminpage.controller;

import com.university.thesisapp.admin.adminpage.service.CreateUserService;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.08.30..
 */
@Controller
public class CreateAdminController {
    @Autowired
    private CreateAdminControllerViewResolver createAdminControllerViewResolver;
    @Autowired
    CreateUserService createUserService;

    @RequestMapping(value = UrlProvider.CREATE_ADMIN_URL, method = RequestMethod.POST)
    public ModelAndView handleCreateAdminRequest(Model model, HttpServletRequest request) {
        createUserService.createAdmin(request);
        return createAdminControllerViewResolver.resolveViewForHandlingCreationRequest();
    }

    @RequestMapping(value = UrlProvider.CREATE_ADMIN_URL, method = RequestMethod.GET)
    public ModelAndView showCreateAdminForm(Model model, HttpServletRequest request) {

        return createAdminControllerViewResolver.resolveViewForShowingForm();
    }
}
