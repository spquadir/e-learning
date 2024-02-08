package com.example.foodrecipie.repository;

import com.example.foodrecipie.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel,Integer> {
    boolean existsByCategoryName(String name);
}
