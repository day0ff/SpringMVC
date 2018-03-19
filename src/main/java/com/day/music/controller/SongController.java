package com.day.music.controller;

import com.day.music.entity.Song;
import com.day.music.service.SongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
/**
 * The class controller realizes the business logic entities of entity Song.
 */
@RestController
@CrossOrigin
@RequestMapping("/song")
public class SongController {
    /**
     * property - set logger
     */
    final static Logger logger = LoggerFactory.getLogger(SongController.class);
    /**
     * property - set MessageSource bean
     */
    @Autowired
    private MessageSource messageSource;
    /**
     * property - set SongService bean
     */
    @Autowired
    private SongService songService;
    /**
     * The method get page name
     *
     * @return current page name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getPageSong(ModelMap modelMap) {
        String message = messageSource.getMessage("song.song", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return message;
    }
    /**
     * The method saved song object to database
     *
     * @return saved song
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Song saveSong(@RequestBody Song song) {
        String message = messageSource.getMessage("song.save", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return songService.save(song);
    }
    /**
     * The method delete song object from database
     *
     * @return saved song
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    void deleteSong(@RequestBody Song song) {
        String message = messageSource.getMessage("song.delete", null,"locale not found", Locale.getDefault());
        logger.info(message);
        songService.delete(song);
    }
    /**
     * The method get song objects from database
     *
     * @return song list
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Song> getAllSongs() {
        String message = messageSource.getMessage("song.get.all", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return songService.findAll();
    }
    /**
     * The method get song object from database by id
     *
     * @return song
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Song getSongById(@PathVariable("id") long id) {
        String message = messageSource.getMessage("song.get.id", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return songService.findById(id);
    }
    /**
     * The method return person songs list from database
     *
     * @return songs list
     */
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public List<Song> getPersonSongs(@PathVariable("id") long id) {
        String message = messageSource.getMessage("song.find.id", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return songService.findPersonSongs(id);
    }
    /**
     * The method return songs count from database
     *
     * @return songs count
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    int getSongCount() {
        String message = messageSource.getMessage("song.count", null,"locale not found", Locale.getDefault());
        logger.info(message);
        return songService.getCount();
    }
    /**
     * The method update song title by id
     */
    @RequestMapping(value = "/update/{songName}/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void updateSongName(@PathVariable("songName") String songName,@PathVariable("id") Long songId) {
        String message = messageSource.getMessage("song.update.name", null,"locale not found", Locale.getDefault());
        logger.info(message);
        songService.setSongName(songName,songId);
    }
}
