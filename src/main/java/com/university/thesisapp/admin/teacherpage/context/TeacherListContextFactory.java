package com.university.thesisapp.admin.teacherpage.context;

import com.university.thesisapp.dao.persistence.dao.ThesisTeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.07.26..
 */
@Component
public class TeacherListContextFactory {
    @Autowired
    ThesisTeacherDao thesisTeacherDao;

    public TeacherListContext create() {
        TeacherListContext teacherListContext = new TeacherListContext();
        teacherListContext.setTeachers(thesisTeacherDao.getAllThesisTeachers());
        return teacherListContext;
    }
}
