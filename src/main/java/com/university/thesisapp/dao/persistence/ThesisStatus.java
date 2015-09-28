package com.university.thesisapp.dao.persistence;

/**
 * Created by Gábor on 2015.09.28..
 */
public enum ThesisStatus {
    NEW("NEW"),
    IN_PROGRESS("IN_PROGRESS"),
    ACCEPTED("ACCEPTED"),
    DECLINED("DECLINED");

    private String type;

    ThesisStatus(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
