package com.university.thesisapp.admin.studentpage.controller;

import com.google.common.primitives.Longs;
import com.university.thesisapp.dao.persistence.dao.ThesisDao;
import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.util.Validation;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.09.09..
 */
@Controller
public class ThesisDetailsController {
    @Autowired
    ThesisDao thesisDao;

    @RequestMapping(value = {UrlProvider.ADMIN_SHOW_THESIS_URL, UrlProvider.STUDENT_SHOW_THESIS_URL}, method = RequestMethod.GET)
    public ModelAndView showThesisDetails(Model model, HttpServletRequest request) {
        String thesisParameter = request.getParameter("thesis");
        Long thesisId = Longs.tryParse(thesisParameter);
        if (Validation.notEmpty(thesisId)) {
            Thesis thesis = thesisDao.findById(thesisId);
            model.addAttribute("thesis", thesis);
        }
        return new ModelAndView("shared/thesis_details", model.asMap());
    }
}
