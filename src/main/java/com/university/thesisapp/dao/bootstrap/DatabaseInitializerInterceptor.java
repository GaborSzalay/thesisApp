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
    ThesisUserDao thesisUserDao;
    @Autowired
    ThesisTeacherDao thesisTeacherDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (empty(thesisUserDao.getAllThesisUsers())) {
            ThesisUser admin = thesisUserDao.createThesisUser("admin@thesis.hu", "test123", "ROLE_ADMIN", "Gipsz Jakab");
            logger.info("Test admin created.");
            ThesisUser studdent1 = thesisUserDao.createThesisUser("student1@thesis.hu", "test123", "ROLE_STUDENT", "Tóth Ádám");
            logger.info("Test student 1 created.");
            ThesisUser student2 = thesisUserDao.createThesisUser("student2@thesis.hu", "test123", "ROLE_STUDENT", "Tóth Béla");
            logger.info("Test student 2 created.");
            thesisUserDao.enableUserByEmail(admin.getEmail());
            thesisUserDao.enableUserByEmail(studdent1.getEmail());
            thesisUserDao.enableUserByEmail(student2.getEmail());
        }

        if (empty(courseDao.getAllCourses())) {
            courseDao.createCourse("Mérnöki tervezés", "PEMK1004");
            logger.info("Test course 1 created.");
            courseDao.createCourse("Szakdolgozat", "PEMK1005");
            logger.info("Test course 2 created.");
        }

        if (empty(majorDao.getAllMajors())) {
            majorDao.createMajor("Programtervező Informatikus");
            logger.info("Test major 1 created.");
            majorDao.createMajor("Mérnök informatikus");
            logger.info("Test major 2 created.");
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
            ThesisUser thesisUser1 = thesisUserDao.getThesisUserByEmail("student1@thesis.hu");
            ThesisUser thesisUser2 = thesisUserDao.getThesisUserByEmail("student2@thesis.hu");
            List<Course> courses = courseDao.getAllCourses();
            List<Major> majors = majorDao.getAllMajors();
            if (isUsersValid(thesisUser1, thesisUser2) && isCoursesValid(courses) && isMajorsValid(majors)) {
                thesisStudentDao.createThesisStudent(courses.get(1), majors.get(0), thesisUser2);
                logger.info("Test student 1 details created.");
                thesisStudentDao.createThesisStudent(courses.get(0), majors.get(1), thesisUser1);
                logger.info("Test student 2 details created.");
            }

        }

        if (empty(thesisTeacherDao.getAllThesisTeachers())) {
            ThesisTeacher thesisTeacher = thesisTeacherDao.createThesisTeacher("teacher@thesis.hu", "test123", "Mézga Géza");
            thesisUserDao.enableUserByEmail(thesisTeacher.getThesisUser().getEmail());
            logger.info("Test teacher created.");
        }

        if (empty(thesisDao.getAllThesises())) {
            final List<Course> courses = courseDao.getAllCourses();
            final List<StudentLimit> studentLimits = studentLimitDao.getAllStudentLimits();
            final List<ThesisTeacher> teachers = thesisTeacherDao.getAllThesisTeachers();

            if (isCoursesValid(courses) && isStudentLimitsValid(studentLimits) && notEmpty(teachers)) {
                List<Course> courses2 = new ArrayList<Course>() {{
                    add(courses.get(0));
                }};
                List<StudentLimit> studentLimits2 = new ArrayList<StudentLimit>() {{
                    add(studentLimits.get(0));
                }};
                thesisDao.creaateThesis("HTML 5 alapok", "Basic of HTML 5", "Test HTML 5 szakdoli téma leírás", "Test description of HTML 5 thesis", (long) 2, courses, studentLimits, teachers.get(0));
                logger.info("Test thesis 1 created.");
                thesisDao.creaateThesis("CSS 3 alapok", "Basic of CSS 3", "Test CSS 3 szakdoli téma leírás", "Test description of CSS 3 thesis", (long) 1, courses2, studentLimits2, teachers.get(0));
                logger.info("Test thesis 2 created.");
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


    private boolean isMajorsValid(List<Major> majors) {
        return notEmpty(majors) && majors.size() > 1;
    }

    private boolean isStudentLimitsValid(List<StudentLimit> studentLimits) {
        return notEmpty(studentLimits) && studentLimits.size() > 1;
    }
}
