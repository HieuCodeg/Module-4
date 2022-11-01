package com.hieucodeg.model;

import sun.security.util.KnownOIDs;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "comments")
public class Comment{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int mark;
    private String author;
    private String feedback;
    private int likeNumber;
    @Column(columnDefinition = "DATE default (curdate())")
    private Date dateComment;

    public Date getDateComment() {
        return dateComment;
    }

    public void setDateComment(Date dateComment) {
        this.dateComment = dateComment;
    }

    public Comment() {
    }

    public Comment(int mark, String author, String feedback) {
        this.mark = mark;
        this.author = author;
        this.feedback = feedback;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getLike() {
        return likeNumber;
    }

    public void setLike(int like) {
        this.likeNumber = like;
    }
}
