package com.example.songr.domain;

import com.sun.xml.bind.v2.model.core.ID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class Album {

    @Id
    @GeneratedValue //(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String title;
    private String artist;
    private int songCount;
    private int length;
    private String imageUrl;


    public Album(){

    }
    public Album( String title, String artist, int songCount, int length,String imageUrl) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Album{" +
                "imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", songCount=" + songCount +
                ", length=" + length +
                '}';
    }
}
