package com.example.foodrecipie.controller;

import com.example.foodrecipie.dto.RecipeDTO;
import com.example.foodrecipie.models.CategoryModel;
import com.example.foodrecipie.models.ImageModel;
import com.example.foodrecipie.models.RecipeModel;
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
        ImageModel imageModel = new ImageModel();
        imageModel.setName(recipeDTO.getImage().getName());
        try {
            imageModel.setImageData(recipeDTO.getImage().getBytes());
            imageRepository.save(imageModel);
        } catch (IOException e) {
            System.out.println("Exception occurred in handling image");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        List<String> categoryNames = recipeDTO.getCategories().stream().map(String::toUpperCase).collect(Collectors.toList());

        for (String name:categoryNames) {
            boolean res = categoryRepository.existsByCategoryName(name);
            if(!res){
                CategoryModel categoryModel = new CategoryModel();
                categoryModel.setCategoryName(name);
                categoryRepository.save(categoryModel);
            }
        }

        RecipeModel recipeModel = new RecipeModel();
        recipeModel.setImage(imageModel);
        recipeModel.setCategories(categoryNames);
        recipeModel.setNutritionalContents(recipeDTO.getNutritionalContents());
        recipeModel.setDirections(recipeDTO.getDirections());
        recipeModel.setName(recipeDTO.getName());
        recipeModel.setCookingTime(recipeDTO.getCookingTime());
        recipeModel.setIngredients(recipeDTO.getIngredients());
        recipeModel.setServingQty(recipeDTO.getServingQty());
        recipeRepository.save(recipeModel);
        model.addAttribute("recipe", new RecipeDTO());
        return "admin_home";
    }
}
