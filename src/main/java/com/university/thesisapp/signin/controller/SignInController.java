package com.university.thesisapp.signin.controller;

import com.university.thesisapp.signin.context.SignInContextFactory;
import com.university.thesisapp.signin.context.SignInContext;
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
 * Created by Gábor on 2015.07.15..
 */
@Controller
public class SignInController {
    Logger logger = LoggerFactory.getLogger(SignInController.class);

    @Autowired
    private SignInContextFactory signInContextFactory;
    @Autowired
    private SignInControllerViewResolver signInControllerViewResolver;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, Model model) {
        SignInContext signInContext = signInContextFactory.create(request);
        return signInControllerViewResolver.resolveView(model, signInContext);
    }
}
