package com.university.thesisapp.dao.persistence.service;

import com.university.thesisapp.dao.persistence.dao.ThesisDao;
import com.university.thesisapp.dao.persistence.model.Course;
import com.university.thesisapp.dao.persistence.model.Major;
import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.dao.persistence.model.ThesisStudent;
import com.university.thesisapp.teacher.context.Positions;
import com.university.thesisapp.teacher.context.PositionsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**
 * Created by Gábor on 2015.09.13..
 */
@Component
public class ThesisService {
    @Autowired
    ThesisDao thesisDao;
    @Autowired
    PositionsFactory positionsFactory;

    public List<Thesis> getRecommendedTheses(ThesisStudent thesisStudent) {
        List<Thesis> allThesises = thesisDao.getAllThesises();
        List<Thesis> recommendedThesesByCourse = new ArrayList<Thesis>();
        for (Thesis thesis : allThesises) {
            for (Course course : thesis.getCourses()) {
                if (course.getCourseId().equals(thesisStudent.getCourse().getCourseId())) {
                    recommendedThesesByCourse.add(thesis);
                }
            }
        }

        List<Thesis> recommendedThesesByOpenPositions = new ArrayList<Thesis>();
        for (Thesis thesis : recommendedThesesByCourse) {
            Positions positions = positionsFactory.createPositions(thesis);
            Major studentMajor = thesisStudent.getMajor();
            for (Entry<String, Long> position : positions.getOpenStudentPositions().entrySet()) {
                if (studentMajor.getMajorName().equals(position.getKey())) {
                    if (isOpenPositionAvailable(position)) {
                        recommendedThesesByOpenPositions.add(thesis);
                    }
                }
            }
        }
        return recommendedThesesByOpenPositions;
    }

    private boolean isOpenPositionAvailable(Entry<String, Long> position) {
        return position.getValue() > 0;
    }
}
