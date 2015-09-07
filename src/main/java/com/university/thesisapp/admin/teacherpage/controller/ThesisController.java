package com.university.thesisapp.admin.teacherpage.controller;

import com.google.common.primitives.Longs;
import com.university.thesisapp.dao.persistence.dao.ThesisTeacherDao;
import com.university.thesisapp.dao.persistence.model.ThesisTeacher;
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
 * Created by Gábor on 2015.09.07..
 */
@Controller
public class ThesisController {
    @Autowired
    ThesisTeacherDao thesisTeacherDao;

    @RequestMapping(value = UrlProvider.LIST_THESISES, method = RequestMethod.GET)
    public ModelAndView listThesises(Model model, HttpServletRequest request) {
        String teacherParam = request.getParameter("teacher");
        if (Validation.notEmpty(teacherParam)) {
            Long teacherId = Longs.tryParse(teacherParam);
            ThesisTeacher thesisTeacher = thesisTeacherDao.getThesisTeacherById(teacherId);
            model.addAttribute("teacher", thesisTeacher);
        }
        return new ModelAndView("admin/list-thesis", model.asMap());
    }
}
