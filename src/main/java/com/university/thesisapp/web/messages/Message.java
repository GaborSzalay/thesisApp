package com.university.thesisapp.web.messages;

import java.util.List;

/**
 * Created by Gábor on 2015.07.11..
 */
public class Message {
    private String key;
    private List<String> args;

    public Message(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }
}