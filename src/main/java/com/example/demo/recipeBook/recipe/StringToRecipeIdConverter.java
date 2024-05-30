package com.example.demo.recipeBook.recipe;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StringToRecipeIdConverter implements Converter<String, RecipeId> {

    @Override
    public RecipeId convert(@NotNull String source) {
        return new RecipeId(UUID.fromString(source));
    }
}
