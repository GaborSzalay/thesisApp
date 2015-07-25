package com.university.thesisapp.dao.bootstrap;

import com.university.thesisapp.dao.persistence.dao.*;
import com.university.thesisapp.dao.persistence.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static com.university.thesisapp.util.Validation.empty;
import static com.university.thesisapp.util.Validation.notEmpty;

/**
 * Created by Gábor on 2015.07.25..
 */
public class DatabaseInitializerInterceptor extends HandlerInterceptorAdapter {
    Logger logger = LoggerFactory.getLogger(DatabaseInitializerInterceptor.class);

    @Autowired
    CourseDao courseDao;
    @Autowired
    MajorDao majorDao;
    @Autowired
    StudentLimitDao studentLimitDao;
    @Autowired
    ThesisDao thesisDao;
    @Autowired
    ThesisStudentDao thesisStudentDao;
    @Autowired
    ThesisTypeDao thesisTypeDao;
    @Autowired
    ThesisUserDao thesisUserDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (empty(thesisUserDao.getAllThesisUsers())) {
            thesisUserDao.createThesisUser("admin", "test123", "ROLE_ADMIN");
            logger.info("Test admin created.");
            thesisUserDao.createThesisUser("teacher", "test123", "ROLE_TEACHER");
            logger.info("Test teacher created.");
            thesisUserDao.createThesisUser("student1", "test123", "ROLE_STUDENT");
            logger.info("Test student 1 created.");
            thesisUserDao.createThesisUser("student2", "test123", "ROLE_STUDENT");
            logger.info("Test student 2 created.");


            if (empty(courseDao.getAllCourses())) {
                courseDao.createCourse("Mérnöki tervezés");
                logger.info("Test course 1 created.");
                courseDao.createCourse("Szakdolgozat");
                logger.info("Test course 2 created.");
            }

            if (empty(majorDao.getAllMajors())) {
                majorDao.createMajor("Programtervező Informatikus");
                logger.info("Test major 1 created.");
                majorDao.createMajor("Mérnök informatikus");
                logger.info("Test major 2 created.");
            }

            if (empty(thesisTypeDao.getAllThesisTypes())) {
                thesisTypeDao.createThesisType("Diplomadolgozat");
                logger.info("Test thesis type 1 created.");
                thesisTypeDao.createThesisType("Szakdolgozat");
                logger.info("Test thesis type 2 created.");
            }

            if (empty(studentLimitDao.getAllStudentLimits())) {
                List<Major> majors = majorDao.getAllMajors();
                if (majors.size() > 1) {
                    studentLimitDao.createStudentLimit(majors.get(0), (long) 2);
                    logger.info("Test student limit 1 created.");
                    studentLimitDao.createStudentLimit(majors.get(1), (long) 2);
                    logger.info("Test student limit 2 created.");
                }
            }


            if (empty(thesisStudentDao.getAllThesisStudents())) {
                ThesisUser thesisUser1 = thesisUserDao.getThesisUserByUserName("student1");
                ThesisUser thesisUser2 = thesisUserDao.getThesisUserByUserName("student2");
                List<Course> courses = courseDao.getAllCourses();
                List<ThesisType> thesisTypes = thesisTypeDao.getAllThesisTypes();
                List<Major> majors = majorDao.getAllMajors();
                if (isUsersValid(thesisUser1, thesisUser2) && isCoursesValid(courses) && isThesisTypesValid(thesisTypes) && isMajorsValid(majors)) {
                    thesisStudentDao.createThesisStudent(thesisTypes.get(0), courses.get(1), majors.get(0), thesisUser2);
                    logger.info("Test student 1 details created.");
                    thesisStudentDao.createThesisStudent(thesisTypes.get(1), courses.get(0), majors.get(1), thesisUser1);
                    logger.info("Test student 2 details created.");
                }

            }

            if (empty(thesisDao.getAllThesises())) {
                final List<Course> courses = courseDao.getAllCourses();
                List<ThesisType> thesisTypes = thesisTypeDao.getAllThesisTypes();
                final List<StudentLimit> studentLimits = studentLimitDao.getAllStudentLimits();

                if (isCoursesValid(courses) && isThesisTypesValid(thesisTypes) && isStudentLimitsValid(studentLimits)) {
                    List<Course> courses2 = new ArrayList<Course>() {{
                        add(courses.get(0));
                    }};
                    List<StudentLimit> studentLimits2 = new ArrayList<StudentLimit>() {{
                        add(studentLimits.get(0));
                    }};
                    thesisDao.creaateThesis("HTML 5 alapok", "Basic of HTML 5", "Test HTML 5 szakdoli téma leírás", "Test description of HTML 5 thesis", (long) 2, thesisTypes.get(0), courses, studentLimits);
                    logger.info("Test thesis 1 created.");
                    thesisDao.creaateThesis("CSS 3 alapok", "Basic of CSS 3", "Test CSS 3 szakdoli téma leírás", "Test description of CSS 3 thesis", (long) 1, thesisTypes.get(1), courses2, studentLimits2);
                    logger.info("Test thesis 2 created.");
                }

            }
        }
        return true;
    }

    private boolean isUsersValid(ThesisUser thesisUser1, ThesisUser thesisUser2) {
        return notEmpty(thesisUser1) && notEmpty(thesisUser2);
    }

    private boolean isCoursesValid(List<Course> courses) {
        return notEmpty(courses) && courses.size() > 1;
    }

    private boolean isThesisTypesValid(List<ThesisType> thesisTypes) {
        return notEmpty(thesisTypes) && thesisTypes.size() > 1;
    }

    private boolean isMajorsValid(List<Major> majors) {
        return notEmpty(majors) && majors.size() > 1;
    }

    private boolean isStudentLimitsValid(List<StudentLimit> studentLimits) {
        return notEmpty(studentLimits) && studentLimits.size() > 1;
    }
}
