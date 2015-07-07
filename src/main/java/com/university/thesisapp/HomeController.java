package com.university.thesisapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.university.thesisapp.dao.persistence.model.ThesisUser;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jcg-JPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        ThesisUser thesisUser = new ThesisUser();
        thesisUser.setName("testName");
        em.persist(thesisUser);
        em.getTransaction().commit();
        return "home";
    }

}
