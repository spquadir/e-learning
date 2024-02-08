package com.example.foodrecipie.controller;

import com.example.foodrecipie.dto.RecipeDTO;
import com.example.foodrecipie.models.Category;
import com.example.foodrecipie.models.Image;
import com.example.foodrecipie.models.Recipe;
import com.example.foodrecipie.repository.CategoryRepository;
import com.example.foodrecipie.repository.ImageRepository;
import com.example.foodrecipie.repository.RecipeRepository;
import com.example.foodrecipie.service.DataSetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private DataSetupService dataSetupService;

    @GetMapping("/home")
    public String getAdminHome(Model model){
       /* try {
            dataSetupService.executeSqlFile();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("error in setting up initial-data");
        }*/
        model.addAttribute("recipe", new RecipeDTO());
        return "admin_home";
    }

    @PostMapping("/createRecipe")
    public String createRecipe(Model model,@ModelAttribute RecipeDTO recipeDTO){

        // customize
        Image image = new Image();
        image.setName(recipeDTO.getImage().getName());
        try {
            image.setImageData(recipeDTO.getImage().getBytes());
            imageRepository.save(image);
        } catch (IOException e) {
            System.out.println("Exception occurred in handling image");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        List<String> categoryNames = recipeDTO.getCategories().stream().map(String::toUpperCase).collect(Collectors.toList());

        for (String name:categoryNames) {
            boolean res = categoryRepository.existsByCategoryName(name);
            if(!res){
                Category category = new Category();
                category.setCategoryName(name);
                categoryRepository.save(category);
            }
        }

        Recipe recipe = new Recipe();
        recipe.setImage(image);
        recipe.setCategories(categoryNames);
        recipe.setNutritionalContents(recipeDTO.getNutritionalContents());
        recipe.setDirections(recipeDTO.getDirections());
        recipe.setName(recipeDTO.getName());
        recipe.setCookingTime(recipeDTO.getCookingTime());
        recipe.setIngredients(recipeDTO.getIngredients());
        recipe.setServingQty(recipeDTO.getServingQty());
        recipeRepository.save(recipe);
        model.addAttribute("recipe", new RecipeDTO());
        return "admin_home";
    }
}
