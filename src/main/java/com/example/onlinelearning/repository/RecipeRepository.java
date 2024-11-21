package com.example.onlinelearning.repository;

import com.example.onlinelearning.models.RecipeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeModel,Long> {


}
