package com.university.thesisapp.homepage.factory;

import com.university.thesisapp.web.links.ThesisLink;
import com.university.thesisapp.web.messages.Message;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.07.11..
 */
@Component
public class RegistrationLinkFactory {

    private static final String MESSAGES_HOMEPAGE_REGISTER = "messages.homepage.register";

    public ThesisLink create() {
        ThesisLink link = new ThesisLink();
        link.setMessage(new Message(MESSAGES_HOMEPAGE_REGISTER));
        link.setUrl(UrlProvider.REGISTRATION_URL);
        return link;
    }
}
