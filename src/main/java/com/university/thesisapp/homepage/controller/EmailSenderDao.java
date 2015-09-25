package com.university.thesisapp.homepage.controller;

import com.sun.mail.smtp.SMTPTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Gábor on 2015.09.26..
 */
@Component
public class EmailSenderDao {

    public static final Logger LOGGER = LoggerFactory.getLogger(EmailSenderDao.class);

    public void sendMail(String email, String subject, String text) {
        Properties props = System.getProperties();
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.auth", "true");
        Session session = Session.getInstance(props, null);
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("thesisapp1@gmail.com"));
            ;
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email, false));
            msg.setSubject(subject);
            msg.setText(text);
            msg.setHeader("X-Mailer", "Thesis App");
            msg.setSentDate(new Date());
            SMTPTransport t =
                    (SMTPTransport) session.getTransport("smtps");
            t.connect("smtp.gmail.com", "thesisapp1@gmail.com", "32C15d5dcf");
            t.sendMessage(msg, msg.getAllRecipients());
            LOGGER.debug("Email sent with the response: {}" + t.getLastServerResponse());
            t.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
