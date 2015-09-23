package com.university.thesisapp.dao.persistence.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Gábor on 2015.09.24..
 */
@Entity
@Table(name = "comment")
public class Comment {
    private Long commentId;
    private Date creationDate;
    private String commentMessage;
    private ThesisUser thesisUser;
    private Thesis thesis;

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "comment_message", length = 2000)
    public String getCommentMessage() {
        return commentMessage;
    }

    public void setCommentMessage(String commentMessage) {
        this.commentMessage = commentMessage;
    }

    @ManyToOne
    public ThesisUser getThesisUser() {
        return thesisUser;
    }

    public void setThesisUser(ThesisUser thesisUser) {
        this.thesisUser = thesisUser;
    }

    @ManyToOne
    public Thesis getThesis() {
        return thesis;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }
}
