package com.university.thesisapp.teacher.factory;

import com.university.thesisapp.teacher.model.TeacherHomeContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.11..
 */
@Component
public class TeacherHomeContextFactory {
    public TeacherHomeContext create(HttpServletRequest request) {
        TeacherHomeContext teacherHomeContext = new TeacherHomeContext();
        teacherHomeContext.setWelcomeMessage("message.teacher.home.welcome");
        return teacherHomeContext;
    }
}
