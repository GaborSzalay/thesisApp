package com.university.thesisapp.createaccount.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gábor on 2015.07.07..
 */
@Controller
public class RegistrationController {
    
    @RequestMapping(value = "/registration.html", method = RequestMethod.GET)
    public ModelAndView showRegistrationForm() {
        return new ModelAndView("registration");
    }
}
