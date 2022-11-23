package com.hieucodeg.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    @Column(columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    private Date datePost;
    @Column(columnDefinition = "TEXT default NULL")
    private String content;

    public Article() {
    }

    public Article(String title, String author, Date datePost, String content) {
        this.title = title;
        this.author = author;
        this.datePost = datePost;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
