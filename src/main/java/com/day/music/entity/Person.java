package com.day.music.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The class entity to store information about Person.
 */
@Entity
@Table(name = "person")
public class Person {
    /**
     * property - of Person id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", columnDefinition = "serial")
    private Long personId;
    /**
     * property - of Person Last Name
     */
    @Column(name = "last_name")
    private String lastName;
    /**
     * property - of Person First Name
     */
    @Column(name = "first_name")
    private String firstName;
    /**
     * property - of Person reference to passport
     */
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="passport_id")
    private Passport passport;
    /**
     * property - of Persons songs
     */
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Song> songs = new ArrayList<>();
    /**
     * Creates a new default object
     */
    public Person() {
    }
    /**
     * Creates a new object with the specified values
     *
     * @param lastName  - person last name
     * @param firstName  - person first name
     * @param passport  - person passport
     */
    public Person(String lastName, String firstName, Passport passport) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.passport = passport;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
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
        return "Person{" +
                "personId=" + personId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", passport=" + passport +
                '}';
    }
}
