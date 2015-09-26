package com.university.thesisapp.homepage.controller;

import com.university.thesisapp.createaccount.context.CreateAccountContext;
import com.university.thesisapp.dao.persistence.dao.ThesisUserDao;
import com.university.thesisapp.dao.persistence.model.Comment;
import com.university.thesisapp.dao.persistence.model.ThesisStudent;
import com.university.thesisapp.dao.persistence.model.ThesisUser;
import com.university.thesisapp.web.provider.UrlProvider;
import org.slf4j.LoggerFactory;
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
    EmailSenderDao emailSenderDao;
    @Autowired
    ThesisUserDao thesisUserDao;

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

    public void sendMailAfterRegistration(CreateAccountContext createAccountContext, HttpServletRequest request) {
        String subject = "ThesisApp: registration confirmation mail";
        ThesisUser thesisUser = thesisUserDao.getThesisUserByEmail(createAccountContext.getEmail());
        String text = request.getHeader("origin") + UrlProvider.CREATE_ACCOUNT_URL + "?verification=" + thesisUser.getVerificationToken();
        emailSenderDao.sendMail(createAccountContext.getEmail(), subject, text);
    }
}
