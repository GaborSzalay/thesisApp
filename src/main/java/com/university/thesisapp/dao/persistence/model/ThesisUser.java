package com.university.thesisapp.dao.persistence.model;


import javax.persistence.*;

@Entity
@Table(name = "thesis_user")
public class ThesisUser {

    protected Long thesisUserId;
    protected String firstName;
    protected String lastName;

    @Id
    @Column(name = "thesis_user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getThesisUserId() {
        return thesisUserId;
    }

    public void setThesisUserId(Long thesisUserId) {
        this.thesisUserId = thesisUserId;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
