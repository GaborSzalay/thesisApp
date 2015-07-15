package com.university.thesisapp.web.cookie;

import com.university.thesisapp.ThesisAuthority;
import com.university.thesisapp.util.Validation;
import com.university.thesisapp.web.provider.CookieProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.15..
 */
@Component
public class UserCookieValueProvider {
    @Autowired
    private CookieValueProvider cookieValueProvider;

    public boolean isTeacher(HttpServletRequest request) {
        boolean teacher = false;
        Cookie userCookie = cookieValueProvider.findCookie(request, CookieProvider.USER);
        if (Validation.notEmpty(userCookie)) {
            if (ThesisAuthority.TEACHER.toString().equals(userCookie.getValue())) {
                teacher = true;
            }
        }
        return teacher;
    }

    public boolean isStudent(HttpServletRequest request) {
        boolean student = false;
        Cookie userCookie = cookieValueProvider.findCookie(request, CookieProvider.USER);
        if (Validation.notEmpty(userCookie)) {
            if (ThesisAuthority.STUDENT.toString().equals(userCookie.getValue())) {
                student = true;
            }
        }
        return student;
    }
}
