package com.day.music.service;

import com.day.music.entity.Passport;

import java.util.List;

public interface PassportService {
    Passport save(Passport passport);
    void delete(Passport passport);
    List<Passport> findAll();
    Passport findById(Long passportId);
    int getCount();

    void setPassportNumber(String passportNumber, Long passportId);
}
