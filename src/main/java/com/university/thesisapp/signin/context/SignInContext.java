package com.university.thesisapp.signin.context;

/**
 * Created by Gábor on 2015.07.15..
 */
public class SignInContext {
    private String registrationLink;
    private boolean showErrorMessage;
    private boolean showLogoutMessage;
    private boolean showAccessDeniedMessage;
    private boolean showExpiredSessionMessage;
    private String createdEmail;
    private boolean showUserDisabledMessage;
    private String activatedEmail;
    private boolean showExistingEmailMessage;

    public String getRegistrationLink() {
        return registrationLink;
    }

    public void setRegistrationLink(String registrationLink) {
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


    public String getCreatedEmail() {
        return createdEmail;
    }

    public void setCreatedEmail(String createdEmail) {
        this.createdEmail = createdEmail;
    }

    public boolean isShowAccessDeniedMessage() {
        return showAccessDeniedMessage;
    }

    public void setShowAccessDeniedMessage(boolean showAccessDeniedMessage) {
        this.showAccessDeniedMessage = showAccessDeniedMessage;
    }

    public boolean isShowExpiredSessionMessage() {
        return showExpiredSessionMessage;
    }

    public void setShowExpiredSessionMessage(boolean showExpiredSessionMessage) {
        this.showExpiredSessionMessage = showExpiredSessionMessage;
    }

    public void setShowUserDisabledMessage(boolean showUserDisabledMessage) {
        this.showUserDisabledMessage = showUserDisabledMessage;
    }

    public boolean isShowUserDisabledMessage() {
        return showUserDisabledMessage;
    }

    public void setActivatedEmail(String activatedEmail) {
        this.activatedEmail = activatedEmail;
    }

    public String getActivatedEmail() {
        return activatedEmail;
    }

    public void setShowExistingEmailMessage(boolean showExistingEmailMessage) {
        this.showExistingEmailMessage = showExistingEmailMessage;
    }

    public boolean isShowExistingEmailMessage() {
        return showExistingEmailMessage;
    }
}
