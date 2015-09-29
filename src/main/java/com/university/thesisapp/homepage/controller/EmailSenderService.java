package com.university.thesisapp.homepage.controller;

import com.university.thesisapp.dao.persistence.dao.ThesisUserDao;
import com.university.thesisapp.dao.persistence.model.Comment;
import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.dao.persistence.model.ThesisStudent;
import com.university.thesisapp.dao.persistence.model.ThesisUser;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Gábor on 2015.09.26..
 */
@Component
public class EmailSenderService {
    @Autowired
    private EmailSenderDao emailSenderDao;
    @Autowired
    private ThesisUserDao thesisUserDao;

    public void sendMailAfterComment(Comment comment) {
        String subject = getSubject(comment);
        String text = getSubject(comment) + "\n\n" + comment.getCommentMessage();
        sendAllForThesis(comment.getThesis(), subject, text);
    }

    private String getSubject(Comment comment) {
        return "ThesisApp: " + comment.getThesisUser().getName() + " commented on - " + comment.getThesis().getTitleEn();
    }

    public void sendMailAfterRegistration(String email, HttpServletRequest request) {
        String subject = "ThesisApp: registration confirmation mail";
        ThesisUser thesisUser = thesisUserDao.getThesisUserByEmail(email);
        String text = request.getHeader("origin") + UrlProvider.CREATE_ACCOUNT_URL + "?verification=" + thesisUser.getVerificationToken();
        emailSenderDao.sendMail(email, subject, text);
    }

    public void sendMailAfterSentStudentRequest(ThesisStudent thesisStudent, Thesis thesis) {
        String email = thesis.getThesisTeacher().getThesisUser().getEmail();
        String subject = "ThesisApp: Student join-in request is being arrived";
        String text = thesisStudent.getThesisUser().getName() + " (" + thesisStudent.getNeptunCode() + ") sent join-in request for: " + thesis.getTitleEn();
        emailSenderDao.sendMail(email, subject, text);
    }

    public void sendMailAfterCancelledStudentRequest(ThesisStudent thesisStudent, Thesis thesis) {
        String email = thesis.getThesisTeacher().getThesisUser().getEmail();
        String subject = "ThesisApp: Student join-in request is being cancelled";
        String text = thesisStudent.getThesisUser().getName() + " (" + thesisStudent.getNeptunCode() + ") cancelled join-in request for: " + thesis.getTitleEn();
        emailSenderDao.sendMail(email, subject, text);
    }

    public void sendMailAfterAcceptedThesis(Thesis thesis) {
        String subject = "ThesisApp: " + thesis.getTitleEn() + " has been closed.";
        String text = thesis.getTitleEn() + " has been ACCEPTED by " + thesis.getThesisTeacher().getThesisUser().getName();
        sendAllForThesis(thesis, subject, text);
    }

    public void sendMailAfterDeclinedThesis(Thesis thesis) {
        String subject = "ThesisApp: " + thesis.getTitleEn() + " has been closed.";
        String text = thesis.getTitleEn() + " has been DECLINED by " + thesis.getThesisTeacher().getThesisUser().getName();
        sendAllForThesis(thesis, subject, text);
    }

    private void sendAllForThesis(Thesis thesis, String subject, String text) {
        List<ThesisStudent> thesisStudents = thesis.getThesisStudents();
        for (ThesisStudent thesisStudent : thesisStudents) {
            emailSenderDao.sendMail(thesisStudent.getThesisUser().getEmail(), subject, text);
        }
        emailSenderDao.sendMail(thesis.getThesisTeacher().getThesisUser().getEmail(), subject, text);
    }
}
