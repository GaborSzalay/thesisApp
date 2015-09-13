package com.university.thesisapp.dao.persistence.model;

/**
 * Created by Gábor on 2015.09.14..
 */
public enum StudentRequestState {
    SENT("SENT"),
    DECLINED("DECLINED"),
    ACCEPTED("ACCEPTED");

    private final String state;

    StudentRequestState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
