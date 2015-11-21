package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.ThesisAuthority;
import com.university.thesisapp.dao.persistence.model.ThesisUser;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import com.university.thesisapp.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Gábor on 2015.07.13..
 */
@Service("thesisUserDao")
public class ThesisUserDao {
    @Autowired
    private EntityManagerProvider entityManagerProvider;

    public ThesisUser getThesisUserById(EntityManagerParams entityManagerParams, long id) {
        ThesisUser thesisUser = entityManagerParams.getEntityManager().find(ThesisUser.class, id);
        return thesisUser;
    }

    public ThesisUser getThesisUserById(long id) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisUser thesisUser = getThesisUserById(entityManagerParams, id);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return thesisUser;
    }

    public ThesisUser getThesisUserByEmail(String email) {
        Iterator<ThesisUser> thesisUserIterator = getAllThesisUsers().iterator();
        ThesisUser thesisUser = null;
        while (thesisUserIterator.hasNext() && Validation.empty(thesisUser)) {
            ThesisUser currentThesisUser = thesisUserIterator.next();
            if (email.equals(currentThesisUser.getEmail())) {
                thesisUser = currentThesisUser;
            }
        }
        return thesisUser;
    }

    public List<ThesisUser> getThesisUsersByAuthority(ThesisAuthority thesisAuthority) {
        List<ThesisUser> thesisUsers = getAllThesisUsers();
        List<ThesisUser> thesisUsersWithAuthority = new ArrayList<ThesisUser>();
        for (ThesisUser thesisUser : thesisUsers) {
            if (thesisAuthority.getRoleName().equals(thesisUser.getAuthority())) {
                thesisUsersWithAuthority.add(thesisUser);
            }
        }
        return thesisUsersWithAuthority;
    }

    public List<ThesisUser> getAllThesisUsers() {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        List<ThesisUser> thesisUsers = entityManagerParams.getEntityManager().createQuery("SELECT t FROM ThesisUser t", ThesisUser.class).getResultList();
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return thesisUsers;
    }

    public ThesisUser createThesisUser(EntityManagerParams entityManagerParams, String email, String password, String authority, String name) {
        ThesisUser thesisUser = new ThesisUser();
        thesisUser.setEmail(email);
        thesisUser.setPassword(getHashedPassword(password));
        thesisUser.setAuthority(authority);
        thesisUser.setRegistrationDate(new Date());
        thesisUser.setName(name);
        thesisUser.setEnabled(false);
        thesisUser.setVerificationToken(new BigInteger(130, new SecureRandom()).toString(32));
        entityManagerParams.getEntityManager().persist(thesisUser);
        return thesisUser;
    }

    public ThesisUser createThesisUser(String email, String password, String authority, String name) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisUser thesisUser = createThesisUser(entityManagerParams, email, password, authority, name);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return thesisUser;
    }

    public ThesisUser createStudent(String email, String password, String name) {
        return createThesisUser(email, password, ThesisAuthority.STUDENT.getRoleName(), name);
    }

    private String getHashedPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public ThesisUser enableUserByToken(String token) {
        ThesisUser resultThesisUser = null;
        List<ThesisUser> allThesisUsers = getAllThesisUsers();
        for (ThesisUser thesisUser : allThesisUsers) {
            if (thesisUser.getVerificationToken().equals(token) && !thesisUser.getEnabled()) {
                enableUser(thesisUser);
                resultThesisUser = thesisUser;
            }
        }
        return resultThesisUser;
    }

    public void enableUserByEmail(String email) {
        List<ThesisUser> allThesisUsers = getAllThesisUsers();
        for (ThesisUser thesisUser : allThesisUsers) {
            if (thesisUser.getEmail().equals(email)) {
                enableUser(thesisUser);
            }
        }
    }

    public boolean isRegistrationEnabled(String email) {
        boolean registrationEnabled = true;
        List<ThesisUser> allThesisUsers = getAllThesisUsers();
        for (ThesisUser thesisUser : allThesisUsers) {
            if (thesisUser.getEmail().equals(email)) {
                registrationEnabled = false;
            }
        }
        return registrationEnabled;
    }

    private void enableUser(ThesisUser thesisUser) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        ThesisUser user = getThesisUserById(entityManagerParams, thesisUser.getThesisUserId());
        user.setEnabled(true);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
    }

    public void setEntityManagerProvider(EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

}
