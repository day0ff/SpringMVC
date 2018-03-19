package com.day.music.controller;

import com.day.music.entity.Album;
import com.day.music.entity.Song;
import com.day.music.service.AlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
/**
 * The class controller realizes the business logic entities of entity Album.
 */
@RestController
@CrossOrigin
@RequestMapping("/album")
public class AlbumController {
    /**
     * property - set logger
     */
    final static Logger logger = LoggerFactory.getLogger(AlbumController.class);
    /**
     * property - set MessageSource bean
     */
    @Autowired
    private MessageSource messageSource;
    /**
     * property - set AlbumService bean
     */
    @Autowired
    private AlbumService albumService;
    /**
     * The method get page name
     *
     * @return current page name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getPageAlbum(ModelMap modelMap) {
        String message = messageSource.getMessage("album.album", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return message;
    }
    /**
     * The method saved album object to database
     *
     * @return saved album
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Album saveAlbum(@RequestBody Album album) {
        String message = messageSource.getMessage("album.save", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return albumService.save(album);
    }
    /**
     * The method delete album object from database
     *
     * @return saved album
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    void deleteAlbum(@RequestBody Album album) {
        String message = messageSource.getMessage("album.delete", null,"locale not found", Locale.getDefault());
        logger.info(message);
        albumService.delete(album);
    }
    /**
     * The method get album objects from database
     *
     * @return album list
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Album> getAllAlbums() {
        String message = messageSource.getMessage("album.get.all", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return albumService.findAll();
    }
    /**
     * The method get album object from database by id
     *
     * @return album
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Album getAlbumById(@PathVariable("id") long id) {
        String message = messageSource.getMessage("album.get.id", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return albumService.findById(id);
    }
    /**
     * The method return albums count from database
     *
     * @return albums count
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    int getAlbumCount() {
        String message = messageSource.getMessage("album.count", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return albumService.getCount();
    }
    /**
     * The method update album price by name
     */
    @RequestMapping(value = "/update/{price}/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    void updateAlbumPrice(@PathVariable("price") int albumPrice, @PathVariable("name") String albumName) {
        String message = messageSource.getMessage("album.update.price", null,"locale not found", Locale.getDefault());
        logger.info(message);
        albumService.setAlbumPrice(albumPrice, albumName);
    }
    /**
     * The method get album songs
     *
     * @return song list
     */
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public List<Song> getAlbumSongs(@PathVariable("id") Long id) {
        String message = messageSource.getMessage("album.get.all", null, "locale not found", Locale.getDefault());
        logger.info(message);
        return albumService.findById(id).getSongs();
    }

}
