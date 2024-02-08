package com.example.foodrecipie.repository;

import com.example.foodrecipie.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
