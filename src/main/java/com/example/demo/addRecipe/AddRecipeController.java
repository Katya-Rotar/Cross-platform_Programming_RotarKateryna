package com.example.demo.addRecipe;

import com.example.demo.recipeBook.recipe.Category;
import com.example.demo.recipeBook.recipe.Difficulty;
import com.example.demo.recipeBook.recipe.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/addRecipe")
public class AddRecipeController {
    private final RecipeService recipeService;
    public AddRecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }
    @GetMapping
    public String showAddRecipeForm(Model model) {
        model.addAttribute("recipe", new CreateRecipeFormData());
        model.addAttribute("difficulty", List.of(Difficulty.EASY, Difficulty.MEDIUM, Difficulty.HARD,
                Difficulty.EXPERT));
        model.addAttribute("category", List.of(Category.APPETIZER, Category.MAIN_COURSE, Category.DESSERT,
                Category.BEVERAGE));
        return "addRecipe/addRecipe";
    }

    @PostMapping
    public String submitRecipeForm(@ModelAttribute("recipe") CreateRecipeFormData formData,
                                   Model model) {
        recipeService.createRecipe(formData.toParameters());
        return "redirect:/recipes";
    }
}