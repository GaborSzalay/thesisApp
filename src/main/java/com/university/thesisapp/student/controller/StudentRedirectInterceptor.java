package com.university.thesisapp.student.controller;

import com.university.thesisapp.dao.persistence.dao.ThesisStudentDao;
import com.university.thesisapp.dao.persistence.model.ThesisStudent;
import com.university.thesisapp.dao.persistence.provider.ThesisUserAuthorityProvider;
import com.university.thesisapp.dao.persistence.provider.ThesisUserProvider;
import com.university.thesisapp.util.Validation;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Gábor on 2015.09.18..
 */
public class StudentRedirectInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private ThesisUserProvider thesisUserProvider;
    @Autowired
    private ThesisUserAuthorityProvider thesisUserAuthorityProvider;
    @Autowired
    private ThesisStudentDao thesisStudentDao;

    private List<String> redirectedUrls;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (thesisUserAuthorityProvider.isStudent()) {
            ThesisStudent thesisStudent = thesisStudentDao.findByThesisUser(thesisUserProvider.getSignedInUser());
            if (Validation.notEmpty(thesisStudent.getThesis())) {
                boolean redirectNeeded = false;
                for (String redirectedUrl : redirectedUrls) {
                    if (request.getRequestURI().equals(redirectedUrl)) {
                        redirectNeeded = true;
                    }
                }
                if (redirectNeeded) {
                    response.sendRedirect(UrlProvider.STUDENT_THESIS_HOMEPAGE_URL);
                }
            }
        }
        return true;
    }

    public void setRedirectedUrls(List<String> redirectedUrls) {
        this.redirectedUrls = redirectedUrls;
    }
}
