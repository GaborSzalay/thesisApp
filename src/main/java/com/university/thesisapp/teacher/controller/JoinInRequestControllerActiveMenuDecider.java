package com.university.thesisapp.teacher.controller;

import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.09.17..
 */
@Component
public class JoinInRequestControllerActiveMenuDecider {
    public void provideActiveMenu(HttpServletRequest request) {
        if (request.getRequestURL().toString().contains(UrlProvider.TEACHER_DECLINED_REQUESTS_URL)) {
            request.setAttribute("currentMenu", "declined-requests");
        } else {
            request.setAttribute("currentMenu", "requests");
        }
    }
}
