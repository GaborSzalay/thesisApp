package com.university.thesisapp.homepage.controller;

import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.09.24..
 */
@Controller
public class CommentControllerViewResolver {
    public ModelAndView resolveView(HttpServletRequest request) {
        String referrer = request.getHeader("referer");
        String redirectUrl = "/";
        if (referrer.contains(UrlProvider.STUDENT_COMMENTS_URL)) {
            redirectUrl = UrlProvider.STUDENT_COMMENTS_URL;
        } else if (referrer.contains(UrlProvider.TEACHER_COMMENTS_URL)) {
            redirectUrl = UrlProvider.TEACHER_COMMENTS_URL + "?thesisId=" + request.getParameter("thesisId");
        }
        return new ModelAndView(new RedirectView(redirectUrl));
    }
}
