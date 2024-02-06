package com.example.foodrecipie.controller;

import com.example.foodrecipie.models.Recipe;
import com.example.foodrecipie.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/home")
    public String getAdminHome(Model model){
        model.addAttribute("recipe", new Recipe());
        return "admin_home";
    }

    @PostMapping("/createRecipe")
    public String createRecipe(Model model, @ModelAttribute Recipe recipe){

        // customize
        recipeRepository.save(recipe);
        return "home";
    }
}
