package com.example.demo.recipe;

import io.github.wimdeblauwe.jpearl.AbstractEntity;

import jakarta.persistence.Entity;

@Entity
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