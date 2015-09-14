package com.university.thesisapp.dao.persistence.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Gábor on 2015.07.24..
 */
@Entity
@Table(name = "thesis_student")
public class ThesisStudent {
    private Long thesisStudentId;
    private ThesisUser thesisUser;
    private Major major;
    private Course course;
    private Thesis thesis;
    private List<StudentRequest> studentRequests;

    @Id
    @Column(name = "thesis_student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getThesisStudentId() {
        return thesisStudentId;
    }

    public void setThesisStudentId(Long thesisStudentId) {
        this.thesisStudentId = thesisStudentId;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public ThesisUser getThesisUser() {
        return thesisUser;
    }

    public void setThesisUser(ThesisUser thesisUser) {
        this.thesisUser = thesisUser;
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

    @ManyToOne(fetch = FetchType.EAGER)
    public Thesis getThesis() {
        return thesis;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }

    @OneToMany(mappedBy = "thesisStudent")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<StudentRequest> getStudentRequests() {
        return studentRequests;
    }

    public void setStudentRequests(List<StudentRequest> studentRequests) {
        this.studentRequests = studentRequests;
    }
}
