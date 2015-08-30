package com.university.thesisapp.admin.adminpage.controller;

import com.google.common.primitives.Longs;
import com.university.thesisapp.dao.persistence.dao.ThesisUserDao;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.08.30..
 */
@Controller
public class DeleteAdminController {
    @Autowired
    private CreateAdminControllerViewResolver createAdminControllerViewResolver;
    @Autowired
    private ThesisUserDao thesisUserDao;

    @RequestMapping(value = UrlProvider.DELETE_ADMIN_URL, method = RequestMethod.GET)
    public ModelAndView deleteAdminById(Model model, HttpServletRequest request) {
        Long adminId = Longs.tryParse(request.getParameter("admin"));
        thesisUserDao.tryToDeleteThesisUser(adminId);
        return createAdminControllerViewResolver.resolveViewByRedirecting();
    }
}
