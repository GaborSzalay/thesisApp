package com.university.thesisapp.teacher.context;

import com.university.thesisapp.dao.persistence.model.Thesis;

import java.util.List;

/**
 * Created by Gábor on 2015.07.27..
 */
public class TeacherOwnThesisesContext {
    private List<Thesis> thesises;

    public List<Thesis> getThesises() {
        return thesises;
    }

    public void setThesises(List<Thesis> thesises) {
        this.thesises = thesises;
    }
}
