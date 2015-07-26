package com.university.thesisapp.homepage.view;

import com.university.thesisapp.dao.persistence.provider.ThesisUserAuthorityProvider;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by Gábor on 2015.07.11..
 */
@Component
public class HomeControllerViewResolver {
    private static final String HOME_VIEW_NAME = "home";

    @Autowired
    private ThesisUserAuthorityProvider thesisUserAuthorityProvider;

    public ModelAndView resolveView(Model model) {
        View redirectView = null;
        if (thesisUserAuthorityProvider.isStudent()) {
            redirectView = new RedirectView(UrlProvider.STUDENT_HOME_PAGE_URL);
        } else if (thesisUserAuthorityProvider.isTeacher()) {
            redirectView = new RedirectView(UrlProvider.TEACHER_HOME_PAGE_URL);
        } else if (thesisUserAuthorityProvider.isAdmin()) {
            redirectView = new RedirectView(UrlProvider.ADMIN_HOME_PAGE_URL);
        }
        return new ModelAndView(redirectView);
    }

}
