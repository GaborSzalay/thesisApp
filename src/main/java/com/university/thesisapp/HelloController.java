package com.university.thesisapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = {"/welcome**"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is welcome page!");
        model.setViewName("hello");
        return model;

    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is an admin page!");
        model.addObject("user", "admin");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/teacher**", method = RequestMethod.GET)
    public ModelAndView teacherPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is a teacher page!");
        model.addObject("sharedPageEnabled", true);
        model.addObject("user", "teacher");
        model.setViewName("admin");

        return model;

    }


    @RequestMapping(value = {"/student/shared.html", "/teacher/shared.html"}, method = RequestMethod.GET)
    public ModelAndView sharedPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is a shared page between students and teachers!");
        model.setViewName("admin");

        return model;

    }

}