package com.university.thesisapp.signin.context;

import com.university.thesisapp.web.links.ThesisLink;

/**
 * Created by Gábor on 2015.07.15..
 */
public class SignInContext {
    private ThesisLink registrationLink;
    private boolean showErrorMessage;
    private boolean showLogoutMessage;

    public ThesisLink getRegistrationLink() {
        return registrationLink;
    }

    public void setRegistrationLink(ThesisLink registrationLink) {
        this.registrationLink = registrationLink;
    }

    public boolean isShowErrorMessage() {
        return showErrorMessage;
    }

    public void setShowErrorMessage(boolean showErrorMessage) {
        this.showErrorMessage = showErrorMessage;
    }

    public boolean isShowLogoutMessage() {
        return showLogoutMessage;
    }

    public void setShowLogoutMessage(boolean showLogoutMessage) {
        this.showLogoutMessage = showLogoutMessage;
    }
}
