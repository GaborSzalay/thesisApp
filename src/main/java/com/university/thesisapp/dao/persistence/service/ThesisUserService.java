package com.university.thesisapp.dao.persistence.service;

import com.university.thesisapp.dao.persistence.dao.ThesisUserDao;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gábor on 2015.07.13..
 */
public class ThesisUserService implements UserDetailsService {

    public static final Logger LOGGER = LoggerFactory.getLogger(ThesisUserService.class);
    private ThesisUser superUser;
    private ThesisUserDao thesisUserDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ThesisUser thesisUser = null;
        if (superUser.getEmail().equals(email)) {
            thesisUser = thesisUserDao.getThesisUserByEmail(email);
            if (Validation.empty(thesisUser)) {
                thesisUser = thesisUserDao.createThesisUser(superUser.getEmail(), superUser.getPassword(), superUser.getAuthority(), superUser.getName());
            }
        } else {
            thesisUser = thesisUserDao.getThesisUserByEmail(email);
        }

        if (Validation.empty(thesisUser) || !thesisUser.isEnabled()) {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            if (Validation.empty(thesisUser)) {
                request.getSession().setAttribute(AuthenticationErrorType.NOT_FOUND.getKey(), AuthenticationErrorType.NOT_FOUND.getValue());
            } else {
                request.getSession().setAttribute(AuthenticationErrorType.DISABLED.getKey(), AuthenticationErrorType.DISABLED.getValue());
            }
            throw new UsernameNotFoundException("User not found: " + email);
        }
        User user = new User(thesisUser.getEmail(), thesisUser.getPassword(), true, true, true, true, getGrantedAuthorities(thesisUser));
        return user;
    }

    private List<GrantedAuthority> getGrantedAuthorities(ThesisUser thesisUser) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(thesisUser.getAuthority()));
        return authorities;
    }

    public void setSuperUser(ThesisUser superUser) {
        this.superUser = superUser;
    }

    public void setThesisUserDao(ThesisUserDao thesisUserDao) {
        this.thesisUserDao = thesisUserDao;
    }
}
