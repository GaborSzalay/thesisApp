package com.university.thesisapp.teacher.controller;

import com.university.thesisapp.dao.persistence.dao.StudentLimitDao;
import com.university.thesisapp.dao.persistence.model.StudentLimit;
import com.university.thesisapp.teacher.context.ThesisForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Gábor on 2015.09.02..
 */
@Component
public class StudentLimitTransformer {

    @Autowired
    private StudentLimitDao studentLimitDao;

    public List<StudentLimit> transform(ThesisForm thesisForm) {
        final Map<Long, Long> studentLimitsForm = thesisForm.getStudentLimits();
        List<StudentLimit> studentLimits = new ArrayList<StudentLimit>();

        for (Map.Entry<Long, Long> studentLimitsEntry : studentLimitsForm.entrySet()) {
            studentLimits.add(studentLimitDao.provideStudentLimit(studentLimitsEntry.getKey(), studentLimitsEntry.getValue()));
        }
        return studentLimits;
    }
}
