package com.university.thesisapp.createaccount.controller;

import com.university.thesisapp.dao.persistence.model.ThesisUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.07..
 */
@Controller
public class CreateAccountController {
    @RequestMapping(value = "/create_account.html", method = RequestMethod.POST)
    public ModelAndView createAccount(HttpServletRequest request, Model model) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jcg-JPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        ThesisUser thesisUser = new ThesisUser();
        thesisUser.setFirstName(request.getParameter("firstname"));
        thesisUser.setLastName(request.getParameter("lastname"));
        em.persist(thesisUser);
        em.getTransaction().commit();

        return new ModelAndView("home", model.asMap());
    }
}
