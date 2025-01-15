package com.example.onlinelearning.controller;

import com.example.onlinelearning.models.CourseModel;
import com.example.onlinelearning.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;


    @GetMapping("/course")
    public String course(Model model){
        model.addAttribute("course", new CourseModel());
        return "course-add";
    }

    @PostMapping("/coursesave")
    public String  coursesave(@ModelAttribute CourseModel courseModel, Model model){

        courseRepository.save(courseModel);
        model.addAttribute("course",new CourseModel());
        return "course-success";
    }

}
