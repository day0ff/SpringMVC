package com.day.music.service.impl;

import com.day.music.entity.Album;
import com.day.music.repository.AlbumRepository;
import com.day.music.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The class implements the business logic entities of entity Album.
 */
@Service
public class AlbumImpl implements AlbumService {
    /**
     * property - set AlbumRepository bean
     */
    @Autowired
    private AlbumRepository albumRepository;

    /**
     * The method saved album object to database
     *
     * @return saved album
     */
    @Transactional
    @Override
    public Album save(Album album) {
        return albumRepository.saveAndFlush(album);
    }

    /**
     * The method delete album object from database
     *
     * @return saved album
     */
    @Transactional
    @Override
    public void delete(Album album) {
        albumRepository.delete(album);
    }

    /**
     * The method get album objects from database
     *
     * @return album list
     */
    @Transactional
    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    /**
     * The method get album object from database by id
     *
     * @return album
     */
    @Override
    public Album findById(Long album_id) {
        return albumRepository.findByAlbumId(album_id);
    }

    /**
     * The method return albums count from database
     *
     * @return albums count
     */
    @Override
    public int getCount() {
        return albumRepository.getCount();
    }

    /**
     * The method set album price
     */
    @Transactional(readOnly = true)
    @Override
    public void setAlbumPrice(int albumPrice, String albumName) {
        albumRepository.setPrice(albumPrice, albumName);
    }

}
