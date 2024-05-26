package com.example.demo.recipeBook.recipe;

import org.springframework.util.Assert;
import org.testcontainers.shaded.com.google.common.base.MoreObjects;

import java.util.Objects;

public class Ingredients {

    private String ingredients;

    protected Ingredients() {
    }

    public Ingredients(String ingredients) {
        Assert.hasText(ingredients, "ingredients cannot be blank");
        this.ingredients = ingredients;
    }

    public String asString() {
        return ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ingredients that = (Ingredients) o;
        return Objects.equals(ingredients, that.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredients);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("ingredients", ingredients)
                .toString();
    }
}
