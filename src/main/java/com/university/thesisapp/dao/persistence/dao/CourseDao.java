package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.Course;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Gábor on 2015.07.24..
 */
@Service("courseDao")
public class CourseDao {
    @Autowired
    private EntityManagerProvider entityManagerProvider;

    public Course createCourse(String courseName) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        Date date = new Date();
        Course course = new Course();
        course.setCourseName(courseName);
        course.setCreationDate(date);
        course.setLastModifiedDate(date);
        entityManagerParams.getEntityManager().persist(course);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return course;
    }

    public List<Course> getAllCourses() {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        List<Course> courses = entityManagerParams.getEntityManager().createQuery("SELECT c FROM Course c", Course.class).getResultList();
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
        return courses;
    }
}
