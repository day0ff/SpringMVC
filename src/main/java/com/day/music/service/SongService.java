package com.day.music.service;

import com.day.music.entity.Song;

import java.util.List;

public interface SongService {
    Song save(Song song);
    void delete(Song song);
    List<Song> findAll();
    List<Song> findPersonSongs(Long personId);

    Song findById(Long songId);
    int getCount();

    void setSongName(String songName, Long songId);
}
