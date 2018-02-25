package com.day.music.service.impl;

import com.day.music.entity.Song;
import com.day.music.repository.SongRepository;
import com.day.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SongImpl implements SongService{

    @Autowired
    private SongRepository songRepository;

    @Transactional
    @Override
    public Song save(Song song) {
        Song songAdd = songRepository.saveAndFlush(song);
        return songAdd;
    }

    @Override
    public void delete(Song song) {
        songRepository.delete(song);
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Song findById(Long songId) {
        return songRepository.findBySongId(songId);
    }

    @Override
    public int getCount() {
        return songRepository.getCount();
    }

    @Transactional(readOnly = true)
    @Override
    public void setSongName(String songName, Long songId) {
        songRepository.setSongName(songName,songId);
    }
}
