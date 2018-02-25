package com.day.music.repository;

import com.day.music.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{
   Person findByPersonId(Long personId);

    @Query(value = "SELECT COUNT(PERSON_ID) FROM PERSON;",nativeQuery = true)
    int getCount();

    @Modifying(clearAutomatically = true)
    @Query("update Person person set person.firstName = ?1, person.lastName = ?2 where person.personId = ?3")
    void setFirstLastName(String firstName, String lastName, Long personId);
}
