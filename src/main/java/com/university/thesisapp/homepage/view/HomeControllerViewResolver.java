package com.university.thesisapp.homepage.view;

import com.university.thesisapp.ThesisAuthority;
import com.university.thesisapp.homepage.model.HomeContext;
import com.university.thesisapp.util.Validation;
import com.university.thesisapp.web.cookie.CookieValueProvider;
import com.university.thesisapp.web.provider.CookieProvider;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.11..
 */
@Component
public class HomeControllerViewResolver {
    private static final String HOME_VIEW_NAME = "home";
    private static final String CONTEXT = "context";

    @Autowired
    private CookieValueProvider cookieValueProvider;

    public ModelAndView resolveView(HttpServletRequest request, Model model, HomeContext homeContext) {
        Cookie userCookie = cookieValueProvider.findCookie(request, CookieProvider.USER);
        View redirectView = null;
        if (Validation.notEmpty(userCookie)) {
            if (ThesisAuthority.TEACHER.toString().equals(userCookie.getValue())) {
                redirectView = new RedirectView(UrlProvider.TEACHER_PREFIX + UrlProvider.INDEX_URL);
            } else if (ThesisAuthority.STUDENT.toString().equals(userCookie.getValue())) {
                redirectView = new RedirectView(UrlProvider.STUDENT_PREFIX + UrlProvider.INDEX_URL);
            }
        }
        model.addAttribute(CONTEXT, homeContext);
        return (Validation.Empty(redirectView)) ? new ModelAndView(HOME_VIEW_NAME, model.asMap()) : new ModelAndView(redirectView);
    }
}
