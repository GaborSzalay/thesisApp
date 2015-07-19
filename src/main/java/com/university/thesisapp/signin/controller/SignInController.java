package com.university.thesisapp.signin.controller;

import com.university.thesisapp.signin.factory.SignInContextFactory;
import com.university.thesisapp.signin.model.SignInContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
        SignInContext signInContext = signInContextFactory.create(request);
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }

        model.addObject("context", signInContext);
        model.setViewName("login");
        return model;
    }
}
