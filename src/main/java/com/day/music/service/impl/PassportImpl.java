package com.day.music.service.impl;

import com.day.music.entyti.Passport;
import com.day.music.repository.PassportRepository;
import com.day.music.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PassportImpl implements PassportService {

    @Autowired
    private PassportRepository passportRepository;

    @Transactional
    @Override
    public Passport save(Passport passport) {
        Passport passportAdd = passportRepository.saveAndFlush(passport);
        return passportAdd;
    }

    @Transactional
    @Override
    public void delete(Passport passport) {
        passportRepository.delete(passport);
    }

    @Override
    public List<Passport> findAll() {
        return passportRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Passport findById(Long passportId) {
        return passportRepository.findByPassportId(passportId);
    }

    @Override
    public int getCount() {
        return passportRepository.getCount();
    }

    @Transactional(readOnly = true)
    @Override
    public void setPassportNumber(String passportNumber, Long passportId) {
        passportRepository.setPassportNumber(passportNumber,passportId);
    }
}
