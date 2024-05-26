package com.example.demo.recipeBook.recipe;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class IngredientsAttributeConverter implements AttributeConverter<Ingredients, String> {

    @Override
    public String convertToDatabaseColumn(Ingredients ingredients) {
        return ingredients.asString();
    }

    @Override
    public Ingredients convertToEntityAttribute(String s) {
        return new Ingredients(s);
    }
}
