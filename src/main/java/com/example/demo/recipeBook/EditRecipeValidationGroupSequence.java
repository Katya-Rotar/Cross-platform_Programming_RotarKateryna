package com.example.demo.recipeBook;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence({Default.class, RecipeValidationGroupOne.class})
public interface EditRecipeValidationGroupSequence {
}
