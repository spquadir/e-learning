package com.example.onlinelearning.repository;

import com.example.onlinelearning.models.LoginModel;
import com.example.onlinelearning.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel,String> {


}
