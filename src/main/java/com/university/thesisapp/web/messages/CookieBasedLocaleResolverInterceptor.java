package com.university.thesisapp.web.messages;

import com.university.thesisapp.util.Validation;
import com.university.thesisapp.web.cookie.CookieValueProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Gábor on 2015.09.12..
 */
public class CookieBasedLocaleResolverInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(CookieBasedLocaleResolverInterceptor.class);
    private String paramName;

    @Autowired
    CookieValueProvider cookieValueProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String newLocale = request.getParameter(paramName);
        if (Validation.notEmpty(newLocale)) {
            LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
            localeResolver.setLocale(request, response, StringUtils.parseLocaleString(newLocale));
            cookieValueProvider.createCookie(response, paramName, newLocale);
        } else {
            Cookie localeCookie = cookieValueProvider.findCookie(request, paramName);
            if (Validation.notEmpty(localeCookie)) {
                LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
                localeResolver.setLocale(request, response, StringUtils.parseLocaleString(localeCookie.getValue()));
            }
        }
        return true;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }
}
