package com.university.thesisapp.signin.controller;

import com.university.thesisapp.signin.context.SignInContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gábor on 2015.07.26..
 */
@Component
public class SignInControllerViewResolver {

    private static final String CONTEXT = "context";
    private static final String LOGIN_VIEW_NAME = "login";

    public ModelAndView resolveView(Model model, SignInContext signInContext) {
        model.addAttribute(CONTEXT, signInContext);
        return new ModelAndView(LOGIN_VIEW_NAME);
    }
}
