package com.example.songr.web;

import com.example.songr.domain.Album;
import com.example.songr.domain.Song;
import com.example.songr.infrastructure.AlbumRepository;
import com.example.songr.infrastructure.SongRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumController {
    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;

    public AlbumController(AlbumRepository albumRepository, SongRepository songRepository) {
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }
    @ResponseBody
    @GetMapping("/newalbums")
    List<Album> GetAllAlbums(){
        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Live Forever","Bartees Strange",10,10,"https://www.rollingstone.com/wp-content/uploads/2020/12/Bartees-Strange-Live-Forever.jpg?w=1000"));
        albums.add(new Album("Love Is the King","Jeff Tweedy",10,10,"https://www.rollingstone.com/wp-content/uploads/2020/12/Jeff-Tweedy-Love-is-the-King.jpg?w=1000"));
        albums.add(new Album("Growth","Kareem Ali",10,10,"https://www.rollingstone.com/wp-content/uploads/2020/12/Kareem-Ali-Growth.jpg?w=1000"));

        return albums;
    }

    /*
   Add album to the table
    */
    @PostMapping("/album")
    public RedirectView createNewAlbum(@ModelAttribute Album album){ //modelAttribute when working with forms
        albumRepository.save(album);
        return new RedirectView("albums");
    }
    /*
    List All the albums in the table Album
     */
    @ResponseBody
    @GetMapping("/allalbums") ///////////////////////////// to see the songs in albums //////////////////
    public List<Album> getAllAlbums(){
        return albumRepository.findAll();
    }
    /*
   render the albums in table Album to the HTML web page
    */
    @GetMapping("/albums")
    public String getAllAlbums(Model model){
        model.addAttribute("albumsList",albumRepository.findAll());
        return "index";
    }
    /*
    render album by Id in the table Album
     */
    @ResponseBody
    @GetMapping("/album/{id}")
    public Album getAlbum(@PathVariable Long id){
        Album album = albumRepository.findById(id).orElseThrow();
        System.out.println(album);
        return album;
    }

    /*
    Delete album From the Table Album
     */
    @GetMapping("/delete/{id}")
    public RedirectView deleteAlbum(@PathVariable Long id){
        // check if there is songs in the Album so not throw exception //
        Album album = albumRepository.findById(id).orElseThrow();
        List<Song> songsAlbum = album.getSongs();
        if(!songsAlbum.isEmpty()){
            for (Song song : songsAlbum) {
                Long song_id = song.getId();
                songRepository.deleteById(song_id);
            }
        }
        albumRepository.deleteById(id);
        return new RedirectView("/albums");
    }

  /*
     Delete album  by Id from album table By HTML
  */
    @PostMapping("/deletealbum")
    public RedirectView deleteSongFromAlbum (Long album_id) {
        // check if there is songs in the Album so not throw exception //
        Album album = albumRepository.findById(album_id).orElseThrow();
        List<Song> songsAlbum = album.getSongs();
        if(!songsAlbum.isEmpty()){
            for (Song song : songsAlbum) {
                Long song_id = song.getId();
                songRepository.deleteById(song_id);
            }
        }
        albumRepository.deleteById(album_id);
        return new RedirectView("/albums");
    }

    @GetMapping("/albumDetails")
    public String GetAlbum(Model model){
        model.addAttribute("albumsList",albumRepository.findAll());
        return "albumdetail";
    }
    @PostMapping("/album/details")
    public String GetAlbumDetails(@RequestParam long album, Model model) {
//        List<Album> albums = albumRepository.findAll();
//        for (Album albumElement : albums) {
//            Long album_id = albumElement.getId();
//            if(album_id == album){
//                model.addAttribute("album1",albumElement);
//        model.addAttribute("songsList", songRepository.findByAlbumId(album_id));
//
//            }
//        }
        Album foundAlbum = albumRepository.findById(album).orElseThrow();
        System.out.println("**************"+foundAlbum);
        List<Song> songsAlbum = foundAlbum.getSongs();
        if(songsAlbum.isEmpty()){
            System.out.println("********************** Empty Songs ****************");
            model.addAttribute("album2",foundAlbum);
        }else {
            System.out.println("**********************Not  Empty Songs ****************");

            model.addAttribute("album1", foundAlbum);
            model.addAttribute("songsList", songRepository.findByAlbumId(foundAlbum.getId()));

        }
        model.addAttribute("albumsList",albumRepository.findAll());

      //   return new RedirectView("/albumDetails");
    return "albumdetail";
    }
}
