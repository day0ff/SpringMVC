package com.day.music.entyti;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id", columnDefinition = "serial")
    private Long albumId;

    @Column(name = "album_name")
    private String albumName;

    @Column(name = "album_price")
    private Integer albumPrice;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "album_song",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    @JsonIgnore
    private List<Song> songs = new ArrayList<>();

    public Album() {
    }

    public Album(String albumName, Integer albumPrice) {
        this.albumName = albumName;
        this.albumPrice = albumPrice;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Integer getAlbumPrice() {
        return albumPrice;
    }

    public void setAlbumPrice(Integer albumPrice) {
        this.albumPrice = albumPrice;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", albumPrice=" + albumPrice +
                '}';
    }
}
