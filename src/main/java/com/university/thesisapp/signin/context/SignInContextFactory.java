package com.university.thesisapp.signin.context;

import com.university.thesisapp.homepage.factory.RegistrationLinkFactory;
import com.university.thesisapp.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Gábor on 2015.07.15..
 */
@Component
public class SignInContextFactory {
    private static final String STATE = "state";
    private static final String ERROR = "error";
    private static final String LOGOUT = "logout";
    private static final String CREATED = "created";
    private static final String EMAIL = "email";
    @Autowired
    private RegistrationLinkFactory registrationLinkFactory;


    public SignInContext create(HttpServletRequest request) {
        SignInContext signInContext = new SignInContext();
        signInContext.setRegistrationLink(registrationLinkFactory.create());
        String state = request.getParameter(STATE);
        if (Validation.notEmpty(state)) {
            if (ERROR.equals(state)) {
                signInContext.setShowErrorMessage(true);
            } else if (LOGOUT.equals(state)) {
                signInContext.setShowLogoutMessage(true);
            } else if (CREATED.equals(state)) {
                HttpSession session = request.getSession();
                Object emailAttribute = session.getAttribute(EMAIL);
                if (emailAttribute instanceof String) {
                    signInContext.setCreatedEmail((String) emailAttribute);
                    session.removeAttribute(EMAIL);
                }
            }
        }
        return signInContext;
    }
}
