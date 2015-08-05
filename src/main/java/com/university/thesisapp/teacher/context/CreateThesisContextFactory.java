package com.university.thesisapp.teacher.context;

import com.university.thesisapp.dao.persistence.dao.CourseDao;
import com.university.thesisapp.dao.persistence.dao.MajorDao;
import com.university.thesisapp.dao.persistence.dao.ThesisTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.07.27..
 */
@Component
public class CreateThesisContextFactory {
    @Autowired
    CourseDao courseDao;
    @Autowired
    MajorDao majorDao;
    @Autowired
    ThesisTypeDao thesisTypeDao;

    public CreateThesisContext create() {
        CreateThesisContext createThesisContext = new CreateThesisContext();
        createThesisContext.setCourses(courseDao.getAllCourses());
        createThesisContext.setMajors(majorDao.getAllMajors());
        createThesisContext.setThesisTypes(thesisTypeDao.getAllThesisTypes());
        return createThesisContext;
    }
}
