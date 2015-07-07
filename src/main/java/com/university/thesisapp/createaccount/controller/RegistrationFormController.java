package com.university.thesisapp.createaccount.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gábor on 2015.07.07..
 */
@Controller
public class RegistrationFormController {

    @RequestMapping(value = "/registration.html", method = RequestMethod.GET)
    public ModelAndView showRegistrationForm(Model model) {
        return new ModelAndView("registration", model.asMap());
    }
}
