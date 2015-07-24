package com.university.thesisapp.dao.persistence.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Gábor on 2015.07.24..
 */
@Entity
@Table(name = "thesis_type")
public class ThesisType {
    private Long thesisTypeId;
    private String typeName;
    private Date creationDate;
    private Date lastModifiedDate;
    private List<ThesisStudent> thesisStudents;

    @Id
    @Column(name = "thesis_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getThesisTypeId() {
        return thesisTypeId;
    }

    public void setThesisTypeId(Long thesisTypeId) {
        this.thesisTypeId = thesisTypeId;
    }

    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "thesisType")
    public List<ThesisStudent> getThesisStudents() {
        return thesisStudents;
    }

    public void setThesisStudents(List<ThesisStudent> thesisStudents) {
        this.thesisStudents = thesisStudents;
    }
}
