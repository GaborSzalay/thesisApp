package com.university.thesisapp.homepage.controller;

import com.sun.mail.smtp.SMTPTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Gábor on 2015.09.26..
 */
@Component
public class GmailEmailSenderDao implements EmailSenderDao {

    public static final Logger LOGGER = LoggerFactory.getLogger(GmailEmailSenderDao.class);

    @Override
    public void sendMail(String email, String subject, String text) {
        Session session = createSession();
        try {
            Message message = createMessage(email, subject, text, session);
            doSendMail(session, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doSendMail(Session session, Message message) throws MessagingException {
        SMTPTransport smtpTransport =
                (SMTPTransport) session.getTransport("smtps");
        smtpTransport.connect("smtp.gmail.com", "thesisapp1@gmail.com", "32C15d5dcf");
        smtpTransport.sendMessage(message, message.getAllRecipients());
        LOGGER.debug("Email sent with the response: {}" + smtpTransport.getLastServerResponse());
        smtpTransport.close();
    }

    private Session createSession() {
        Properties props = System.getProperties();
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.auth", "true");
        return Session.getInstance(props, null);
    }

    private Message createMessage(String email, String subject, String text, Session session) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("thesisapp1@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email, false));
        message.setSubject(subject);
        message.setText(text);
        message.setHeader("X-Mailer", "Thesis App");
        message.setSentDate(new Date());
        return message;
    }
}
