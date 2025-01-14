package com.example.onlinelearning.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/e-learning")
public class HomeController {



    @GetMapping("/courses")
    public String courses(){

        return "registered";
    }

    @GetMapping("/home")
    public String initializeSetup(Model model){

         return "home";
    }

    @GetMapping("/contact")
    public String contactPage(Model model){
        return "contact";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/discover")
    public String discoverPage(){
        return "discover";
    }




    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }











}
