package com.university.thesisapp.dao.persistence.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Gábor on 2015.07.24..
 */
@Entity
@Table(name = "course")
public class Course {
    private Long courseId;
    private String courseName;
    private Date creationDate;
    private Date lastModifiedDate;
    private List<ThesisStudent> thesisStudents;
    private List<Thesis> thesises;

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    @Column(name = "course_name")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "course")
    public List<ThesisStudent> getThesisStudents() {
        return thesisStudents;
    }

    public void setThesisStudents(List<ThesisStudent> thesisStudents) {
        this.thesisStudents = thesisStudents;
    }

    @ManyToMany(mappedBy = "courses")
    public List<Thesis> getThesises() {
        return thesises;
    }

    public void setThesises(List<Thesis> thesises) {
        this.thesises = thesises;
    }
}
