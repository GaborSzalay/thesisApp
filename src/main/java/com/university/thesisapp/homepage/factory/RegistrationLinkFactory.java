package com.university.thesisapp.homepage.factory;

import com.university.thesisapp.web.links.ThesisLink;
import com.university.thesisapp.web.messages.Message;
import com.university.thesisapp.web.url.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.07.11..
 */
@Component
public class RegistrationLinkFactory {

    private static final String MESSAGES_HOMEPAGE_REGISTER = "messages.homepage.register";
    @Autowired
    private UrlProvider urlProvider;

    public ThesisLink create() {
        ThesisLink link = new ThesisLink();
        link.setMessage(new Message(MESSAGES_HOMEPAGE_REGISTER));
        link.setUrl(urlProvider.getRegistrationUrl());
        return link;
    }
}
