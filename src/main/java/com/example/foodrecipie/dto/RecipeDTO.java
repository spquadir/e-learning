package com.example.foodrecipie.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public class RecipeDTO {

    private long id;
    private String name;
    private String base64ImgStr;
    private MultipartFile image;
    private Map<String,String> ingredients;
    private List<String> directions;

    private Map<String,String> nutritionalContents;
    private String cookingTime;
    private int servingQty;
    private List<String> categories;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBase64ImgStr() {
        return base64ImgStr;
    }

    public void setBase64ImgStr(String base64ImgStr) {
        this.base64ImgStr = base64ImgStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
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
