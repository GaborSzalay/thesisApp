package com.university.thesisapp.createaccount.view;

import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by Gábor on 2015.07.13..
 */
@Component
public class CreateAccountViewResolver {
    public ModelAndView resolveView(Model model, boolean registrationEnabled) {
        RedirectView view = null;
        if (registrationEnabled) {
            view = new RedirectView(UrlProvider.LOGIN_PAGE_URL_WITH_CREATED);
        } else {
            view = new RedirectView(UrlProvider.LOGIN_PAGE_URL_WITH_EXISTING);
        }
        return new ModelAndView(view, model.asMap());
    }

    public ModelAndView resolveViewActivationView(Model model) {
        RedirectView view = new RedirectView(UrlProvider.LOGIN_PAGE_URL_WITH_ACTIVATED);
        return new ModelAndView(view, model.asMap());
    }
}
