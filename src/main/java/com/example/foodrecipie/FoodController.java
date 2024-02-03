package com.example.foodrecipie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

  //  @Autowired
  //  private FoodService foodService;

//    @GetMapping("/recipe") // localhost:8080/recipe
//    public String getRecipe(){
//        System.out.println("inside controller");
//    //    return foodService.getRecipeDataFromAPI();
//    }

    /*
      1 service: RecipeService
      1 controller: RecipeController
      1 Repo: RecipeRepository

      //mehtods:
       1. /home :get
       2. /category/{name} : get
       3. /allRecipes : get
       4. /recipe/{id} : get
     */
}
