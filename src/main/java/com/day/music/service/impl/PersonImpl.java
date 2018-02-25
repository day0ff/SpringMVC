package com.day.music.service.impl;

import com.day.music.entity.Person;
import com.day.music.repository.PersonRepository;
import com.day.music.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * The class implements the business logic entities of entity Person.
 */
@Service
public class PersonImpl implements PersonService {
    /**
     * property - set PersonRepository bean
     */
    @Autowired
    private PersonRepository personRepository;
    /**
     * The method saved person object to database
     *
     * @return saved person
     */
    @Transactional
    @Override
    public Person save(Person person) {
        Person personAdd = personRepository.saveAndFlush(person);
        return personAdd;
    }
    /**
     * The method delete person object from database
     *
     * @return saved person
     */
    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }
    /**
     * The method get person objects from database
     *
     * @return person list
     */
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
    /**
     * The method get person object from database by id
     *
     * @return person
     */
    @Transactional(readOnly = true)
    @Override
    public Person findById(Long personId) {
        return personRepository.findByPersonId(personId);
    }
    /**
     * The method return persons count from database
     *
     * @return persons count
     */
    @Override
    public int getCount() {
        return personRepository.getCount();
    }
    /**
     * The method update person first and last name by id
     */
    @Transactional(readOnly = true)
    @Override
    public void setFirstLastName(String firstName, String lastName, Long personId) {
        personRepository.setFirstLastName(firstName,lastName,personId);
    }
}
