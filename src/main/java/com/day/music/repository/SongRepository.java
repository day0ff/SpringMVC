package com.day.music.repository;

import com.day.music.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long>{
    Song findBySongId(Long songId);

    List<Song> findByPersonPersonId(Long personId);

    @Query(value = "SELECT COUNT(SONG_ID) FROM SONG;",nativeQuery = true)
    int getCount();

    @Modifying(clearAutomatically = true)
    @Query("update Song song set song.songName = ?1 where song.songId = ?2")
    void setSongName(String songName, Long songId);

}
