package com.university.thesisapp.admin.studentpage.context;

import com.university.thesisapp.dao.persistence.dao.ThesisStudentDao;
import com.university.thesisapp.dao.persistence.model.ThesisStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Gábor on 2015.07.26..
 */
@Component
public class StudentListContextFactory {
    @Autowired
    private ThesisStudentDao thesisStudentDao;


    public StudentListContext create() {
        StudentListContext studentListContext = new StudentListContext();
        List<ThesisStudent> thesisStudents = thesisStudentDao.getAllThesisStudents();
        studentListContext.setStudents(thesisStudents);
        return studentListContext;
    }
}
