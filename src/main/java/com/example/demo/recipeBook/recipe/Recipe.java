package com.example.demo.recipeBook.recipe;

import io.github.wimdeblauwe.jpearl.AbstractEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tt_recipes")
public class Recipe extends AbstractEntity<RecipeId> {

    /**
     * Default constructor for JPA
     */
    protected Recipe() {
    }

    public Recipe(RecipeId id) {
        super(id);
    }
}