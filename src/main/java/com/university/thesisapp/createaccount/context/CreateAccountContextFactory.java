package com.university.thesisapp.createaccount.context;

import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.13..
 */
@Component
public class CreateAccountContextFactory {

    public CreateAccountContext create(HttpServletRequest request) {
        CreateAccountContext createAccountContext = new CreateAccountContext();
        createAccountContext.setHomePageUrl(UrlProvider.HOME_PAGE_URL);
        createAccountContext.setUserName(request.getParameter("username"));
        createAccountContext.setPassword(request.getParameter("password"));
        createAccountContext.setAuthority(request.getParameter("authority"));
        return createAccountContext;
    }


}
