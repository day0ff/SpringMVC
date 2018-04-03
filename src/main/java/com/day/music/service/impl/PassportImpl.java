package com.day.music.service.impl;

import com.day.music.entity.Passport;
import com.day.music.repository.PassportRepository;
import com.day.music.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * The class implements the business logic entities of entity Passport.
 */
@Service
public class PassportImpl implements PassportService {
    /**
     * property - set PassportRepository bean
     */
    @Autowired
    private PassportRepository passportRepository;
    /**
     * The method saved passport object to database
     *
     * @return saved passport
     */
    @Transactional
    @Override
    public Passport save(Passport passport) {
        return passportRepository.saveAndFlush(passport);
    }
    /**
     * The method delete passport object from database
     *
     * @return saved passport
     */
    @Transactional
    @Override
    public void delete(Passport passport) {
        passportRepository.delete(passport);
    }
    /**
     * The method get passport objects from database
     *
     * @return passport list
     */
    @Override
    public List<Passport> findAll() {
        return passportRepository.findAll();
    }
    /**
     * The method get passport object from database by id
     *
     * @return passport
     */
    @Transactional(readOnly = true)
    @Override
    public Passport findById(Long passportId) {
        return passportRepository.findByPassportId(passportId);
    }
    /**
     * The method return passports count from database
     *
     * @return passports count
     */
    @Override
    public int getCount() {
        return passportRepository.getCount();
    }
    /**
     * The method update passport number by id
     */
    @Transactional(readOnly = true)
    @Override
    public void setPassportNumber(String passportNumber, Long passportId) {
        passportRepository.setPassportNumber(passportNumber,passportId);
    }
}
