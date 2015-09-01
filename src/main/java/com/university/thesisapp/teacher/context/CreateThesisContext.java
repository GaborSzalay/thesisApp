package com.university.thesisapp.teacher.context;

import com.university.thesisapp.dao.persistence.model.Course;
import com.university.thesisapp.dao.persistence.model.Major;

import java.util.List;

/**
 * Created by Gábor on 2015.07.27..
 */
public class CreateThesisContext {
    private List<Course> courses;
    private List<Major> majors;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Major> getMajors() {
        return majors;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
    }
}
