package com.university.thesisapp.teacher.context;

import com.university.thesisapp.dao.persistence.ThesisStatus;
import com.university.thesisapp.dao.persistence.dao.ThesisDao;
import com.university.thesisapp.dao.persistence.dao.ThesisTeacherDao;
import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.dao.persistence.model.ThesisTeacher;
import com.university.thesisapp.dao.persistence.provider.ThesisUserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    public TeacherOwnThesisesContext create(ThesisStatus thesisStatus) {
        TeacherOwnThesisesContext teacherOwnThesisesContext = new TeacherOwnThesisesContext();
        ThesisTeacher thesisTeacher = thesisTeacherDao.getThesisTeacherByEmail(thesisUserProvider.getSignedInEmail());
        List<Thesis> thesises = null;
        if (ThesisStatus.isClosed(thesisStatus)) {
            List<Thesis> acceptedThesises = thesisDao.getThesisesByTeacherAndStatus(thesisTeacher, ThesisStatus.ACCEPTED);
            List<Thesis> declinedThesises = thesisDao.getThesisesByTeacherAndStatus(thesisTeacher, ThesisStatus.DECLINED);
            thesises = new ArrayList<Thesis>(acceptedThesises);
            thesises.addAll(declinedThesises);
        } else {
             thesises = thesisDao.getThesisesByTeacherAndStatus(thesisTeacher, thesisStatus);
        }
        teacherOwnThesisesContext.setThesises(thesises);
        Map<Long, Positions> studentPositions = new HashMap<Long, Positions>();
        for (Thesis thesis : thesises) {
            studentPositions.put(thesis.getThesisId(), positionsFactory.createPositions(thesis));
        }
        teacherOwnThesisesContext.setStudentPositions(studentPositions);

        return teacherOwnThesisesContext;
    }

}
