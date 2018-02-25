package com.day.music.entity;

import javax.persistence.*;

/**
 * The class entity to store information about person Passport information.
 */
@Entity
@Table(name = "passport")
public class Passport {
    /**
     * property - of Passport id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id", columnDefinition = "serial")
    private Long passportId;
    /**
     * property - of Passport number
     */
    @Column(name = "passport_number")
    private String passportNumber;
    /**
     * Creates a new default object
     */
    public Passport() {
    }
    /**
     * Creates a new object with the specified values
     *
     * @param passportNumber  - passport number
     */
    public Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Long getPassportId() {
        return passportId;
    }

    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    /**
     * The function casts object to string
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Passport{" +
                "passportId=" + passportId +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }
}
