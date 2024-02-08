package com.example.foodrecipie.controller;

import com.example.foodrecipie.models.CategoryModel;
import com.example.foodrecipie.models.RecipeModel;
import com.example.foodrecipie.repository.CategoryRepository;
import com.example.foodrecipie.repository.ImageRepository;
import com.example.foodrecipie.repository.RecipeRepository;
import com.example.foodrecipie.service.DataSetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/recipe")
public class RecipeController {


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private DataSetupService dataSetupService;

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/home")
    public String initializeSetup(Model model){

        // load relevant data
         List<CategoryModel> cats = (List<CategoryModel>) categoryRepository.findAll();
         model.addAttribute("names",cats.stream().map(CategoryModel::getCategoryName).collect(Collectors.toList()));
         model.addAttribute("category",new CategoryModel());
        return "home";
    }

    @GetMapping("/all")
    public String fetchAll(Model model){
        List<RecipeModel> recipeModels =(List<RecipeModel>) recipeRepository.findAll();;

        model.addAttribute("datas", recipeModels);

        return "data";
    }
    @GetMapping("/{id}")
    public String fetchDetailsById(@PathVariable String id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("recipeId",id);
        return "redirect:/recipe_info" ;
    }

    @GetMapping("/category")
    public String recipeAll(Model model,@RequestParam String categoryName){

        List<RecipeModel> recipeModels =(List<RecipeModel>) recipeRepository.findAll();
        List<RecipeModel> finaldata = new ArrayList<>();
        for ( RecipeModel r: recipeModels) {
            if(r.getCategories().contains(categoryName)){
                finaldata.add(r);
            }
        }
        model.addAttribute("datas",finaldata);
        return "data";
    }

    @GetMapping("/info")
    public String fetchRecipeInfo(Model model,@ModelAttribute(name="recipeId",binding = true) String id) throws IOException {
        Optional<RecipeModel> data = recipeRepository.findById(Long.valueOf(id));
        if (data.isEmpty()){
            return "failure";
        }
        List<RecipeModel> recipeModels = new ArrayList<>();
        recipeModels.add(data.get());
        model.addAttribute("datas", recipeModels);
        model.addAttribute("imageData",Base64.getEncoder().encodeToString(data.get().getImage().getImageData()));
        return "recipe_info";

    }
}
