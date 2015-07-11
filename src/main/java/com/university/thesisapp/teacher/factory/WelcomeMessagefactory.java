package com.university.thesisapp.teacher.factory;

import com.university.thesisapp.web.messages.Message;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gábor on 2015.07.11..
 */
@Component
public class WelcomeMessagefactory {
    private static final String MESSAGE_TEACHER_HOME_WELCOME = "message.teacher.home.welcome";

    public Message create() {
        Message welcomeMessage = new Message(MESSAGE_TEACHER_HOME_WELCOME);
        welcomeMessage.setArgs(getWelcomeMessageArgs());
        return welcomeMessage;
    }

    private List<String> getWelcomeMessageArgs() {
        List<String> params = new ArrayList<String>();
        params.add(getUserName());
        return params;
    }

    private String getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
