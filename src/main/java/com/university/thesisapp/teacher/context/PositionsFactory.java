package com.university.thesisapp.teacher.context;

import com.university.thesisapp.dao.persistence.dao.ThesisDao;
import com.university.thesisapp.dao.persistence.model.StudentLimit;
import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.dao.persistence.model.ThesisStudent;
import com.university.thesisapp.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gábor on 2015.09.13..
 */
@Component
public class PositionsFactory {
    private static final long ACTUAL_STUDENT = 1;

    @Autowired
    ThesisDao thesisDao;

    public Positions createPositions(Thesis thesis) {
        Positions positions = new Positions();
        populateMaxPositions(thesis, positions);
        populateOpenStudentPositions(thesis, positions);
        positions.setAppointedPositions(thesis.getThesisStudents().size());
        return positions;
    }

    private void populateMaxPositions(Thesis thesis, Positions positions) {
        long maxPositions = 0;
        for (StudentLimit studentLimit : thesis.getStudentLimits()) {
            maxPositions += studentLimit.getLimitOfStudents();
        }
        positions.setMaxPositions(maxPositions);
    }

    private void populateOpenStudentPositions(Thesis thesis, Positions positions) {
        Map<String, Long> openStudentPositions = new HashMap<String, Long>();
        fillOpenStudentPositionsByStudents(thesis, openStudentPositions);
        fillOpenStudentPositionsByRemainingMajors(thesis, openStudentPositions);
        populateOpenPositions(positions, openStudentPositions);
        positions.setOpenStudentPositions(openStudentPositions);
    }

    private void fillOpenStudentPositionsByStudents(Thesis thesis, Map<String, Long> openStudentPositions) {
        for (ThesisStudent thesisStudent : thesis.getThesisStudents()) {
            String majorName = thesisStudent.getMajor().getMajorName();
            Long openPositionsByMajor = openStudentPositions.get(majorName);
            if (Validation.empty(openPositionsByMajor)) {
                StudentLimit studentLimitForActualMajor = thesisDao.getStudentLimitByMajor(thesis, thesisStudent.getMajor());
                openStudentPositions.put(majorName, studentLimitForActualMajor.getLimitOfStudents() - ACTUAL_STUDENT);
            } else {
                if (openPositionsByMajor >= 1) {
                    openStudentPositions.put(majorName, openPositionsByMajor - ACTUAL_STUDENT);
                }
            }
        }
    }

    private void fillOpenStudentPositionsByRemainingMajors(Thesis thesis, Map<String, Long> openStudentPositions) {
        for (StudentLimit studentLimit : thesis.getStudentLimits()) {
            String majorName = studentLimit.getMajor().getMajorName();
            Long openStudentPosition = openStudentPositions.get(majorName);
            if (Validation.empty(openStudentPosition)) {
                openStudentPositions.put(majorName, studentLimit.getLimitOfStudents());
            }
        }
    }

    private void populateOpenPositions(Positions positions, Map<String, Long> openStudentPositions) {
        long openPositions = 0;
        for (Map.Entry<String, Long> openStudentPosition : openStudentPositions.entrySet()) {
            openPositions += openStudentPosition.getValue();
        }
        positions.setOpenPositions(openPositions);
    }
}
