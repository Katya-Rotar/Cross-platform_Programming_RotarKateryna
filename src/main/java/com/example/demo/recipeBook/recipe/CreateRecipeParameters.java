package com.example.demo.recipeBook.recipe;

import com.example.demo.recipeBook.recipe.*;

public class CreateRecipeParameters {
    private final Title title;
    private final Ingredients ingredients;
    private final Instructions instructions;
    private final Difficulty difficulty;
    private final Category category;

    public CreateRecipeParameters(Title title, Ingredients ingredients, Instructions instructions, Difficulty difficulty, Category category) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.difficulty = difficulty;
        this.category = category;
    }
    public Title getTitle() {
        return title;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public Instructions getInstructions() {
        return instructions;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Category getCategory() {
        return category;
    }
}
