package com.day.music.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The class entity to store information about music Album.
 */
@Entity
@Table(name = "album")
public class Album {
    /**
     * property - of Album id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id", columnDefinition = "serial")
    private Long albumId;
    /**
     * property - of Album Name
     */
    @Column(name = "album_name")
    private String albumName;
    /**
     * property - of Album Price
     */
    @Column(name = "album_price")
    private Integer albumPrice;
    /**
     * property - of Album reference to Songs
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "album_song",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    @JsonIgnore
    private List<Song> songs = new ArrayList<>();

    /**
     * Creates a new default object
     */
    public Album() {
    }

    /**
     * Creates a new object with the specified values
     *
     * @param albumName  - album name
     * @param albumPrice - album price
     */
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

    /**
     * The function casts object to string
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", albumPrice=" + albumPrice +
                '}';
    }
}
