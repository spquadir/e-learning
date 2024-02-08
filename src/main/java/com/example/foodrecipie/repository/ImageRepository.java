package com.example.foodrecipie.repository;

import com.example.foodrecipie.models.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageModel, Integer> {
}
