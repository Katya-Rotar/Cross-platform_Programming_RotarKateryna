package com.example.demo.recipeBook.recipe;

import io.github.wimdeblauwe.jpearl.AbstractEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tt_recipes")
public class Recipe extends AbstractEntity<RecipeId> {

    @NotNull
    @Convert(converter = TitleAttributeConverter.class)
    private Title title;

    @NotNull
    @Convert(converter = IngredientsAttributeConverter.class)
    private Ingredients ingredients;

    @NotNull
    @Convert(converter = InstructionsAttributeConverter.class)
    private Instructions instructions;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;

    /**
     * Default constructor for JPA
     */
    protected Recipe() {
    }

    public Recipe(RecipeId id,
                  Title title,
                  Ingredients ingredients,
                  Instructions instructions,
                  Difficulty difficulty, Category category) {
        super(id);
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.difficulty = difficulty;
        this.category = category;
    }
    public Title getTitle(){
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