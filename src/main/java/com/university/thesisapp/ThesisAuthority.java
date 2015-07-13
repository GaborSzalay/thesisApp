package com.university.thesisapp;

/**
 * Created by Gábor on 2015.07.11..
 */
public enum ThesisAuthority {
    ADMIN("ROLE_ADMIN"),
    TEACHER("ROLE_TEACHER"),
    STUDENT("ROLE_STUDENT");

    private final String roleName;

    ThesisAuthority(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

}
