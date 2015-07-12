package com.university.thesisapp.dao.persistence.service;

import com.university.thesisapp.dao.persistence.model.ThesisUser;
import com.university.thesisapp.util.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Gábor on 2015.07.13..
 */
public class ThesisUserService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(ThesisUserService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jcg-JPA");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        List<ThesisUser> thesisUsers = entityManager.createQuery("SELECT t FROM ThesisUser t").getResultList();
        Iterator<ThesisUser> thesisUserIterator = thesisUsers.iterator();
        ThesisUser resultThesisUser = null;
        while (thesisUserIterator.hasNext() && Validation.Empty(resultThesisUser)) {
            ThesisUser currentThesisUser = thesisUserIterator.next();
            if (username.equals(currentThesisUser.getUserName())) {
                resultThesisUser = currentThesisUser;
                logger.info("User has been found with the name: " + currentThesisUser.getUserName());
            }
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close();
        if (Validation.Empty(resultThesisUser)) {
            throw new UsernameNotFoundException("User not found with the name: " + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(resultThesisUser.getAuthority()));
        User user = new User(resultThesisUser.getUserName(), resultThesisUser.getPassword(), true, true, true, true, authorities);
        return user;
    }
}
