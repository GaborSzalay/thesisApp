package com.university.thesisapp.dao.persistence.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Gábor on 2015.07.26..
 */
@Entity
@Table(name = "thesis_teacher")
public class ThesisTeacher {
    private Long thesisTeacherId;
    private ThesisUser thesisUser;
    private List<Thesis> thesises;


    @Id
    @Column(name = "thesis_teacher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getThesisTeacherId() {
        return thesisTeacherId;
    }

    public void setThesisTeacherId(Long thesisTeacherId) {
        this.thesisTeacherId = thesisTeacherId;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public ThesisUser getThesisUser() {
        return thesisUser;
    }

    public void setThesisUser(ThesisUser thesisUser) {
        this.thesisUser = thesisUser;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "thesisTeacher")
    public List<Thesis> getThesises() {
        return thesises;
    }

    public void setThesises(List<Thesis> thesises) {
        this.thesises = thesises;
    }

}
