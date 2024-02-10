package com.example.foodrecipie.controller;

import com.example.foodrecipie.dto.RecipeDTO;
import com.example.foodrecipie.models.CategoryModel;
import com.example.foodrecipie.models.ImageModel;
import com.example.foodrecipie.models.RecipeModel;
import com.example.foodrecipie.repository.CategoryRepository;
import com.example.foodrecipie.repository.ImageRepository;
import com.example.foodrecipie.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @GetMapping("/home")
    public String getAdminHome(Model model){
        model.addAttribute("recipe", new RecipeDTO());
        return "admin_home";
    }

    @PostMapping("/createRecipe")
    public String createRecipe(Model model,@ModelAttribute RecipeDTO recipeDTO){

        // customize
        ImageModel imageModel = new ImageModel();
        imageModel.setName(recipeDTO.getImage().getName());
        try {
            imageModel.setData(recipeDTO.getImage().getBytes());
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

        final RecipeModel recipeModel = getRecipeModel(recipeDTO, imageModel, categoryNames);
        recipeRepository.save(recipeModel);
        model.addAttribute("recipe", new RecipeDTO());
        return "admin_home";
    }

    private RecipeModel getRecipeModel(RecipeDTO recipeDTO, ImageModel imageModel, List<String> categoryNames) {
        RecipeModel recipeModel = new RecipeModel();
        recipeModel.setImage(imageModel);
        recipeModel.setCategories(categoryNames);
        recipeModel.setIngredients(getConvertedMap(recipeDTO.getIngredients()));
        recipeModel.setNutritionalContents(getConvertedMap(recipeDTO.getNutritionalContents()));
        recipeModel.setDirections(recipeDTO.getDirections());
        recipeModel.setName(recipeDTO.getName());
        recipeModel.setCookingTime(recipeDTO.getCookingTime());
        recipeModel.setServingQty(recipeDTO.getServingQty());
        return recipeModel;
    }

    public Map<String,String> getConvertedMap(Map<String,String> originalMap) {
        Map<String,String> convertedMap = new HashMap<>();
        for (Map.Entry<String, String> entry : originalMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

           if(key.contains("key")) {
               convertedMap.put(value, originalMap.get("value" + key.substring(key.indexOf("_"))));
           }

        }
        return convertedMap;
    }
}
