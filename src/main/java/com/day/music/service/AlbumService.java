package com.day.music.service;

import com.day.music.entity.Album;
import com.day.music.entity.Song;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface AlbumService {
    Album save(Album album);
    void delete(Album album);
    List<Album> findAll();
    Album findById(Long id);
    int getCount();
    void setAlbumPrice(int albumPrice, String albumName);
}
