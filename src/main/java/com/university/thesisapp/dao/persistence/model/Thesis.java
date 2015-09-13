package com.university.thesisapp.dao.persistence.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Gábor on 2015.07.24..
 */
@Entity
@Table(name = "thesis")
public class Thesis {
    private Long thesisId;
    private String titleHu;
    private String titleEn;
    private String descriptionHu;
    private String descriptionEn;
    private Long requiredSemesters;
    private List<StudentLimit> studentLimits;
    private List<Course> courses;
    private Date creationDate;
    private Date lastModifiedDate;
    private List<ThesisStudent> thesisStudents;
    private ThesisTeacher thesisTeacher;

    @Id
    @Column(name = "thesis_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getThesisId() {
        return thesisId;
    }

    public void setThesisId(Long thesisId) {
        this.thesisId = thesisId;
    }

    @Column(name = "title_hu")
    public String getTitleHu() {
        return titleHu;
    }

    public void setTitleHu(String titleHu) {
        this.titleHu = titleHu;
    }

    @Column(name = "title_en")
    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    @Column(name = "description_hu")
    public String getDescriptionHu() {
        return descriptionHu;
    }

    public void setDescriptionHu(String descriptionHu) {
        this.descriptionHu = descriptionHu;
    }

    @Column(name = "description_en")
    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    @Column(name = "required_semesters")
    public Long getRequiredSemesters() {
        return requiredSemesters;
    }

    public void setRequiredSemesters(Long requiredSemesters) {
        this.requiredSemesters = requiredSemesters;
    }

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "THESIS_STUDENT_LIMITS")
    public List<StudentLimit> getStudentLimits() {
        return studentLimits;
    }

    public void setStudentLimits(List<StudentLimit> studentLimits) {
        this.studentLimits = studentLimits;
    }

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "THESIS_COURSES")
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "thesis")
    public List<ThesisStudent> getThesisStudents() {
        return thesisStudents;
    }

    public void setThesisStudents(List<ThesisStudent> thesisStudents) {
        this.thesisStudents = thesisStudents;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public ThesisTeacher getThesisTeacher() {
        return thesisTeacher;
    }

    public void setThesisTeacher(ThesisTeacher thesisTeacher) {
        this.thesisTeacher = thesisTeacher;
    }
}
