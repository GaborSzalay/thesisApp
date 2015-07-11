package com.university.thesisapp.teacher.factory;

import com.university.thesisapp.teacher.model.TeacherHomeContext;
import com.university.thesisapp.web.messages.Message;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gábor on 2015.07.11..
 */
@Component
public class TeacherHomeContextFactory {

    private static final String MESSAGE_TEACHER_HOME_WELCOME = "message.teacher.home.welcome";

    public TeacherHomeContext create(HttpServletRequest request) {
        TeacherHomeContext teacherHomeContext = new TeacherHomeContext();
        Message welcomeMessage = new Message(MESSAGE_TEACHER_HOME_WELCOME);
        List<String> params = new ArrayList<String>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        params.add(userName);
        welcomeMessage.setArgs(params);
        teacherHomeContext.setWelcomeMessage(welcomeMessage);
        return teacherHomeContext;
    }
}
