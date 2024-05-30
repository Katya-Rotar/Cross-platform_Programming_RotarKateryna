package com.example.demo.recipeBook.recipe;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecipeNotFoundException extends RuntimeException {

    public RecipeNotFoundException(RecipeId recipeId) {
        super(String.format("Recipe with id %s not found", recipeId.asString()));
    }
}
