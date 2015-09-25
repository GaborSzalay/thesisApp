package com.university.thesisapp.homepage.controller;

import com.google.common.primitives.Longs;
import com.sun.mail.smtp.SMTPTransport;
import com.university.thesisapp.dao.persistence.dao.CommentDao;
import com.university.thesisapp.dao.persistence.model.Comment;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Gábor on 2015.09.24..
 */
@Controller
public class CommentController {


    public static final String FROM = "szalay.gabor0@gmail.com";
    public static final String TO = "yaastreet@gmail.com";
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private CommentControllerViewResolver commentControllerViewResolver;

    @RequestMapping(value = UrlProvider.STUDENT_THESIS_CREATE_COMMENT_URL, method = RequestMethod.GET)
    public ModelAndView createComment(Model model, HttpServletRequest request) {
        String thesisIdParameter = request.getParameter("thesisId");
        String commentMessage = request.getParameter("commentMessage");
        Long thesisId = Longs.tryParse(thesisIdParameter);
        Comment comment = commentDao.createComment(commentMessage, thesisId);

        Properties props = System.getProperties();
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.auth","true");
        Session session = Session.getInstance(props, null);
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("mail@tovare.com"));
            ;
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("yaastreet@gmail.com", false));
            msg.setSubject("Heisann " + System.currentTimeMillis());
            msg.setText("proba egy ketto harom");
            msg.setHeader("X-Mailer", "Thesis App");
            msg.setSentDate(new Date());
            SMTPTransport t =
                    (SMTPTransport) session.getTransport("smtps");
            t.connect("smtp.gmail.com", "thesisapp1@gmail.com", "32C15d5dcf");
            t.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Response: " + t.getLastServerResponse());
            t.close();
        } catch (Exception e) {}
        return commentControllerViewResolver.resolveView(request);
    }
}
