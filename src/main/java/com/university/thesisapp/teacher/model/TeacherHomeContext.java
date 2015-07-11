package com.university.thesisapp.teacher.model;

import com.university.thesisapp.web.messages.Message;

/**
 * Created by Gábor on 2015.07.11..
 */
public class TeacherHomeContext {
    private Message welcomeMessage;

    public Message getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(Message welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }
}
