package com.university.thesisapp.createaccount.controller;

import com.university.thesisapp.createaccount.context.CreateAccountContext;
import com.university.thesisapp.dao.persistence.dao.ThesisStudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.09.04..
 */
@Component
public class CreateAccountService {
    @Autowired
    private ThesisStudentDao thesisStudentDao;

    public void registerStudent(CreateAccountContext createAccountContext) {
        String email = createAccountContext.getEmail();
        String password = createAccountContext.getPassword();
        Long majorId = createAccountContext.getMajorId();
        Long courseId = createAccountContext.getCourseId();
        String name = createAccountContext.getName();
        String neptunCode = createAccountContext.getNeptunCode();
        thesisStudentDao.createThesisStudent(email, password, majorId, courseId, name, neptunCode);
    }
}
