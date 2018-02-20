package com.day.music.entyti;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id", columnDefinition = "serial")
    private Long songId;

    @Column(name = "song_name")
    private String songName;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;


    public Song() {
    }

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

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", songName='" + songName + '\'' +
                ", authorId=" + person.getPersonId() +
                '}';
    }
}
