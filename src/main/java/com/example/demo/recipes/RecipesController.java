package com.example.demo.recipes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/recipes")
public class RecipesController {

    @GetMapping
    public String projects(Model model) {
        return "recipes/recipes";
    }
}