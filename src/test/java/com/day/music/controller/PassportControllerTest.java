package com.day.music.controller;

import com.day.music.config.PassportControllerTestConfig;
import com.day.music.entity.Passport;
import com.day.music.service.PassportService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PassportControllerTestConfig.class})
@WebAppConfiguration
public class PassportControllerTest {
    private MockMvc mockMvc;

    private Passport passport = new Passport("1234567890");


    @Autowired
    private MessageSource messageSource;

    @Autowired
    private PassportService passportService;

    @Autowired
    private PassportController passportController;

    @Autowired
    private MediaType application_JSON_UTF8;

/*    @Autowired
    private ObjectMapper objectMapper;*/

    private static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(passportController).build();
        passport.setPassportId(1L);
        Mockito.when(passportService.findById(1L)).thenReturn(passport);
        Mockito.doNothing().when(passportService).delete(any());
        Mockito.when(passportService.save(any())).thenReturn(passport);
        Mockito.doNothing().when(passportService).setPassportNumber("MNBVCXZ",1L);
        List<Passport> passports = new ArrayList<>();
        passports.add(new Passport("12312312123"));
        passports.add(new Passport("sdffqefeffq"));
        passports.add(new Passport("DQ31iuHd4fR"));
        passports.add(new Passport("4JFW32HFH34"));
        Mockito.when(passportService.findAll()).thenReturn(passports);
        Mockito.when(passportService.getCount()).thenReturn(4);
    }

    @Test
    public void getPagePassportTest() throws Exception {
        mockMvc.perform(get("/passport"))
                .andExpect(status().isOk());
    }

    @Test
    public void savePassportTest() throws Exception {
        passport.setPassportNumber("QWERTY");
        mockMvc.perform(post("/passport/save")
                .content(convertObjectToJsonBytes(passport))
                .contentType(application_JSON_UTF8)
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(application_JSON_UTF8))
                .andExpect(jsonPath("$.passportId", is(1)))
                .andExpect(jsonPath("$.passportNumber", is("QWERTY")));
        Mockito.verify(passportService, times(1)).save(any());
        Mockito.verifyNoMoreInteractions(passportService);
    }

    @Test
    public void deletePassportTest() throws Exception {
        mockMvc.perform(post("/passport/delete")
                .content(convertObjectToJsonBytes(passport))
                .contentType(application_JSON_UTF8)
        )
                .andExpect(status().isOk());
        Mockito.verify(passportService, times(1)).delete(any());
        Mockito.verifyNoMoreInteractions(passportService);
    }

    @Test
    public void getPassportCountTest() throws Exception {
        mockMvc.perform(get("/passport/count"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(application_JSON_UTF8))
                .andExpect(jsonPath("$", is(4)));
        Mockito.verify(passportService, times(1)).getCount();
        Mockito.verifyNoMoreInteractions(passportService);
    }

    @Test
    public void updatePassportNumberTest() throws Exception {
        mockMvc.perform(get("/passport/update/{number}/{id}", "MNBVCXZ",1L))
                .andExpect(status().isOk());
        Mockito.verify(passportService, times(1)).setPassportNumber("MNBVCXZ",1L);
        Mockito.verifyNoMoreInteractions(passportService);
    }

    @Test
    public void getPassportByIdTest() throws Exception {
        mockMvc.perform(get("/passport/get/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(application_JSON_UTF8))
                .andExpect(jsonPath("$.passportId", is(1)))
                .andExpect(jsonPath("$.passportNumber", is("1234567890")));
        Mockito.verify(passportService, times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(passportService);
    }

    @Test
    public void getAllPassportsTest() throws Exception {
        mockMvc.perform(get("/passport/get"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(application_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].passportNumber", is("12312312123")))
                .andExpect(jsonPath("$[1].passportNumber", is("sdffqefeffq")))
                .andExpect(jsonPath("$[2].passportNumber", is("DQ31iuHd4fR")))
                .andExpect(jsonPath("$[3].passportNumber", is("4JFW32HFH34")));
        Mockito.verify(passportService, times(1)).findAll();
        Mockito.verifyNoMoreInteractions(passportService);
    }
}
