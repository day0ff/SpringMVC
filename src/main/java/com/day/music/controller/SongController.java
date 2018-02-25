package com.day.music.controller;

import com.day.music.entity.Song;
import com.day.music.service.SongService;
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
@RequestMapping("/song")
public class SongController {

    final static Logger logger = LoggerFactory.getLogger(AlbumController.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private SongService songService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getPageSong(ModelMap modelMap) {
        String message = messageSource.getMessage("song.song", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return message;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Song saveSong(@RequestBody Song song) {
        String message = messageSource.getMessage("song.save", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return songService.save(song);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void deleteSong(@RequestBody Song song) {
        String message = messageSource.getMessage("song.delete", null,"locale not found", Locale.getDefault());
        logger.info(message);
        songService.delete(song);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<Song> getAllSongs() {
        String message = messageSource.getMessage("song.get.all", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return songService.findAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Song getSongById(@PathVariable("id") long id) {
        String message = messageSource.getMessage("song.get.id", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return songService.findById(id);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    int getSongCount() {
        String message = messageSource.getMessage("song.count", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return songService.getCount();
    }

    @RequestMapping(value = "/update/{songName}/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void updateSongName(@PathVariable("songName") String songName,@PathVariable("id") Long songId) {
        String message = messageSource.getMessage("song.update.name", null,"locale not found", Locale.getDefault());
        logger.info(message);
        songService.setSongName(songName,songId);
    }
}
