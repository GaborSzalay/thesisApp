package com.university.thesisapp.dao.persistence.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Gábor on 2015.09.14..
 */
@Entity
@Table(name = "studentRequest")
public class StudentRequest {
    private Long studentRequestId;
    private ThesisStudent thesisStudent;
    private ThesisTeacher thesisTeacher;
    private Thesis thesis;
    private Date creationDate;
    private String currentState;

    @Id
    @Column(name = "student_request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getStudentRequestId() {
        return studentRequestId;
    }

    public void setStudentRequestId(Long studentRequestId) {
        this.studentRequestId = studentRequestId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public ThesisStudent getThesisStudent() {
        return thesisStudent;
    }

    public void setThesisStudent(ThesisStudent thesisStudent) {
        this.thesisStudent = thesisStudent;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public ThesisTeacher getThesisTeacher() {
        return thesisTeacher;
    }

    public void setThesisTeacher(ThesisTeacher thesisTeacher) {
        this.thesisTeacher = thesisTeacher;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Thesis getThesis() {
        return thesis;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "current_state")
    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }
}
