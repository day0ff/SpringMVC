package com.day.music.service.impl;

import com.day.music.entity.Song;
import com.day.music.repository.SongRepository;
import com.day.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The class implements the business logic entities of entity Song.
 */
@Service
public class SongImpl implements SongService {
    /**
     * property - set SongRepository bean
     */
    @Autowired
    private SongRepository songRepository;

    /**
     * The method saved song object to database
     *
     * @return saved song
     */
    @Transactional
    @Override
    public Song save(Song song) {
        Song songAdd = songRepository.saveAndFlush(song);
        return songAdd;
    }

    /**
     * The method delete song object from database
     *
     * @return saved song
     */
    @Override
    public void delete(Song song) {
        songRepository.delete(song);
    }

    /**
     * The method get song objects from database
     *
     * @return song list
     */
    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    /**
     * The method return person songs list from database
     *
     * @return songs list
     */
    @Override
    public List<Song> findPersonSongs(Long personId) {
        return songRepository.findByPersonPersonId(personId);
    }

    /**
     * The method get song object from database by id
     *
     * @return song
     */
    @Transactional(readOnly = true)
    @Override
    public Song findById(Long songId) {
        return songRepository.findBySongId(songId);
    }

    /**
     * The method return songs count from database
     *
     * @return songs count
     */
    @Override
    public int getCount() {
        return songRepository.getCount();
    }

    /**
     * The method update song title by id
     */
    @Transactional(readOnly = true)
    @Override
    public void setSongName(String songName, Long songId) {
        songRepository.setSongName(songName, songId);
    }
}
