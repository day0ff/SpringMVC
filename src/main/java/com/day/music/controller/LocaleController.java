package com.day.music.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
/**
 * The class controller realizes the business logic entities of entity Locale.
 */
@RestController
@CrossOrigin
@RequestMapping("/locale")
public class LocaleController {
    /**
     * property - set logger
     */
    final static Logger logger = LoggerFactory.getLogger(LocaleController.class);
    /**
     * property - set MessageSource bean
     */
    @Autowired
    private MessageSource messageSource;
    /**
     * The method get page name
     *
     * @return current page name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getPageAlbum(ModelMap modelMap) {
        String message = messageSource.getMessage("locale.locale", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return message;
    }
    /**
     * The method set locale
     *
     * @return locale
     */
    @RequestMapping(value = "/{locale}", method = RequestMethod.GET)
    public String getLocale(@PathVariable("locale") String locale) {
        Locale.setDefault(new Locale(locale));
        String message = messageSource.getMessage("locale.change", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return message;
    }
}
