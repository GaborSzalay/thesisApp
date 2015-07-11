package com.university.thesisapp;

/**
 * Created by Gábor on 2015.07.11..
 */
public enum ThesisAuthority {
    ADMIN("ROLE_ADMIN", "/admin"),
    TEACHER("ROLE_TEACHER", "/teacher"),
    STUDENT("ROLE_STUDENT", "/student");

    private final String roleName;
    private final String url;

    ThesisAuthority(String roleName, String url) {
        this.roleName = roleName;
        this.url = url;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getUrl() {
        return url;
    }
}
