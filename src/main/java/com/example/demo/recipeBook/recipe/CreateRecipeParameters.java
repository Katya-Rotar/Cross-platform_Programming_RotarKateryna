package com.example.demo.recipeBook.recipe;

import com.example.demo.recipeBook.recipe.*;

public record CreateRecipeParameters(
        Title title,
        Ingredients ingredients,
        Instructions instructions,
        Difficulty difficulty,
        Category category) {
}
