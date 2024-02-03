package com.example.foodrecipie.models;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;
import java.util.Map;
@Entity
@Table(name = "recipes")
public class Recipe {
    @ElementCollection
    private List<Image> images;
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ElementCollection
    private Map<String,String> ingredients;
    @ElementCollection
    private List<String> directions;
    @ElementCollection
    private Map<String,String> nutritionalContent;
    private String cookingTime;
    private int servingQty;
    @ElementCollection
    private List<String> categories;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Map<String, String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<String, String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getDirections() {
        return directions;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }

    public Map<String, String> getNutritionalContent() {
        return nutritionalContent;
    }

    public void setNutritionalContent(Map<String, String> nutritionalContent) {
        this.nutritionalContent = nutritionalContent;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }

    public int getServingQty() {
        return servingQty;
    }

    public void setServingQty(int servingQty) {
        this.servingQty = servingQty;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
