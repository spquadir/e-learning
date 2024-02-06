package com.example.foodrecipie.repository;

import com.example.foodrecipie.models.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Integer> {
}
