package com.day.music.service.impl;

import com.day.music.entity.Album;
import com.day.music.repository.AlbumRepository;
import com.day.music.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlbumImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Transactional
    @Override
    public Album save(Album album) {
        return albumRepository.saveAndFlush(album);
    }

    @Transactional
    @Override
    public void delete(Album album) {
        albumRepository.delete(album);
    }

    @Transactional
    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album findById(Long album_id) {
        return albumRepository.findByAlbumId(album_id);
    }

    @Override
    public int getCount() {
        return albumRepository.getCount();
    }

    @Transactional(readOnly = true)
    @Override
    public void setAlbumPrice(int albumPrice, String albumName) {
        albumRepository.setPrice(albumPrice, albumName);
    }

}
