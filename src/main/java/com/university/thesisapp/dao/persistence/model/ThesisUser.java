package com.university.thesisapp.dao.persistence.model;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "thesis_user")
public class ThesisUser {

    private Long thesisUserId;
    private String email;
    private String password;
    private String authority;
    private Date registrationDate;
    private ThesisStudent thesisStudent;
    private ThesisTeacher thesisTeacher;
    private List<Comment> comments;

    @Id
    @Column(name = "thesis_user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getThesisUserId() {
        return thesisUserId;
    }

    public void setThesisUserId(Long thesisUserId) {
        this.thesisUserId = thesisUserId;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", length = 60)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "thesis_authority")
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Column(name = "registration_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @OneToOne(mappedBy = "thesisUser", optional = true)
    public ThesisStudent getThesisStudent() {
        return thesisStudent;
    }

    public void setThesisStudent(ThesisStudent thesisStudent) {
        this.thesisStudent = thesisStudent;
    }

    @OneToOne(mappedBy = "thesisUser", optional = true)
    public ThesisTeacher getThesisTeacher() {
        return thesisTeacher;
    }

    public void setThesisTeacher(ThesisTeacher thesisTeacher) {
        this.thesisTeacher = thesisTeacher;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thesisUser")
    @LazyCollection(LazyCollectionOption.TRUE)
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
