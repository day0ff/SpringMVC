package com.day.music.service;

import com.day.music.entity.Person;

import java.util.List;

public interface PersonService {
    Person save(Person person);
    void delete(Person person);
    List<Person> findAll();
    Person findById(Long personId);
    int getCount();

    void setFirstLastName(String firstName,String lastName, Long personId);
}
