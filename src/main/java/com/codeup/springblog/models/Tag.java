//package com.codeup.springblog.models;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name="tags")
//public class Tag {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(length =50,nullable = false)
//    private String name;
//
//    @ManyToMany(mappedBy = "tags")
//    private List<Post> posts;
//
//    public Tag() {
//    }
//
//    public Tag(String name, List<Post> posts) {
//        this.name = name;
//        this.posts = posts;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(List<Post> posts) {
//        this.posts = posts;
//    }
//}
