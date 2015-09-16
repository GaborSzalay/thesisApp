package com.university.thesisapp.dao.persistence.model;

/**
 * Created by Gábor on 2015.09.14..
 */
public enum StudentRequestState {
    NEW("NEW"),
    SENT("SENT"),
    CANCELED("CANCELED"),
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
