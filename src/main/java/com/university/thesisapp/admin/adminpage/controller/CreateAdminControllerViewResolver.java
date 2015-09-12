package com.university.thesisapp.admin.adminpage.controller;

import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by Gábor on 2015.08.30..
 */
@Component
public class CreateAdminControllerViewResolver {
    public ModelAndView resolveViewByRedirecting() {
        return new ModelAndView(new RedirectView(UrlProvider.LIST_ADMINS_URL));
    }

    public ModelAndView resolveViewForShowingForm() {
        return new ModelAndView("admin/admin-creation-form");
    }
}
