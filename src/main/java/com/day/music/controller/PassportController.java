package com.day.music.controller;

import com.day.music.entity.Passport;
import com.day.music.service.PassportService;
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
 * The class controller realizes the business logic entities of entity Passport.
 */
@RestController
@CrossOrigin
@RequestMapping("/passport")
public class PassportController {
    /**
     * property - set logger
     */
    final static Logger logger = LoggerFactory.getLogger(PassportController.class);
    /**
     * property - set MessageSource bean
     */
    @Autowired
    private MessageSource messageSource;
    /**
     * property - set PassportService bean
     */
    @Autowired
    private PassportService passportService;
    /**
     * The method get page name
     *
     * @return current page name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getPagePassport(ModelMap modelMap) {
        String message = messageSource.getMessage("passport.passport", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return message;
    }
    /**
     * The method saved passport object to database
     *
     * @return saved passport
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Passport savePassport(@RequestBody Passport passport) {
        String message = messageSource.getMessage("passport.save", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return passportService.save(passport);
    }
    /**
     * The method delete passport object from database
     *
     * @return saved passport
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    void deletePassport(@RequestBody Passport passport) {
        String message = messageSource.getMessage("passport.delete", null,"locale not found", Locale.getDefault());
        logger.info(message);
        passportService.delete(passport);
    }
    /**
     * The method get passport objects from database
     *
     * @return passport list
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Passport> getAllPassports() {
        String message = messageSource.getMessage("passport.get.all", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return passportService.findAll();
    }
    /**
     * The method get passport object from database by id
     *
     * @return passport
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Passport getPassportById(@PathVariable("id") long id) {
        String message = messageSource.getMessage("passport.get.id", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return passportService.findById(id);
    }
    /**
     * The method return passports count from database
     *
     * @return passports count
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    int getPassportCount() {
        String message = messageSource.getMessage("passport.count", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return passportService.getCount();
    }
    /**
     * The method update passport number by id
     */
    @RequestMapping(value = "/update/{number}/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    void updatePassportNumber(@PathVariable("number") String passportNumber, @PathVariable("id") Long passportId) {
        String message = messageSource.getMessage("passport.update.number", null,"locale not found", Locale.getDefault());
        logger.info(message);
        passportService.setPassportNumber(passportNumber, passportId);
    }
}
