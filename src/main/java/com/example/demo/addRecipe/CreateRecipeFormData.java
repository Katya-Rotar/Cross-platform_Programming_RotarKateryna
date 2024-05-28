package com.example.demo.addRecipe;

import com.example.demo.recipeBook.recipe.*;

public class CreateRecipeFormData {
    private String title;
    private String ingredients;
    private String instructions;
    private Difficulty difficulty;
    private Category category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CreateRecipeParameters toParameters(){
        return new CreateRecipeParameters(
                new Title(title),
                new Ingredients(ingredients),
                new Instructions(instructions),
                difficulty,
                category);
    }
}
