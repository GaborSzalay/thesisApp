package com.university.thesisapp.web.links;

import com.university.thesisapp.web.messages.Message;

/**
 * Created by Gábor on 2015.07.11..
 */
public class ThesisLink {
    private Message message;
    private String url;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
