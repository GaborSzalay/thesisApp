package com.university.thesisapp.teacher.context;

import com.university.thesisapp.dao.persistence.dao.ThesisDao;
import com.university.thesisapp.dao.persistence.dao.ThesisTeacherDao;
import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.dao.persistence.model.ThesisTeacher;
import com.university.thesisapp.dao.persistence.model.ThesisUser;
import com.university.thesisapp.dao.persistence.provider.ThesisUserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Gábor on 2015.07.27..
 */
@Component
public class TeacherOwnThesisesContextFactory {
    @Autowired
    ThesisDao thesisDao;
    @Autowired
    ThesisUserProvider thesisUserProvider;
    @Autowired
    ThesisTeacherDao thesisTeacherDao;

    public TeacherOwnThesisesContext create() {
        TeacherOwnThesisesContext teacherOwnThesisesContext = new TeacherOwnThesisesContext();
        ThesisUser signedInUser = thesisUserProvider.getSignedInUser();
        ThesisTeacher thesisTeacher = thesisTeacherDao.getThesisTeacherByThesisUser(signedInUser);
        List<Thesis> thesises = thesisDao.getThesisesByTeacher(thesisTeacher);
        teacherOwnThesisesContext.setThesises(thesises);
        return teacherOwnThesisesContext;
    }
}
