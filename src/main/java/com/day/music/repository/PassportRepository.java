package com.day.music.repository;

import com.day.music.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<Passport,Long>{
    Passport findByPassportId(Long passportId);

    @Query(value = "SELECT COUNT(PASSPORT_ID) FROM PASSPORT;",nativeQuery = true)
    int getCount();

    @Modifying(clearAutomatically = true)
    @Query("update Passport passport set passport.passportNumber = ?1 where passport.passportId = ?2")
    void setPassportNumber(String passportNumber, Long passportId);
}
