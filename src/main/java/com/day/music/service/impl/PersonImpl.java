package com.day.music.service.impl;

import com.day.music.entyti.Person;
import com.day.music.repository.PersonRepository;
import com.day.music.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    @Override
    public Person save(Person person) {
        Person personAdd = personRepository.saveAndFlush(person);
        return personAdd;
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Person findById(Long personId) {
        return personRepository.findByPersonId(personId);
    }

    @Override
    public int getCount() {
        return personRepository.getCount();
    }

    @Transactional(readOnly = true)
    @Override
    public void setFirstLastName(String firstName, String lastName, Long personId) {
        personRepository.setFirstLastName(firstName,lastName,personId);
    }
}
