package com.example.onlinelearning.repository;

import com.example.onlinelearning.models.CourseModel;
import com.example.onlinelearning.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel,Long> {


}
