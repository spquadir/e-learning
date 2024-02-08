package com.example.foodrecipie.repository;

import com.example.foodrecipie.models.Category;
import com.example.foodrecipie.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsByCategoryName(String name);
}
