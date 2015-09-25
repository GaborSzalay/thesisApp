package com.university.thesisapp.admin.adminpage.service;

import com.university.thesisapp.ThesisAuthority;
import com.university.thesisapp.dao.persistence.dao.ThesisStudentDao;
import com.university.thesisapp.dao.persistence.dao.ThesisTeacherDao;
import com.university.thesisapp.dao.persistence.dao.ThesisUserDao;
import com.university.thesisapp.dao.persistence.model.ThesisStudent;
import com.university.thesisapp.dao.persistence.model.ThesisUser;
import com.university.thesisapp.dao.persistence.provider.ThesisUserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.08.30..
 */
@Component
public class CreateUserService {
    @Autowired
    private ThesisUserDao thesisUserDao;
    @Autowired
    private ThesisTeacherDao thesisTeacherDao;
    @Autowired
    private ThesisUserProvider thesisUserProvider;
    @Autowired
    private ThesisStudentDao thesisStudentDao;

    public void createAdmin(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        thesisUserDao.createThesisUser(email, password, ThesisAuthority.ADMIN.getRoleName(), name);
    }

    public void createTeacher(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        thesisTeacherDao.createThesisTeacher(email, password, name);
    }


    public ThesisStudent retrieveStudent(HttpServletRequest request) {
        ThesisUser signedInUser = thesisUserProvider.getSignedInUser();
        return thesisStudentDao.findByThesisUser(signedInUser);
    }
}
