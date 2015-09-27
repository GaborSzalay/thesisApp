package com.university.thesisapp.teacher.controller;

import com.google.common.primitives.Longs;
import com.university.thesisapp.dao.persistence.dao.ThesisDao;
import com.university.thesisapp.dao.persistence.dao.ThesisTeacherDao;
import com.university.thesisapp.dao.persistence.model.Comment;
import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.dao.persistence.provider.ThesisUserProvider;
import com.university.thesisapp.teacher.context.TeacherMenuContext;
import com.university.thesisapp.teacher.context.TeacherMenuContextFactory;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * Created by Gábor on 2015.09.27..
 */
@Controller
public class TeacherCommentController {
    @Autowired
    private TeacherMenuContextFactory teacherMenuContextFactory;
    @Autowired
    private ThesisTeacherDao thesisTeacherDao;
    @Autowired
    private ThesisUserProvider thesisUserProvider;
    @Autowired
    private ThesisDao thesisDao;

    @RequestMapping(value = UrlProvider.TEACHER_COMMENTS_URL, method = RequestMethod.GET)
    public ModelAndView showCommentsPage(Model model, HttpServletRequest request) {
        TeacherMenuContext teacherMenuContext = teacherMenuContextFactory.create();
        model.addAttribute("commentTarget", "teacher");
        String thesisId = request.getParameter("thesisId");
        Thesis thesis = thesisDao.findById(Longs.tryParse(thesisId));
        List<Comment> comments = thesis.getComments();
        Collections.sort(comments);
        model.addAttribute("comments", comments);
        model.addAttribute("thesis", thesis);
        return new ModelAndView("/shared/comments", model.asMap());
    }

}
