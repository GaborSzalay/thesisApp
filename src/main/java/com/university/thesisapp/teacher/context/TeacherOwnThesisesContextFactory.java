package com.university.thesisapp.teacher.context;

import com.university.thesisapp.dao.persistence.dao.ThesisDao;
import com.university.thesisapp.dao.persistence.dao.ThesisTeacherDao;
import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.dao.persistence.model.ThesisTeacher;
import com.university.thesisapp.dao.persistence.provider.ThesisUserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gábor on 2015.07.27..
 */
@Component
public class TeacherOwnThesisesContextFactory {
    @Autowired
    private ThesisDao thesisDao;
    @Autowired
    private ThesisUserProvider thesisUserProvider;
    @Autowired
    private ThesisTeacherDao thesisTeacherDao;
    @Autowired
    private PositionsFactory positionsFactory;

    public TeacherOwnThesisesContext create() {
        TeacherOwnThesisesContext teacherOwnThesisesContext = new TeacherOwnThesisesContext();
        ThesisTeacher thesisTeacher = thesisTeacherDao.getThesisTeacherByEmail(thesisUserProvider.getSignedInEmail());
        List<Thesis> thesises = thesisDao.getThesisesByTeacher(thesisTeacher);
        teacherOwnThesisesContext.setThesises(thesises);
        Map<Long, Positions> studentPositions = new HashMap<Long, Positions>();
        for (Thesis thesis : thesises) {
            studentPositions.put(thesis.getThesisId(), positionsFactory.createPositions(thesis));
        }
        teacherOwnThesisesContext.setStudentPositions(studentPositions);

        return teacherOwnThesisesContext;
    }

}
