package com.example.demo.recipeBook.recipe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RecipeService {
    Recipe createRecipe(CreateRecipeParameters parameters);
    Optional<Recipe> getRecipe(RecipeId recipeId);
    Page<Recipe> getRecipes(Pageable pageable);
    boolean recipeWithTitleExists(Title title);
    Recipe editRecipe(RecipeId recipeId, EditRecipeParameters recipeParameters);
}
