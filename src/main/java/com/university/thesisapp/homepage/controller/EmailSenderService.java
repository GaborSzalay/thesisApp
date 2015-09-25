package com.university.thesisapp.homepage.controller;

import com.university.thesisapp.dao.persistence.model.Comment;
import com.university.thesisapp.dao.persistence.model.ThesisStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Gábor on 2015.09.26..
 */
@Component
public class EmailSenderService {
    @Autowired
    EmailSenderDao emailSenderDao;

    public void sendMailAfterComment(Comment comment) {
        String subject = getSubject(comment);
        String text = getSubject(comment) + "\n\n" + comment.getCommentMessage();
        List<ThesisStudent> thesisStudents = comment.getThesis().getThesisStudents();
        for (ThesisStudent thesisStudent : thesisStudents) {
            emailSenderDao.sendMail(thesisStudent.getThesisUser().getEmail(), subject, text);
        }
        emailSenderDao.sendMail(comment.getThesis().getThesisTeacher().getThesisUser().getEmail(), subject, text);
    }

    private String getSubject(Comment comment) {
        return "ThesisApp: " + comment.getThesisUser().getName() + " commented on - " + comment.getThesis().getTitleEn();
    }
}
