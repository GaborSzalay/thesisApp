package com.university.thesisapp.admin.teacherpage.context;

import com.university.thesisapp.dao.persistence.model.ThesisTeacher;

import java.util.List;

/**
 * Created by Gábor on 2015.07.26..
 */
public class TeacherListContext {
    private List<ThesisTeacher> teachers;

    public List<ThesisTeacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<ThesisTeacher> teachers) {
        this.teachers = teachers;
    }
}
