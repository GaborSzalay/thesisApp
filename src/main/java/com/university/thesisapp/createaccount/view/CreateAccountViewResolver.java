package com.university.thesisapp.createaccount.view;

import com.university.thesisapp.createaccount.context.CreateAccountContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by Gábor on 2015.07.13..
 */
@Component
public class CreateAccountViewResolver {
    public ModelAndView resolveView(CreateAccountContext createAccountContext, Model model) {
        RedirectView view = new RedirectView(createAccountContext.getLoginPageUrl());
        return new ModelAndView(view, model.asMap());
    }
}
