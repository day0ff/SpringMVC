package com.day.music.entity;

import javax.persistence.*;

/**
 * The class entity to store information about Song.
 */
@Entity
@Table(name = "song")
public class Song {
    /**
     * property - of Song id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id", columnDefinition = "serial")
    private Long songId;
    /**
     * property - of Song name
     */
    @Column(name = "song_name")
    private String songName;
    /**
     * property - of Song reference to Person
     */
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    /**
     * Creates a new default object
     */
    public Song() {
    }
    /**
     * Creates a new object with the specified values
     *
     * @param songName  - song title
     * @param person  - song author
     */
    public Song(String songName, Person person) {
        this.songName = songName;
        this.person = person;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    /**
     * The function casts object to string
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", songName='" + songName + '\'' +
                ", authorId=" + person.getPersonId() +
                '}';
    }
}
