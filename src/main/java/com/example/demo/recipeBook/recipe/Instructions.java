package com.example.demo.recipeBook.recipe;

import org.springframework.util.Assert;
import org.testcontainers.shaded.com.google.common.base.MoreObjects;

import java.util.Objects;

public class Instructions {

    private String instructions;

    protected Instructions() {
    }

    public Instructions(String instructions) {
        Assert.hasText(instructions, "instructions cannot be blank");
        this.instructions = instructions;
    }

    public String asString() {
        return instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Instructions that = (Instructions) o;
        return Objects.equals(instructions, that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructions);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("instructions", instructions)
                .toString();
    }
}

