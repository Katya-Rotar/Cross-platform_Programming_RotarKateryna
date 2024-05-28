package com.example.demo.addRecipe;

import com.example.demo.recipeBook.NotExistingRecipe;
import com.example.demo.recipeBook.RecipeValidationGroupOne;
import com.example.demo.recipeBook.RecipeValidationGroupTwo;
import com.example.demo.recipeBook.recipe.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@NotExistingRecipe(groups = RecipeValidationGroupTwo.class)
public class CreateRecipeFormData {
    @NotBlank
    @Size(min = 2, max = 200, groups = RecipeValidationGroupOne.class)
    private String title;
    @NotBlank(groups = RecipeValidationGroupOne.class)
    private String ingredients;
    @NotBlank(groups = RecipeValidationGroupOne.class)
    private String instructions;
    @NotNull
    private Difficulty difficulty;
    @NotNull
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
