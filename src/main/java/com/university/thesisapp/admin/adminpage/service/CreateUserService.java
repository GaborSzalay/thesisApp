package com.university.thesisapp.admin.adminpage.service;

import com.university.thesisapp.ThesisAuthority;
import com.university.thesisapp.dao.persistence.dao.ThesisTeacherDao;
import com.university.thesisapp.dao.persistence.dao.ThesisUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.08.30..
 */
@Component
public class CreateUserService {
    @Autowired
    ThesisUserDao thesisUserDao;
    @Autowired
    ThesisTeacherDao thesisTeacherDao;

    public void createAdmin(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        thesisUserDao.createThesisUser(email, password, ThesisAuthority.ADMIN.getRoleName());
    }

    public void createTeacher(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        thesisTeacherDao.createThesisTeacher(email, password);
    }

}
