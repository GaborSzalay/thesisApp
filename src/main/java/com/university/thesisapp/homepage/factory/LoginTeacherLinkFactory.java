package com.university.thesisapp.homepage.factory;

import com.university.thesisapp.web.links.ThesisLink;
import com.university.thesisapp.web.messages.Message;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.07.11..
 */
@Component
public class LoginTeacherLinkFactory {

    private static final String MESSAGES_HOMEPAGE_LOGIN_TEACHER = "messages.homepage.login.teacher";


    public ThesisLink create() {
        ThesisLink link = new ThesisLink();
        link.setUrl(getUrl());
        link.setMessage(new Message(MESSAGES_HOMEPAGE_LOGIN_TEACHER));
        return link;
    }

    private String getUrl() {
        return UrlProvider.TEACHER_PREFIX + UrlProvider.INDEX_URL;
    }
}
