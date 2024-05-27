package com.example.demo.recipes;

import com.example.demo.recipeBook.recipe.RecipeService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/recipes")
public class RecipesController {
    private final RecipeService recipeService;
    public RecipesController(RecipeService recipeService){
        this.recipeService = recipeService;
    }
    @GetMapping
    public String projects(Model model, @SortDefault.SortDefaults({
            @SortDefault("title")}) Pageable pageable) {
        model.addAttribute("titleRecipe", "Recipes");
        model.addAttribute("recipes", recipeService.getRecipes(pageable));
        return "recipes/recipes";
    }
}