package com.example.demo.recipeBook.recipe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RecipeService {
    Recipe createRecipe(CreateRecipeParameters parameters);
    Page<Recipe> getRecipes(Pageable pageable);
    boolean recipeWithTitleExists(Title title);
}
