package com.day.music.controller;

import com.day.music.entyti.Person;
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

@Controller
@RequestMapping("/person")
public class PersonController {

    final static Logger logger = LoggerFactory.getLogger(AlbumController.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getPagePerson(ModelMap modelMap) {
        String message = messageSource.getMessage("person.person", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return message;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Person savePerson(@RequestBody Person person) {
        String message = messageSource.getMessage("person.save", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return personService.save(person);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void deletePerson(@RequestBody Person person) {
        String message = messageSource.getMessage("person.delete", null,"locale not found", Locale.getDefault());
        logger.info(message);
        personService.delete(person);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getAllPersons() {
        String message = messageSource.getMessage("person.get.all", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return personService.findAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Person getPersonById(@PathVariable("id") long id) {
        String message = messageSource.getMessage("person.get.id", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return personService.findById(id);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    int getPersonCount() {
        String message = messageSource.getMessage("person.count", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return personService.getCount();
    }

    @RequestMapping(value = "/update/{firstName}/{LastName}/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void updatePersonFirstLastName(@PathVariable("firstName") String firstName,@PathVariable("LastName") String lastName,@PathVariable("id") Long personId) {
        String message = messageSource.getMessage("person.update.names", null,"locale not found", Locale.getDefault());
        logger.info(message);
        personService.setFirstLastName(firstName,lastName,personId);
    }
}
