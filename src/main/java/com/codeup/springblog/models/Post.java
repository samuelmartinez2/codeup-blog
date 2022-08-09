package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false )
    private String tittle;

    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Post() {
    }

    public Post(String tittle, String body, User user) {
        this.tittle = tittle;
        this.body = body;
        this.user = user;
    }

    public Post(Long id, String tittle, String body) {
        this.id = id;
        this.tittle = tittle;
        this.body = body;
    }

    public Post(String tittle, String body) {
        this.tittle = tittle;
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getTittle() {
        return tittle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
