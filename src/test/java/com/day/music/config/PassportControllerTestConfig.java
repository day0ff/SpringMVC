package com.day.music.config;

import com.day.music.controller.PassportController;
import com.day.music.service.PassportService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.nio.charset.Charset;

import static org.mockito.Mockito.mock;

@EnableWebMvc
@Configuration
public class PassportControllerTestConfig {

    @Bean
    public MessageSource messageSource() {
        return mock(MessageSource.class);
    }

    @Bean
    public PassportController passportController() {
        return new PassportController();
    }

    @Bean
    public PassportService passportService() {
        return mock(PassportService.class);
    }

/*    @Bean
    public ObjectMapper objectMapper(){
        return mock(ObjectMapper.class);
    }*/

    @Bean
    public MediaType application_JSON_UTF8() {
        return new MediaType(MediaType.APPLICATION_JSON.getType(),
                MediaType.APPLICATION_JSON.getSubtype(),
                Charset.forName("utf8")
        );
    }

}
