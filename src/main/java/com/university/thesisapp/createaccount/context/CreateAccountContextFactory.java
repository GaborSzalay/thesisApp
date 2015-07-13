package com.university.thesisapp.createaccount.context;

import com.university.thesisapp.web.url.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.13..
 */
@Component
public class CreateAccountContextFactory {
    @Autowired
    UrlProvider urlProvider;

    public CreateAccountContext create(HttpServletRequest request) {
        CreateAccountContext createAccountContext = new CreateAccountContext();
        createAccountContext.setHomePageUrl(urlProvider.getHomePageUrl());
        createAccountContext.setUserName(request.getParameter("username"));
        String password = request.getParameter("password");
        createAccountContext.setPassword(getHashedPassword(password));
        createAccountContext.setAuthority(request.getParameter("authority"));
        return createAccountContext;
    }

    private String getHashedPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
