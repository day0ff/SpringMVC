package com.day.music.controller;

import com.day.music.entity.Person;
import com.day.music.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
/**
 * The class controller realizes the business logic entities of entity Person.
 */
@RestController
@CrossOrigin
@RequestMapping("/person")
public class PersonController {
    /**
     * property - set logger
     */
    final static Logger logger = LoggerFactory.getLogger(PersonController.class);
    /**
     * property - set MessageSource bean
     */
    @Autowired
    private MessageSource messageSource;
    /**
     * property - set PersonService bean
     */
    @Autowired
    private PersonService personService;
    /**
     * The method get page name
     *
     * @return current page name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getPagePerson(ModelMap modelMap) {
        String message = messageSource.getMessage("person.person", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return message;
    }
    /**
     * The method saved person object to database
     *
     * @return saved person
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Person savePerson(@RequestBody Person person) {
        String message = messageSource.getMessage("person.save", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return personService.save(person);
    }
    /**
     * The method delete person object from database
     *
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    void deletePerson(@RequestBody Person person) {
        String message = messageSource.getMessage("person.delete", null,"locale not found", Locale.getDefault());
        logger.info(message);
        personService.delete(person);
    }
    /**
     * The method get person objects from database
     *
     * @return person list
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Person> getAllPersons() {
        String message = messageSource.getMessage("person.get.all", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return personService.findAll();
    }
    /**
     * The method get person object from database by id
     *
     * @return person
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable("id") long id) {
        String message = messageSource.getMessage("person.get.id", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return personService.findById(id);
    }
    /**
     * The method return persons count from database
     *
     * @return persons count
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    int getPersonCount() {
        String message = messageSource.getMessage("person.count", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return personService.getCount();
    }
    /**
     * The method update person first and last name by id
     */
    @RequestMapping(value = "/update/{firstName}/{LastName}/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void updatePersonFirstLastName(@PathVariable("firstName") String firstName,@PathVariable("LastName") String lastName,@PathVariable("id") Long personId) {
        String message = messageSource.getMessage("person.update.names", null,"locale not found", Locale.getDefault());
        logger.info(message);
        personService.setFirstLastName(firstName,lastName,personId);
    }
}
