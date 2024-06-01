package com.example.demo.recipes;

import com.example.demo.recipeBook.*;
import com.example.demo.recipeBook.recipe.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String editRecipeForm(@PathVariable("id") RecipeId recipeId,
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

    @PostMapping("/{id}")
    public String editRecipe(@PathVariable("id") RecipeId recipeId,
                             @Validated(EditRecipeValidationGroupSequence.class)
                             @ModelAttribute("recipe") EditRecipeFormData formData,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("difficulty", List.of(Difficulty.EASY, Difficulty.MEDIUM, Difficulty.HARD,
                    Difficulty.EXPERT));
            model.addAttribute("category", List.of(Category.APPETIZER, Category.MAIN_COURSE, Category.DESSERT,
                    Category.BEVERAGE));
            model.addAttribute("editMode", EditMode.UPDATE);
            return "addRecipe/addRecipe";
        }
        recipeService.editRecipe(recipeId, formData.toParameters());
        return "redirect:/recipes";
    }

    @PostMapping("/{id}/delete")
    public String deleteRecipe(@PathVariable("id") RecipeId recipeId,
                               RedirectAttributes redirectAttributes){
        Recipe recipe = recipeService
                .getRecipe(recipeId)
                .orElseThrow(()-> new RecipeNotFoundException(recipeId));
        recipeService.deleteRecipe(recipeId);
        redirectAttributes.addFlashAttribute("deletedTitle", recipe.getTitle());
        return "redirect:/recipes";
    }
}