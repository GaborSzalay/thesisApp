package com.university.thesisapp.student.controller;

import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.09.14..
 */
@Component
public class StudentRequestControllerViewResolver {
    public ModelAndView resolveView(HttpServletRequest request, Model model) {
        String referrer = request.getHeader("referer");
        String redirectUrl;
        if (referrer.contains(UrlProvider.STUDENT_ALL_THESES_URL)) {
            redirectUrl = UrlProvider.STUDENT_ALL_THESES_URL;
        } else if (referrer.contains(UrlProvider.STUDENT_RECOMMENDED_THESES_URL)) {
            redirectUrl = UrlProvider.STUDENT_RECOMMENDED_THESES_URL;
        } else {
            redirectUrl = "/";
        }
        return new ModelAndView(new RedirectView(redirectUrl), model.asMap());
    }
}
