package com.example.songr.web;

import com.example.songr.domain.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class HelloController {

    @GetMapping("/")
    String homePage(){

        System.out.println("Get the home page ");
        return "index";
    }
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
}
