package com.university.thesisapp.dao.persistence.dao;

import com.google.common.primitives.Longs;
import com.university.thesisapp.dao.persistence.model.Course;
import com.university.thesisapp.dao.persistence.provider.EntityManagerHolder;
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
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        Date date = new Date();
        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseCode(courseCode);
        course.setCreationDate(date);
        course.setLastModifiedDate(date);
        entityManagerHolder.getEntityManager().persist(course);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
        return course;
    }

    public void editCourse(Long courseId, String name, String code) {
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        List<Course> courses = getAllCourses(entityManagerHolder);
        Course course = findById(courseId, courses);
        course.setCourseName(name);
        course.setCourseCode(code);
        course.setLastModifiedDate(new Date());
        entityManagerHolder.getEntityManager().persist(course);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
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
        EntityManagerHolder entityManagerHolder = entityManagerProvider.createEntityManagerWithTransaction();
        List<Course> courses = getAllCourses(entityManagerHolder);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerHolder);
        return courses;
    }

    public List<Course> getAllCourses(EntityManagerHolder entityManagerParams) {
        return entityManagerParams.getEntityManager().createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    public Course findById(Long courseId) {
        List<Course> courses = getAllCourses();
        return findById(courseId, courses);
    }

    public Course findById(Long courseId, List<Course> courses) {
        Course resultCourse = null;
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                resultCourse = course;
            }
        }
        return resultCourse;
    }

}
