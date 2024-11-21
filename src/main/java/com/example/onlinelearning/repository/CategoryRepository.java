package com.example.onlinelearning.repository;

import com.example.onlinelearning.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel,Integer> {
    boolean existsByCategoryName(String name);
}
