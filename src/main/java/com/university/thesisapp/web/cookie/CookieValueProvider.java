package com.university.thesisapp.web.cookie;

import com.university.thesisapp.util.Validation;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Gábor on 2015.07.15..
 */
@Component
public class CookieValueProvider {
    public Cookie findCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        Cookie resultCookie = null;
        if (Validation.notEmpty(cookies)) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    resultCookie = cookie;
                }
            }
        }
        return resultCookie;
    }

    public void createCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        response.addCookie(cookie);
    }
}
