package com.university.thesisapp.signin.factory;

import com.university.thesisapp.homepage.factory.RegistrationLinkFactory;
import com.university.thesisapp.signin.model.SignInContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.15..
 */
@Component
public class SignInContextFactory {
    @Autowired
    private RegistrationLinkFactory registrationLinkFactory;


    public SignInContext create(HttpServletRequest request) {
        SignInContext signInContext = new SignInContext();
        signInContext.setRegistrationLink(registrationLinkFactory.create());
        return signInContext;
    }
}
