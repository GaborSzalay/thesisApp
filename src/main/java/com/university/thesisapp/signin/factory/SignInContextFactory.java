package com.university.thesisapp.signin.factory;

import com.university.thesisapp.homepage.factory.LoginStudentLinkFactory;
import com.university.thesisapp.homepage.factory.LoginTeacherLinkFactory;
import com.university.thesisapp.homepage.factory.RegistrationLinkFactory;
import com.university.thesisapp.signin.model.SignInContext;
import com.university.thesisapp.web.cookie.UserCookieValueProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.15..
 */
@Component
public class SignInContextFactory {
    @Autowired
    private UserCookieValueProvider userCookieValueProvider;
    @Autowired
    private RegistrationLinkFactory registrationLinkFactory;
    @Autowired
    private LoginTeacherLinkFactory loginTeacherLinkFactory;
    @Autowired
    private LoginStudentLinkFactory loginStudentLinkFactory;

    public SignInContext create(HttpServletRequest request) {
        SignInContext signInContext = new SignInContext();
        signInContext.setRegistrationLink(registrationLinkFactory.create());
        if (userCookieValueProvider.isStudent(request)) {
            signInContext.setLoginTeacherLink(loginTeacherLinkFactory.create());
        }
        if (userCookieValueProvider.isTeacher(request)) {
            signInContext.setLoginStudentLink(loginStudentLinkFactory.create());
        }
        return signInContext;
    }
}
