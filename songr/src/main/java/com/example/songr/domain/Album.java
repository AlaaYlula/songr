package com.example.songr.domain;

public class Album {
    private String imageUrl;
    private String title;
    private String artist;
    private int songCount;
    private int length;

    public Album( String title, String artist, int songCount, int length,String imageUrl) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
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
