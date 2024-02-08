package com.example.foodrecipie.repository;

import com.example.foodrecipie.models.RecipeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeModel,Long> {


}
