package com.day.music.repository;

import com.day.music.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {

    Album findByAlbumId(Long albumId);

    @Query(value = "SELECT COUNT(ALBUM_ID) FROM ALBUM;",nativeQuery = true)
    int getCount();

    @Modifying(clearAutomatically = true)
    @Query("update Album album set album.albumPrice = ?1 where album.albumName = ?2")
    void setPrice(int albumPrice, String albumName);

}
