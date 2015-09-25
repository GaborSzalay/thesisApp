package com.university.thesisapp.homepage.controller;

import com.google.common.primitives.Longs;
import com.university.thesisapp.dao.persistence.dao.CommentDao;
import com.university.thesisapp.dao.persistence.model.Comment;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.09.24..
 */
@Controller
public class CommentController {
    public static final String FROM = "szalay.gabor0@gmail.com";
    public static final String TO = "yaastreet@gmail.com";
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private CommentControllerViewResolver commentControllerViewResolver;


    @RequestMapping(value = UrlProvider.STUDENT_THESIS_CREATE_COMMENT_URL, method = RequestMethod.GET)
    public ModelAndView createComment(Model model, HttpServletRequest request) {
        String thesisIdParameter = request.getParameter("thesisId");
        String commentMessage = request.getParameter("commentMessage");
        Long thesisId = Longs.tryParse(thesisIdParameter);
        Comment comment = commentDao.createComment(commentMessage, thesisId);

        return commentControllerViewResolver.resolveView(request);
    }
}
