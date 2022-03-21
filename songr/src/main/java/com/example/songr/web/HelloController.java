package com.example.songr.web;

import com.example.songr.domain.Album;
import com.example.songr.infrastructure.AlbumRepository;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.tokens.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class HelloController {

    @Autowired
    AlbumRepository albumRepository;


//    @GetMapping("/")
//    String homePage(){
//
//        System.out.println("Get the home page ");
//        return "index";
//    }
    @GetMapping("/hello")
    String helloWord(@RequestParam(name="name" , required = false , defaultValue = "") String name, Model model){

        System.out.println("Get the Hello ");
        model.addAttribute("name",name); // add query parameter ?name=YourName
        return "hello";
    }

    @GetMapping("/capitalize/{word}")
    String capitalizeWord(@PathVariable  String word , Model model ){

        model.addAttribute("word",word.toUpperCase(Locale.ROOT));
        return "capitalize";
    }

    @ResponseBody
    @GetMapping("/albums")
    List<Album> GetAllAlbums(){
      List<Album> albums = new ArrayList<>();
      albums.add(new Album("Live Forever","Bartees Strange",10,10,"https://www.rollingstone.com/wp-content/uploads/2020/12/Bartees-Strange-Live-Forever.jpg?w=1000"));
      albums.add(new Album("Love Is the King","Jeff Tweedy",10,10,"https://www.rollingstone.com/wp-content/uploads/2020/12/Jeff-Tweedy-Love-is-the-King.jpg?w=1000"));
      albums.add(new Album("Growth","Kareem Ali",10,10,"https://www.rollingstone.com/wp-content/uploads/2020/12/Kareem-Ali-Growth.jpg?w=1000"));

      return albums;
    }

    //////////////////////////////////// Lab 12
    @GetMapping("/error")
    public String errorHandler(){
        return "error";
    }
    @PostMapping("/addalbum")
    public RedirectView createNewAlbum(@ModelAttribute Album album){ //modelAttribute when working with forms
       // System.out.println("**********************");
        //System.out.println(album);
        albumRepository.save(album);
        return new RedirectView("allalbums");
    }

    @GetMapping("/allalbums")
    public String getAllAlbums(Model model){
        model.addAttribute("albumsList",albumRepository.findAll());
        return "index";
    }
    @GetMapping("/delete/{id}")
    public RedirectView deleteAlbum(@PathVariable Integer id){
        albumRepository.deleteById(id);
        return new RedirectView("/allalbums");
    }
//    @GetMapping("/delete")
//    public RedirectView deleteAlbum(@ModelAttribute String title){ //modelAttribute when working with forms
//        System.out.println("****************************** "+ title);
//        albumRepository.deleteBytitle(title);
//        return new RedirectView("/allalbums");
//    }



}
