package com.university.thesisapp.dao.persistence.dao;

import com.google.common.primitives.Longs;
import com.university.thesisapp.dao.persistence.model.Course;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Gábor on 2015.07.24..
 */
@Service("courseDao")
public class CourseDao {
    @Autowired
    private EntityManagerProvider entityManagerProvider;

    public Course createCourse(String courseName, String courseCode) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        Date date = new Date();
        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseCode(courseCode);
        course.setCreationDate(date);
        course.setLastModifiedDate(date);
        entityManagerParams.getEntityManager().persist(course);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return course;
    }

    public List<Course> findByIds(List<Long> courseIds) {
        List<Course> courses = new ArrayList<Course>();
        List<Course> allCourses = getAllCourses();
        for (Course course : allCourses) {
            if (courseIds.contains(course.getCourseId())) {
                courses.add(course);
            }
        }
        return courses;
    }

    public List<Course> findByIdInputs(List<String> courseIdInputs) {
        List<Long> courseIds = new ArrayList<Long>();
        for (String courseIdInput : courseIdInputs) {
            courseIds.add(Longs.tryParse(courseIdInput));
        }

        return findByIds(courseIds);
    }

    public List<Course> getAllCourses() {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        List<Course> courses = entityManagerParams.getEntityManager().createQuery("SELECT c FROM Course c", Course.class).getResultList();
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return courses;
    }

    public Course findById(Long courseId) {
        List<Course> courses = getAllCourses();
        Course resultCourse = null;
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                resultCourse = course;
            }
        }
        return resultCourse;
    }
}
