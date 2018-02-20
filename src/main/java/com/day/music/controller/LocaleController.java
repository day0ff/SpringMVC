package com.day.music.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
@RequestMapping("/")
public class LocaleController {

    final static Logger logger = LoggerFactory.getLogger(LocaleController.class);

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getPageAlbum(ModelMap modelMap) {
        String message = messageSource.getMessage("locale.locale", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return message;
    }

    @RequestMapping(value = "/{locale}", method = RequestMethod.GET)
    @ResponseBody
    public String getLocale(@PathVariable("locale") String locale) {
        Locale.setDefault(new Locale(locale));
        String message = messageSource.getMessage("locale.change", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return message;
    }
}
