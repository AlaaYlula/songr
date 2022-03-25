package com.example.songr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Locale;

@Controller
public class HelloController {

    @GetMapping("/")
    String homePage(){

        System.out.println("Get the home page ");
        return "Home";
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

    //////////////////////////////////// Lab 12
    @GetMapping("/error")
    public String errorHandler(){
        return "error";
    }


}
