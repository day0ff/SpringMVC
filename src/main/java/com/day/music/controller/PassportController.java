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

@Controller
@RequestMapping("/passport")
public class PassportController {

    final static Logger logger = LoggerFactory.getLogger(AlbumController.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private PassportService passportService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getPagePassport(ModelMap modelMap) {
        String message = messageSource.getMessage("passport.passport", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return message;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Passport savePassport(@RequestBody Passport passport) {
        String message = messageSource.getMessage("passport.save", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return passportService.save(passport);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void deletePassport(@RequestBody Passport passport) {
        String message = messageSource.getMessage("passport.delete", null,"locale not found", Locale.getDefault());
        logger.info(message);
        passportService.delete(passport);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<Passport> getAllPassports() {
        String message = messageSource.getMessage("passport.get.all", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return passportService.findAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Passport getPassportById(@PathVariable("id") long id) {
        String message = messageSource.getMessage("passport.get.id", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return passportService.findById(id);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    int getPassportCount() {
        String message = messageSource.getMessage("passport.count", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return passportService.getCount();
    }

    @RequestMapping(value = "/update/{number}/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void updatePassportNumber(@PathVariable("number") String passportNumber, @PathVariable("id") Long passportId) {
        String message = messageSource.getMessage("passport.update.number", null,"locale not found", Locale.getDefault());
        logger.info(message);
        passportService.setPassportNumber(passportNumber, passportId);
    }
}
