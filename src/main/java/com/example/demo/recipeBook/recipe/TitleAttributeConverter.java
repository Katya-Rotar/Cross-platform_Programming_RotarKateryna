package com.example.demo.recipeBook.recipe;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TitleAttributeConverter implements AttributeConverter<Title, String> {

    @Override
    public String convertToDatabaseColumn(Title title) {
        return title.asString();
    }

    @Override
    public Title convertToEntityAttribute(String s) {
        return new Title(s);
    }
}
