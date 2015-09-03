package com.university.thesisapp.createaccount.context;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.13..
 */
@Component
public class CreateAccountContextFactory {

    public CreateAccountContext create(HttpServletRequest request) {
        CreateAccountContext createAccountContext = new CreateAccountContext();
        String email = request.getParameter("email");
        createAccountContext.setEmail(email);
        request.getSession().setAttribute("email", email);
        createAccountContext.setPassword(request.getParameter("password"));
        return createAccountContext;
    }


}
