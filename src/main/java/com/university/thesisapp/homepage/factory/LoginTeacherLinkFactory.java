package com.university.thesisapp.homepage.factory;

import com.university.thesisapp.ThesisAuthority;
import com.university.thesisapp.web.links.ThesisLink;
import com.university.thesisapp.web.url.ThesisUrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.07.11..
 */
@Component
public class LoginTeacherLinkFactory {

    private static final String MESSAGES_HOMEPAGE_LOGIN_TEACHER = "messages.homepage.login.teacher";
    @Autowired
    private ThesisUrlProvider thesisUrlProvider;

    public ThesisLink create() {
        ThesisLink link = new ThesisLink();
        link.setUrl(getUrl());
        link.setMessageKey(MESSAGES_HOMEPAGE_LOGIN_TEACHER);
        return link;
    }

    private String getUrl() {
        return ThesisAuthority.TEACHER.getUrl() + thesisUrlProvider.getIndexUrl();
    }
}
