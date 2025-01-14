package com.example.onlinelearning.controller;


import com.example.onlinelearning.models.CourseModel;
import com.example.onlinelearning.models.LoginModel;
import com.example.onlinelearning.models.UserModel;
import com.example.onlinelearning.repository.CourseRepository;
import com.example.onlinelearning.repository.LoginRepository;
import com.example.onlinelearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/e-learning")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    public String courses(){

        return "courses";
    }

    @GetMapping("/home")
    public String initializeSetup(Model model){

         return "home";
    }
    @GetMapping("/about")
    public String aboutpage(){

        return "about";
    }


    @GetMapping("/contact")
    public String contactPage(Model model){
        return "contact";
    }

    @GetMapping("/login")
    public String loginPage(@ModelAttribute LoginModel loginModel,Model model){
        model.addAttribute("loginuser",new LoginModel());

        return "login";
    }


    @PostMapping("/loginsuccess")
    public String login(@ModelAttribute UserModel userModel,@ModelAttribute LoginModel loginModel, Model model){

        Optional<UserModel> data = userRepository.findById(userModel.getId());
        if(loginModel.getPassword().equals(data.get().getPassword())){
            return "home";
        }
        else{
            return "error";
        }

    }

    @GetMapping("/discover")
    public String discoverPage(){
        return "discover";
    }




    @GetMapping("/register")
    public String registerPage(Model model){

        model.addAttribute("user", new UserModel());
        return "register";
    }

    @PostMapping("/save")
    public String  save(@ModelAttribute UserModel userModel,Model model){

        userRepository.save(userModel);
        model.addAttribute("user",new UserModel());
        return "registered";
    }

    @GetMapping("/course")
    public String course(Model model){
        model.addAttribute("course", new CourseModel());
        return "course-add";
    }

    @PostMapping("/coursesave")
    public String  coursesave(@ModelAttribute CourseModel courseModel, Model model){

        courseRepository.save(courseModel);
        model.addAttribute("user",new CourseModel());
        return "registered";
    }










}
