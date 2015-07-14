package com.university.thesisapp.student.model;

import com.university.thesisapp.web.messages.Message;

/**
 * Created by Gábor on 2015.07.15..
 */
public class StudentHomeContext {
    private Message welcomeMessage;

    public Message getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(Message welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }
}
