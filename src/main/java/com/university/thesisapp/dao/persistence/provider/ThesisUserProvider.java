package com.university.thesisapp.dao.persistence.provider;

import com.university.thesisapp.dao.persistence.dao.ThesisUserDao;
import com.university.thesisapp.dao.persistence.model.ThesisUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.07.27..
 */
@Component
public class ThesisUserProvider {
    @Autowired
    private ThesisUserDao thesisUserDao;

    public ThesisUser getSignedInUser() {
        ThesisUser thesisUser = null;
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        String email = auth.getName();
        return thesisUserDao.getThesisUserByEmail(email);
    }
}
