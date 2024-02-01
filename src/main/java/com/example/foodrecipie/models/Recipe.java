package com.example.foodrecipie.models;

import java.util.List;
import java.util.Map;

public class Recipe {

    private List<Image> images;
    private String name;
    private long id;
    private List<Ingredient> ingredients;
    private List<String> directions;
    private Map<String,String> nutritionalContent;
    private String cookingTime;
    private int servingQty;
    private List<String> categories;
}
