package com.example.demo.recipes;

import com.example.demo.recipeBook.EditMode;
import com.example.demo.recipeBook.EditRecipeFormData;
import com.example.demo.recipeBook.recipe.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

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

    @GetMapping("/{id}")
    public String editTeamMemberForm(@PathVariable("id") RecipeId recipeId,
                                     Model model) {
        Recipe recipe = recipeService
                .getRecipe(recipeId)
                .orElseThrow(()-> new RecipeNotFoundException(recipeId));
        model.addAttribute("recipe", EditRecipeFormData.fromRecipe(recipe));
        model.addAttribute("difficulty", List.of(Difficulty.EASY, Difficulty.MEDIUM, Difficulty.HARD,
                Difficulty.EXPERT));
        model.addAttribute("category", List.of(Category.APPETIZER, Category.MAIN_COURSE, Category.DESSERT,
                Category.BEVERAGE));
        model.addAttribute("editMode", EditMode.UPDATE);
        return "addRecipe/addRecipe";
    }
}