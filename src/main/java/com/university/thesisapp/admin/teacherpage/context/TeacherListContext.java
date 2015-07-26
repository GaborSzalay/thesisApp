package com.university.thesisapp.admin.teacherpage.context;

import com.university.thesisapp.dao.persistence.model.ThesisUser;

import java.util.List;

/**
 * Created by Gábor on 2015.07.26..
 */
public class TeacherListContext {
    private List<ThesisUser> teachers;

    public List<ThesisUser> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<ThesisUser> teachers) {
        this.teachers = teachers;
    }
}
