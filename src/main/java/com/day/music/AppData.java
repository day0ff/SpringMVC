package com.day.music;

import com.day.music.config.DataConfig;
import com.day.music.entity.Album;
import com.day.music.entity.Passport;
import com.day.music.entity.Person;
import com.day.music.entity.Song;
import com.day.music.service.AlbumService;
import com.day.music.service.PassportService;
import com.day.music.service.PersonService;
import com.day.music.service.SongService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The main class. The entry point of the program.
 */
public class AppData {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);

        PassportService passportService = context.getBean(PassportService.class);
        PersonService personService = context.getBean(PersonService.class);
        SongService songService = context.getBean(SongService.class);
        AlbumService albumService = context.getBean(AlbumService.class);

        Passport passport = passportService.save(new Passport("BLR3KH11051985N9342742"));
        System.out.println("Passport  have been saved to data base: " + passport.toString());

        Person person = personService.save(new Person("James", "Cammeron", passport));
        System.out.println("Person    have been saved to data base: " + person.toString());

        Song song1 = songService.save(new Song("Love for You", person));
        person.getSongs().add(song1);
        System.out.println("Song      have been saved to data base: " + song1.toString());

        Song song2 = songService.save(new Song("One more Time", person));
        person.getSongs().add(song2);
        System.out.println("Song      have been saved to data base: " + song2.toString());

        Song song3 = songService.save(new Song("Uha-ha", person));
        person.getSongs().add(song3);
        System.out.println("Song      have been saved to data base: " + song3.toString());

        Album album1 = albumService.save(new Album("Loving You", 5));
        album1.getSongs().add(song1);
        album1.getSongs().add(song3);
        System.out.println("Album     have been saved to data base: " + album1.toString());

        Album album2 = albumService.save(new Album("Loving You", 9));
        album2.getSongs().add(song1);
        album2.getSongs().add(song2);
        album2.getSongs().add(song3);
        System.out.println("Album     have been saved to data base: " + album2.toString());


        albumService.setAlbumPrice(11, "Loving You");
        System.out.println("Update Album Price");

        passportService.setPassportNumber("USA12KSU3244428",2L);
        System.out.println("Update Passport Number");

        personService.setFirstLastName("Simpl","Exit",1L);
        System.out.println("Update Person First and Last Names");

        songService.setSongName("Forever alone",5L);
        System.out.println("Update Song Name");

        System.out.println("Select Album By Id : " + albumService.findById(3L));
        System.out.println("Select Passport By Id : " + passportService.findById(1L));
        System.out.println("Select Person By Id : " + personService.findById(2L));
        System.out.println("Select Song By Id : " + songService.findById(6L));

        albumService.delete(album2);
        System.out.println("Delete Album");
        //passportService.delete(passport);
        System.out.println("Delete Passport");
        //personService.delete(person);
        System.out.println("Delete Person");
        songService.delete(song3);
        System.out.println("Delete Song");


        System.out.println("Find all Albums");
        for (Album album : albumService.findAll()) {
            System.out.println(album);
        }
        System.out.println("Album Count Lines : " + albumService.getCount());

        System.out.println("Find all Passport");
        for (Passport passport1 : passportService.findAll()) {
            System.out.println(passport1);
        }
        System.out.println("Passport Count Lines : " + passportService.getCount());

        System.out.println("Find all Person");
        personService.findAll().forEach(System.out::println);

        System.out.println("Person Count Lines : " + personService.getCount());

        System.out.println("Find all Song");
        songService.findAll().forEach(System.out::println);
        System.out.println("Person Count Lines : " + songService.getCount());

        context.close();
    }
}
