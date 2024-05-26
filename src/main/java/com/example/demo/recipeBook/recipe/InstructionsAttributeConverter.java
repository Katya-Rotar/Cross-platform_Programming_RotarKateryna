package com.example.demo.recipeBook.recipe;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class InstructionsAttributeConverter implements AttributeConverter<Instructions, String> {

    @Override
    public String convertToDatabaseColumn(Instructions instructions) {
        return instructions.asString();
    }

    @Override
    public Instructions convertToEntityAttribute(String s) {
        return new Instructions(s);
    }
}

