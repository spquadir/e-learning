package com.example.onlinelearning.controller;


import com.example.onlinelearning.models.RecipeModel;
import com.example.onlinelearning.repository.CategoryRepository;
import com.example.onlinelearning.repository.ImageRepository;
import com.example.onlinelearning.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;
import java.util.List;

@Controller
@RequestMapping("/e-learning")
public class HomeController {




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
