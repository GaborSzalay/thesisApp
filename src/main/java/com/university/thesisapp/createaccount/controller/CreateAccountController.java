package com.university.thesisapp.createaccount.controller;

import com.university.thesisapp.dao.persistence.model.ThesisUser;
import com.university.thesisapp.web.url.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.07..
 */
@Controller
public class CreateAccountController {

    @Autowired
    UrlProvider urlProvider;

    @RequestMapping(value = "/create_account.html", method = RequestMethod.POST)
    public ModelAndView createAccount(HttpServletRequest request, Model model) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jcg-JPA");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        ThesisUser thesisUser = new ThesisUser();
        thesisUser.setUserName(request.getParameter("username"));
        thesisUser.setPassword(request.getParameter("password"));
        thesisUser.setAuthority(request.getParameter("authority"));
        entityManager.persist(thesisUser);
        entityManager.getTransaction().commit();
        View view = new RedirectView(urlProvider.getHomePageUrl());

        return new ModelAndView(view, model.asMap());
    }
}
