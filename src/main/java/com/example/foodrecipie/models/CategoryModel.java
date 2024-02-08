package com.example.foodrecipie.models;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryModel {
   @Column(name="name" , unique = true)
    private String categoryName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryID;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
