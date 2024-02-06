package com.example.foodrecipie.controller;

import com.example.foodrecipie.models.Category;
import com.example.foodrecipie.models.Image;
import com.example.foodrecipie.models.Recipe;
import com.example.foodrecipie.repository.CategoryRepository;
import com.example.foodrecipie.repository.ImageRepository;
import com.example.foodrecipie.repository.RecipeRepository;
import com.example.foodrecipie.service.DataSetupService;
import org.apache.jasper.tagplugins.jstl.core.Url;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class RecipeController {

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

        //
        try {
            dataSetupService.executeSqlFile();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("error in setting up initial-data");
        }
        // update image with URL
        List<Image> images = (List<Image>) imageRepository.findAll();
        for (Image img: images) {
            byte[] imageBytes;
            String imageUrl = "https://www.awesomecuisine.com/wp-content/uploads/2020/03/bread-omelette.jpg";
            try {

                BufferedImage image = ImageIO.read(new URL(imageUrl));
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, "jpg", baos);
                imageBytes = baos.toByteArray();
                img.setImageData(imageBytes);
                imageRepository.save(img);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("exception in converting image bytes");
            }

        }

        // load relevant data
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
    public String fetchDetailsById(@PathVariable String id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("recipeId",id);
        return "redirect:/recipe-info" ;
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

    @GetMapping("/recipe-info")
    public String fetchRecipeInfo(Model model,@ModelAttribute(name="recipeId",binding = true) String id){
        Optional<Recipe> data = recipeRepository.findById(Long.valueOf(id));
        if (data.isEmpty()){
            return "failure";
        }
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(data.get());
        model.addAttribute("datas",recipes);
        model.addAttribute("image", data.get().getImage().getImageData());
        return "recipeinfo";

    }
}
