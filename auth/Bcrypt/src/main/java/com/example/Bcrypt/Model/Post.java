package com.example.Bcrypt.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties({"user"})
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String text;

    public Post() {
    }

    public Post(String text) {
        this.text = text;
    }

    @ManyToOne
    UserPost user;

    public Long getId() {
        return id;
    }

    public UserPost getUser() {
        return user;
    }

    public void setUser(UserPost user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", user=" + user +
                '}';
    }
}
