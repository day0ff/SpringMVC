package com.day.music.service.impl;

import com.day.music.entity.Passport;
import com.day.music.repository.PassportRepository;
import com.day.music.service.PassportService;

//import org.junit.Before;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.times;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PassportImplTest.PassportImplTestContextConfiguration.class})

public class PassportImplTest {
    @Configuration
    static class PassportImplTestContextConfiguration {

        @Bean
        public PassportService passportService() {
            return (PassportService) new PassportImpl();
        }

        @Bean
        public PassportRepository passportRepository() {
            return Mockito.mock(PassportRepository.class);
        }

    }

    @Autowired
    private PassportService passportService;

    @Autowired
    private PassportRepository passportRepository;

    Passport passport = new Passport("1234567890");

    @Before
    public void setup() {
        passport.setPassportId(1L);
        Mockito.when(passportRepository.saveAndFlush(passport)).thenReturn(passport);
        Mockito.doNothing().when(passportRepository).delete(any(Passport.class));
        Mockito.when(passportRepository.findByPassportId(1L)).thenReturn(passport);
    }

    @Test
    public void saveTest() throws Exception {
        assertNotNull(passportService.findById(1L));
        assertSame(passport,passport);
    }

    @Test
    public void deleteTest() throws Exception {
    }

    @Test
    public void findByPassportIdTest() throws Exception {
        assertNotNull(passportService.save(passport));
        assertSame(passport,passport);
    }




}
