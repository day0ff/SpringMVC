package com.day.music.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Locale;

/**
 * The class story configs and configure the view resolver
 */
@Configuration
@Import({DataConfig.class, LocaleConfig.class, SecurityConfig.class, DataConfig.class})
public class AppConfig {
    /**
     * property - set logger
     */
    final static Logger logger = LoggerFactory.getLogger(AppConfig.class);
    /**
     * property - set MessageSource bean
     */
    @Autowired
    private MessageSource messageSource;
    /**
     * The method сreate a new bean object view resolver
     *
     * @return InternalResourceViewResolver
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        String message = messageSource.getMessage("begin", null, "locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("config.app", null, "locale not found", Locale.getDefault());
        logger.info(message);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        message = messageSource.getMessage("end", null, "locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("config.app", null, "locale not found", Locale.getDefault());
        logger.info(message);
        return viewResolver;
    }


}