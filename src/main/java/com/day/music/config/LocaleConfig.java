package com.day.music.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;


@Configuration
public class LocaleConfig {

    final static Logger logger = LoggerFactory.getLogger(LocaleConfig.class);

    @Bean
    public MessageSource messageSource () {
       logger.info("Begin Message Source");
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("locale");
        messageSource.setDefaultEncoding("UTF-8");
        logger.info("End Message Source");
        return messageSource;
    }
}
