package com.university.thesisapp.homepage.model;

import com.university.thesisapp.web.links.ThesisLink;

/**
 * Created by Gábor on 2015.07.11..
 */
public class HomeContext {
    private ThesisLink registrationLink;
    private ThesisLink loginStudentLink;
    private ThesisLink loginTeacherLink;

    public ThesisLink getRegistrationLink() {
        return registrationLink;
    }

    public void setRegistrationLink(ThesisLink registrationLink) {
        this.registrationLink = registrationLink;
    }

    public ThesisLink getLoginStudentLink() {
        return loginStudentLink;
    }

    public void setLoginStudentLink(ThesisLink loginStudentLink) {
        this.loginStudentLink = loginStudentLink;
    }

    public ThesisLink getLoginTeacherLink() {
        return loginTeacherLink;
    }

    public void setLoginTeacherLink(ThesisLink loginTeacherLink) {
        this.loginTeacherLink = loginTeacherLink;
    }
}
