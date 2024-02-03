package com.example.foodrecipie.controller;

import com.example.foodrecipie.models.Category;
import com.example.foodrecipie.models.Recipe;
import com.example.foodrecipie.repository.CategoryRepository;
import com.example.foodrecipie.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/home")
    public String home(Model model){
         List<Category> cats = (List<Category>) categoryRepository.findAll();
         model.addAttribute("names",cats.stream().map(Category::getCategoryName).collect(Collectors.toList()));
         model.addAttribute("category",new Category());
        return "home";
    }

    @GetMapping("/allRecipes")
    public String fetchAll(Model model){
        List<Recipe> recipes =(List<Recipe>) recipeRepository.findAll();;

        model.addAttribute("datas",recipes);
        return "data";
    }
    @GetMapping("/recipe/{id}")
    public String fetchDetailsById(@PathVariable String id, Model model) {
        Optional<Recipe> data = recipeRepository.findById(Long.valueOf(id));
        if (data.isEmpty()){
            return "failure";
        }
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(data.get());
        model.addAttribute("datas",recipes);
        return "recipeinfo";
    }

    @GetMapping("/recipes")
    public String recipeAll(Model model,@RequestParam String categoryName){

        List<Recipe> recipes =(List<Recipe>) recipeRepository.findAll();
        List<Recipe> finaldata = new ArrayList<>();
        for ( Recipe r:recipes) {
            if(r.getCategories().contains(categoryName)){
                finaldata.add(r);
            }
        }
        model.addAttribute("datas",finaldata);
        return "data";
    }
}
