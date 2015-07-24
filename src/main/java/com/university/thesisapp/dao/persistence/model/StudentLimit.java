package com.university.thesisapp.dao.persistence.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Gábor on 2015.07.24..
 */
@Entity
@Table(name = "student_limit")
public class StudentLimit {
    private Long studentLimitId;
    private Major major;
    private Long limitOfStudents;
    private Date creationDate;
    private Date lastModifiedDate;
    private List<Thesis> thesises;

    @Id
    @Column(name = "student_limit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getStudentLimitId() {
        return studentLimitId;
    }

    public void setStudentLimitId(Long studentLimitId) {
        this.studentLimitId = studentLimitId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @Column(name = "limit_of_students")
    public Long getLimitOfStudents() {
        return limitOfStudents;
    }

    public void setLimitOfStudents(Long limitOfStudents) {
        this.limitOfStudents = limitOfStudents;
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

    @ManyToMany(mappedBy = "studentLimits")
    public List<Thesis> getThesises() {
        return thesises;
    }

    public void setThesises(List<Thesis> thesises) {
        this.thesises = thesises;
    }
}
