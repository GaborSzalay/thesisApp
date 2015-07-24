package com.university.thesisapp.dao.persistence.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Gábor on 2015.07.24..
 */
@Entity
@Table(name = "major")
public class Major {
    private Long majorId;
    private String majorName;
    private Date creationDate;
    private Date lastModifiedDate;
    private List<StudentLimit> studentLimits;

    @Id
    @Column(name = "major_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    @Column(name = "major_name")
    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
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

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="major")
    public List<StudentLimit> getStudentLimits() {
        return studentLimits;
    }

    public void setStudentLimits(List<StudentLimit> studentLimits) {
        this.studentLimits = studentLimits;
    }
}
