package com.university.thesisapp.admin.adminpage.controller;

import com.university.thesisapp.admin.homepage.context.AdminMenuContextFactory;
import com.university.thesisapp.dao.persistence.dao.MajorDao;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.09.12..
 */
@Controller
public class MajorController {
    @Autowired
    MajorDao majorDao;
    @Autowired
    AdminMenuContextFactory adminMenuContextFactory;

    @RequestMapping(value = UrlProvider.LIST_MAJORS_URL, method = RequestMethod.GET)
    public ModelAndView showMajorList(Model model, HttpServletRequest request) {
        model.addAttribute("majors", majorDao.getAllMajors());
        model.addAttribute("menu",adminMenuContextFactory.create());
        return new ModelAndView("admin/list-majors", model.asMap());
    }
}
