package com.example.foodrecipie.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;
@Entity
@Table(name = "recipes")
public class RecipeModel {

    @OneToOne
    private ImageModel image;
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ElementCollection
    private Map<String,String> ingredients;
    @ElementCollection
    private List<String> directions;
    @ElementCollection
    private Map<String,String> nutritionalContents;
    private String cookingTime;
    private int servingQty;
    @ElementCollection
    private List<String> categories;

    public ImageModel getImage() {
        return image;
    }

    public void setImage(ImageModel image) {
        this.image = image;
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

    public Map<String, String> getNutritionalContents() {
        return nutritionalContents;
    }

    public void setNutritionalContents(Map<String, String> nutritionalContents) {
        this.nutritionalContents = nutritionalContents;
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
