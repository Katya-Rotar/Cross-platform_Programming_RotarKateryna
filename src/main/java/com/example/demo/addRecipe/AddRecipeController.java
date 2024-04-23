package com.example.demo.addRecipe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/addRecipe")
public class AddRecipeController {

    @GetMapping
    public String projects(Model model) {
        return "addRecipe/addRecipe";
    }
}