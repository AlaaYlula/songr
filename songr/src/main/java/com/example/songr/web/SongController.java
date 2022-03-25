package com.example.songr.web;

import com.example.songr.domain.Album;
import com.example.songr.domain.Song;
import com.example.songr.infrastructure.AlbumRepository;
import com.example.songr.infrastructure.SongRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;

@Controller
public class SongController {
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    public SongController(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }
    /*
   Delete Song  by Id from Song table by URL
    */
    @ResponseBody
    @GetMapping("/deletesong/{id}")
    public RedirectView deleteSong(@PathVariable Long id){
        songRepository.deleteById(id);
        return new RedirectView("/songs");
    }
    /*
     Delete Song  by Id from Song table By HTML
  */
    @PostMapping("/deletesong")
    public RedirectView deleteSongFromAlbum (Long song_id) {
        songRepository.deleteById(song_id);
        return new RedirectView("/songs");
    }
    /*
    Get all songs in table Song in JSON Format
     */
    @ResponseBody
    @GetMapping("/allsongs")
    public List<Song> GetAllSongs(){
        return songRepository.findAll();
    }
    /*
  render the songs in table Song to the HTML web page
   */
    @GetMapping("/songs")
    public String getAllSongs(Model model){
        model.addAttribute("songsList",songRepository.findAll());
        model.addAttribute("albumsList",albumRepository.findAll()); /////////////////// Add this for option
        return "song";
    }
    /*
    Add Song to the Album and to the Song table by URL
     */
    @ResponseBody
    @PostMapping("/album/{id}")
    public Song addNewSongToAlbum(@RequestBody Song song, @PathVariable Long id) {
        Album album = albumRepository.findById(id).orElseThrow();
//        int songcount = album.getSongCount();
//        double length = album.getLength();
//        album.setSongCount(songcount++);
//        album.setLength(length+song.getLength());
//        List<Song> songsAlbum = album.getSongs();
//        System.out.println(songsAlbum);
//        songsAlbum.add(song);
//        System.out.println(songsAlbum.toString());
//
//        album.setSongs(songsAlbum);
        song.setAlbum(album);
        return songRepository.save(song);
    }
    /*
  Add Song to the table and to specific album by HTML
   */
    @PostMapping("/song")
    public RedirectView createNewSong(
            @RequestParam long album,
            @ModelAttribute  Song song
    ) {
        Album foundAlbum = albumRepository.findById(album).orElseThrow();
        song.setAlbum(foundAlbum);
        songRepository.save(song);
        return new RedirectView("/songs");
    }


}
