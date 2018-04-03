package com.day.music.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * The class create and configure the web MVC
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.day.music")
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * property - set logger
     */
    final static Logger logger = LoggerFactory.getLogger(WebConfig.class);
    /**
     * property - set MessageSource bean
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * The method сreate a new bean object message converter
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        String message = messageSource.getMessage("begin", null, "locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("config.web", null, "locale not found", Locale.getDefault());
        logger.info(message);
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        converters.add(converter);
        message = messageSource.getMessage("end", null, "locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("config.web", null, "locale not found", Locale.getDefault());
        logger.info(message);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("*").addResourceLocations("");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.addViewController("/home/*").setViewName("forward:/index.html");
        registry.addViewController("/albums/*").setViewName("forward:/index.html");
        registry.addViewController("/persons/*").setViewName("forward:/index.html");
        registry.addViewController("/passports/*").setViewName("forward:/index.html");
        registry.addViewController("/songs/*").setViewName("forward:/index.html");
        registry.addViewController("/albums/detail/*").setViewName("forward:/index.html");
        registry.addViewController("/persons/detail/*").setViewName("forward:/index.html");
        registry.addViewController("/passports/detail/*").setViewName("forward:/index.html");
        registry.addViewController("/songs/detail/*").setViewName("forward:/index.html");
        registry.addViewController("/registration/*").setViewName("forward:/index.html");
    }
}

