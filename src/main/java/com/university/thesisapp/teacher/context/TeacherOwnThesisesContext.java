package com.university.thesisapp.teacher.context;

import com.university.thesisapp.dao.persistence.model.Thesis;

import java.util.List;
import java.util.Map;

/**
 * Created by Gábor on 2015.07.27..
 */
public class TeacherOwnThesisesContext {
    private List<Thesis> thesises;
    private Map<Long, Positions> studentPositions;

    public List<Thesis> getThesises() {
        return thesises;
    }

    public void setThesises(List<Thesis> thesises) {
        this.thesises = thesises;
    }

    public Map<Long, Positions> getStudentPositions() {
        return studentPositions;
    }

    public void setStudentPositions(Map<Long, Positions> studentPositions) {
        this.studentPositions = studentPositions;
    }
}
