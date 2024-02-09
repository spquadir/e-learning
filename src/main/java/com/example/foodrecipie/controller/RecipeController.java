package com.example.foodrecipie.controller;

import com.example.foodrecipie.dto.RecipeDTO;
import com.example.foodrecipie.models.CategoryModel;
import com.example.foodrecipie.models.RecipeModel;
import com.example.foodrecipie.repository.CategoryRepository;
import com.example.foodrecipie.repository.ImageRepository;
import com.example.foodrecipie.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/home")
    public String initializeSetup(Model model){

        // load relevant data
         List<CategoryModel> cats = categoryRepository.findAll();
         model.addAttribute("names",cats.stream().map(CategoryModel::getCategoryName).collect(Collectors.toList()));
         model.addAttribute("category",new CategoryModel());
         return "home";
    }

    @GetMapping("/all")
    public String fetchAll(Model model){
        List<RecipeModel> recipeModels = recipeRepository.findAll();;
        List<RecipeDTO> dtos = getRecipeDTOS(recipeModels);
        model.addAttribute("datas", dtos);
        return "data";
    }
    @GetMapping("/{id}")
    public String fetchDetailsById(@PathVariable String id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("recipeId",id);
        return "redirect:/recipe/info" ;
    }

    @GetMapping("/category")
    public String recipeAll(Model model,@RequestParam String categoryName){

        List<RecipeModel> recipeModels = recipeRepository.findAll();
        List<RecipeDTO> finaldata = new ArrayList<>();
        for ( RecipeModel r: recipeModels) {
            if(r.getCategories().contains(categoryName)){
                RecipeDTO dto = new RecipeDTO();
                dto.setBase64ImgStr(Base64.getEncoder().encodeToString(r.getImage().getData()));
                dto.setName(r.getName());
                dto.setId(r.getId());
                finaldata.add(dto);
            }
        }
        model.addAttribute("datas",finaldata);
        return "data";
    }

    @GetMapping("/info")
    public String fetchRecipeInfo(Model model,@ModelAttribute(name="recipeId") String id) {
        Optional<RecipeModel> data = recipeRepository.findById(Long.valueOf(id));
        if (data.isEmpty()){
            return "failure";
        }

        final List<RecipeDTO> finalData = getRecipeDTOS(Collections.singletonList(data.get()));

        model.addAttribute("datas", finalData);
        return "recipe_info";
    }

    private static List<RecipeDTO> getRecipeDTOS(List<RecipeModel> models) {

        List<RecipeDTO> finalData = new ArrayList<>();

        for (RecipeModel recipeModel: models) {
            RecipeDTO dto = new RecipeDTO();
            dto.setBase64ImgStr(Base64.getEncoder().encodeToString(recipeModel.getImage().getData()));
            dto.setName(recipeModel.getName());
            dto.setId(recipeModel.getId());
            dto.setIngredients(recipeModel.getIngredients());
            dto.setNutritionalContents(recipeModel.getNutritionalContents());
            dto.setServingQty(recipeModel.getServingQty());
            dto.setCookingTime(recipeModel.getCookingTime());
            dto.setDirections(recipeModel.getDirections());
            finalData.add(dto);
        }
        return finalData;
    }
}
