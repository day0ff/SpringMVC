package com.day.music.controller;

import com.day.music.entity.Album;
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

@Controller
@RequestMapping("/album")
public class AlbumController {

    final static Logger logger = LoggerFactory.getLogger(AlbumController.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private AlbumService albumService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getPageAlbum(ModelMap modelMap) {
        String message = messageSource.getMessage("album.album", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return message;
    }

    //    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Album saveAlbum(@RequestBody Album album) {
        String message = messageSource.getMessage("album.save", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return albumService.save(album);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void deleteAlbum(@RequestBody Album album) {
        String message = messageSource.getMessage("album.delete", null,"locale not found", Locale.getDefault());
        logger.info(message);
        albumService.delete(album);
    }

    //    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<Album> getAllAlbums() {
        String message = messageSource.getMessage("album.get.all", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return albumService.findAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Album getAlbumById(@PathVariable("id") long id) {
        String message = messageSource.getMessage("album.get.id", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return albumService.findById(id);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    int getAlbumCount() {
        String message = messageSource.getMessage("album.count", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return albumService.getCount();
    }

    @RequestMapping(value = "/update/{price}/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void updateAlbumPrice(@PathVariable("price") int albumPrice, @PathVariable("name") String albumName) {
        String message = messageSource.getMessage("album.update.price", null,"locale not found", Locale.getDefault());
        logger.info(message);
        albumService.setAlbumPrice(albumPrice, albumName);
    }

}
