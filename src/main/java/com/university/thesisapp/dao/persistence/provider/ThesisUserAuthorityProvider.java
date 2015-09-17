package com.university.thesisapp.dao.persistence.provider;

import com.university.thesisapp.ThesisAuthority;
import com.university.thesisapp.util.Validation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Gábor on 2015.07.19..
 */
@Component
public class ThesisUserAuthorityProvider {

    public boolean isStudent() {
        return hasAuthority(ThesisAuthority.STUDENT);
    }

    public boolean isTeacher() {
        return hasAuthority(ThesisAuthority.TEACHER);
    }

    public boolean isAdmin() {
        return hasAuthority(ThesisAuthority.ADMIN);
    }

    private boolean hasAuthority(ThesisAuthority thesisAuthority) {
        boolean hasAuthority = false;
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        if (Validation.notEmpty(auth)) {
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            if (Validation.notEmpty(authorities)) {
                Iterator<? extends GrantedAuthority> authorityIterator = authorities.iterator();
                while (authorityIterator.hasNext() && !hasAuthority) {
                    GrantedAuthority authority = authorityIterator.next();
                    if (thesisAuthority.getRoleName().equals(authority.getAuthority())) {
                        hasAuthority = true;
                    }
                }
            }
        }
        return hasAuthority;
    }
}
