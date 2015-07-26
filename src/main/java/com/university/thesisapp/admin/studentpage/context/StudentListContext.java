package com.university.thesisapp.admin.studentpage.context;

import com.university.thesisapp.dao.persistence.model.ThesisStudent;

import java.util.List;

/**
 * Created by Gábor on 2015.07.26..
 */
public class StudentListContext {
    private List<ThesisStudent> students;

    public List<ThesisStudent> getStudents() {
        return students;
    }

    public void setStudents(List<ThesisStudent> students) {
        this.students = students;
    }
}
