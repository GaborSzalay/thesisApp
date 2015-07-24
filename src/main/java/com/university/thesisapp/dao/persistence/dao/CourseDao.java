package com.university.thesisapp.dao.persistence.dao;

import com.university.thesisapp.dao.persistence.model.Course;
import com.university.thesisapp.dao.persistence.provider.EntityManagerParams;
import com.university.thesisapp.dao.persistence.provider.EntityManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Gábor on 2015.07.24..
 */
@Service("courseDao")
public class CourseDao {
    @Autowired
    private EntityManagerProvider entityManagerProvider;

    public void createCourse(Course course) {
        EntityManagerParams entityManagerParams = entityManagerProvider.createEntityManagerWithTransaction();
        entityManagerParams.getEntityManager().persist(course);
        entityManagerProvider.commitTransactionAndCloseConnection(entityManagerParams);
    }
}
