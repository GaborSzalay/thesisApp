package com.university.thesisapp.homepage.factory;

import com.university.thesisapp.ThesisAuthority;
import com.university.thesisapp.web.links.ThesisLink;
import com.university.thesisapp.web.messages.Message;
import com.university.thesisapp.web.url.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.07.11..
 */
@Component
public class LoginStudentLinkFactory {

    private static final String MESSAGES_HOMEPAGE_LOGIN_STUDENT = "messages.homepage.login.student";
    @Autowired
    private UrlProvider urlProvider;

    public ThesisLink create() {
        ThesisLink link = new ThesisLink();
        link.setUrl(getUrl());
        link.setMessage(new Message(MESSAGES_HOMEPAGE_LOGIN_STUDENT));
        return link;
    }

    private String getUrl() {
        return ThesisAuthority.STUDENT.getUrl() + urlProvider.getIndexUrl();
    }
}
