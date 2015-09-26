package com.university.thesisapp.signin.context;

import com.university.thesisapp.dao.persistence.service.AuthenticationErrorType;
import com.university.thesisapp.util.Validation;
import com.university.thesisapp.web.provider.UrlProvider;
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
    private static final String ACCESS_DENIED = "accessDenied";
    private static final String EXPIRED_SESSION = "expiredSession";
    private static final String ACTIVATED = "activated";
    private static final String EXISTING = "existing";


    public SignInContext create(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SignInContext signInContext = new SignInContext();
        signInContext.setRegistrationLink(UrlProvider.REGISTRATION_URL);
        String state = request.getParameter(STATE);
        if (Validation.notEmpty(state)) {
            if (ERROR.equals(state)) {
                Object errorType = session.getAttribute(AuthenticationErrorType.DISABLED.getKey());
                if (Validation.notEmpty(errorType) && errorType instanceof String) {
                    if (errorType.equals(AuthenticationErrorType.DISABLED.getValue())) {
                        signInContext.setShowUserDisabledMessage(true);
                    } else {
                        signInContext.setShowErrorMessage(true);
                    }
                    session.removeAttribute(AuthenticationErrorType.DISABLED.getKey());
                }
            } else if (LOGOUT.equals(state)) {
                signInContext.setShowLogoutMessage(true);
            } else if (CREATED.equals(state)) {
                Object emailAttribute = session.getAttribute(EMAIL);
                if (emailAttribute instanceof String) {
                    signInContext.setCreatedEmail((String) emailAttribute);
                    session.removeAttribute(EMAIL);
                }
            } else if (ACCESS_DENIED.equals(state)) {
                signInContext.setShowAccessDeniedMessage(true);
            } else if (EXPIRED_SESSION.equals(state)) {
                signInContext.setShowExpiredSessionMessage(true);
            } else if (ACTIVATED.equals(state)) {
                Object emailAttribute = session.getAttribute(EMAIL);
                if (emailAttribute instanceof String) {
                    signInContext.setActivatedEmail((String) emailAttribute);
                    session.removeAttribute(EMAIL);
                }
            } else if (EXISTING.equals(state)) {
                signInContext.setShowExistingEmailMessage(true);
            }
        }
        return signInContext;
    }
}
