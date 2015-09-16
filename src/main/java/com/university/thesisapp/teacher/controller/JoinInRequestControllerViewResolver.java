package com.university.thesisapp.teacher.controller;

import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.09.17..
 */
@Component
public class JoinInRequestControllerViewResolver {
    public ModelAndView resolveView(HttpServletRequest request, Model model) {
        String referrer = request.getHeader("referer");
        String redirectUrl;
        if (referrer.contains(UrlProvider.TEACHER_REQUESTS_URL)) {
            redirectUrl = UrlProvider.TEACHER_REQUESTS_URL;
        } else if (referrer.contains(UrlProvider.TEACHER_DECLINED_REQUESTS_URL)) {
            redirectUrl = UrlProvider.TEACHER_DECLINED_REQUESTS_URL;
        } else {
            redirectUrl = "/";
        }
        return new ModelAndView(new RedirectView(redirectUrl), model.asMap());
    }
}
