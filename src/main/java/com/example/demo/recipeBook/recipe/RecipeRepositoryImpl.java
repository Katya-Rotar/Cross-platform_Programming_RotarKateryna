package com.example.demo.recipeBook.recipe;

import io.github.wimdeblauwe.jpearl.UniqueIdGenerator;

import java.util.UUID;

public class RecipeRepositoryImpl implements RecipeRepositoryCustom {
    private final UniqueIdGenerator<UUID> generator;

    public RecipeRepositoryImpl(UniqueIdGenerator<UUID> generator) {
        this.generator = generator;
    }

    @Override
    public RecipeId nextId() {
        return new RecipeId(generator.getNextUniqueId());
    }
}