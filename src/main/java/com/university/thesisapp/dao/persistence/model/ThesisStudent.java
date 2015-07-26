package com.university.thesisapp.dao.persistence.model;

import javax.persistence.*;

/**
 * Created by Gábor on 2015.07.24..
 */
@Entity
@Table(name = "thesis_student")
public class ThesisStudent {
    private Long thesisStudentId;
    private ThesisUser thesisUser;
    private ThesisType thesisType;
    private Major major;
    private Course course;
    private Thesis thesis;

    @Id
    @Column(name = "thesis_student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getThesisStudentId() {
        return thesisStudentId;
    }

    public void setThesisStudentId(Long thesisStudentId) {
        this.thesisStudentId = thesisStudentId;
    }

    @OneToOne
    public ThesisUser getThesisUser() {
        return thesisUser;
    }

    public void setThesisUser(ThesisUser thesisUser) {
        this.thesisUser = thesisUser;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public ThesisType getThesisType() {
        return thesisType;
    }

    public void setThesisType(ThesisType thesisType) {
        this.thesisType = thesisType;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Thesis getThesis() {
        return thesis;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }
}
