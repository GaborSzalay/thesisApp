package com.university.thesisapp.homepage.factory;

import com.university.thesisapp.homepage.model.HomeContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.11..
 */
@Component
public class HomeContextFactory {
    @Autowired
    private RegistrationLinkFactory registrationLinkFactory;
    @Autowired
    private LoginStudentLinkFactory loginStudentLinkFactory;
    @Autowired
    private LoginTeacherLinkFactory loginTeacherLinkFactory;

    public HomeContext create(HttpServletRequest request) {
        HomeContext homeContext = new HomeContext();
        homeContext.setRegistrationLink(registrationLinkFactory.create());
        homeContext.setLoginStudentLink(loginStudentLinkFactory.create());
        homeContext.setLoginTeacherLink(loginTeacherLinkFactory.create());
        return homeContext;
    }
}
