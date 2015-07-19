package com.university.thesisapp.signin.model;

import com.university.thesisapp.web.links.ThesisLink;

/**
 * Created by Gábor on 2015.07.15..
 */
public class SignInContext {
    private ThesisLink registrationLink;


    public ThesisLink getRegistrationLink() {
        return registrationLink;
    }

    public void setRegistrationLink(ThesisLink registrationLink) {
        this.registrationLink = registrationLink;
    }

}
