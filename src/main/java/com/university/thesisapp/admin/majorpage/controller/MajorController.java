package com.university.thesisapp.admin.majorpage.controller;

import com.google.common.primitives.Longs;
import com.university.thesisapp.admin.homepage.context.AdminMenuContextFactory;
import com.university.thesisapp.dao.persistence.dao.MajorDao;
import com.university.thesisapp.util.Validation;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

    @RequestMapping(value = UrlProvider.ADMIN_MAJOR_URL, method = RequestMethod.GET)
    public ModelAndView showMajorForm(Model model, HttpServletRequest request) {
        String editMajor = request.getParameter("editMajor");
        if (Validation.notEmpty(editMajor)) {
            Long majorId = Longs.tryParse(editMajor);
            request.setAttribute("major", majorDao.findById(majorId));
        }
        return new ModelAndView("admin/create_major_form", model.asMap());
    }

    @RequestMapping(value = UrlProvider.ADMIN_MAJOR_URL, method = RequestMethod.POST)
    public ModelAndView handleMajorCreationRequest(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        String majorId = request.getParameter("majorId");
        if (Validation.notEmpty(name)) {
            if (Validation.notEmpty(majorId)) {
                majorDao.editMajor(Longs.tryParse(majorId), name);
            } else {
                majorDao.createMajor(name);
            }
        }
        return new ModelAndView(new RedirectView(UrlProvider.LIST_MAJORS_URL));
    }
}
