package com.example.onlinelearning.controller;


import com.example.onlinelearning.models.UserModel;
import com.example.onlinelearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/e-learning")
public class HomeController {
@Autowired
private UserRepository userRepository;

    @GetMapping("/courses")
    public String courses(){

        return "registered";
    }

    @GetMapping("/home")
    public String initializeSetup(Model model){

         return "home";
    }

    @GetMapping("/contact")
    public String contactPage(Model model){
        return "contact";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @PostMapping

    @GetMapping("/discover")
    public String discoverPage(){
        return "discover";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("user",new UserModel());
        return "register";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute UserModel userModel,Model model){
    userRepository.save(userModel);
    model.addAttribute("user",new UserModel());
    return "registered";
    }

    @PostMapping("/loginhome")
    public String login(@RequestParam String username, @RequestParam String password, Model model, UserModel usermodel) {
        if (username == null || password == null) {
            model.addAttribute("error", "Username and password are required.");
            return "login"; // Return to login.html
        }

        try {
             usermodel = userRepository.findByUsername(username);
            if (usermodel != null && password.equals(usermodel.getPassword())) {
                return "home"; // Redirect to home.html
            } else {
                model.addAttribute("error", "Invalid username or password.");
                return "login"; // Return to login.html
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "An error occurred during login.");
            return "login"; // Return to login.html
        }
    }



    }
