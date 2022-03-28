package com.example.songr.domain;

import javax.persistence.*;
import java.util.List;

//@JsonIgnoreProperties({"songs"})
@Entity
public class Album {

    @Id
    @GeneratedValue //(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String artist;
    private int songCount = 0;
    private double length = 0 ;
    private String imageUrl;

    @OneToMany(mappedBy = "album")
    List<Song> songs;

    public Album(){

    }
    public Album( String title, String artist, int songCount, double length,String imageUrl) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setLength(double length) {
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

    public double getLength() {
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
                ", songs=" + songs +

                '}';
    }
}
