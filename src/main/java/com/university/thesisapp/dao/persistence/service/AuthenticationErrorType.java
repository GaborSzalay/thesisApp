package com.university.thesisapp.dao.persistence.service;

/**
 * Created by Gábor on 2015.09.26..
 */
public enum AuthenticationErrorType {
    DISABLED("disabledUser"),
    NOT_FOUND("userNotFound");

    private String key = "currentAuthenticationError";
    private String value;

    AuthenticationErrorType(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
