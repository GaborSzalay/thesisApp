package com.university.thesisapp.dao.persistence.model;

import javax.persistence.*;
import java.util.Date;

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
}
