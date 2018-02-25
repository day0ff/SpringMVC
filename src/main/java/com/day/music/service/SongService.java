package com.day.music.service;

import com.day.music.entity.Song;

import java.util.List;

public interface SongService {
    Song save(Song song);
    void delete(Song song);
    List<Song> findAll();
    Song findById(Long songId);
    int getCount();

    void setSongName(String songName, Long songId);
}
