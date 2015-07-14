package com.university.thesisapp.student.factory;

import com.university.thesisapp.student.model.StudentHomeContext;
import com.university.thesisapp.web.messages.WelcomeMessagefactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.15..
 */
@Component
public class StudentHomeContextFactory {
    @Autowired
    private WelcomeMessagefactory welcomeMessagefactory;

    public StudentHomeContext create(HttpServletRequest request) {
        StudentHomeContext studentHomeContext = new StudentHomeContext();
        studentHomeContext.setWelcomeMessage(welcomeMessagefactory.create());
        return studentHomeContext;
    }
}
