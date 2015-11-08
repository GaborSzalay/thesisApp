package com.university.thesisapp.homepage.controller;

/**
 * Created by Gábor on 2015.11.08..
 */
public interface EmailSenderDao {
    void sendMail(String email, String subject, String text);
}
