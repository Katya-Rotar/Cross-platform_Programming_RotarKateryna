package com.example.demo.recipeBook;

import com.example.demo.addRecipe.CreateRecipeFormData;
import com.example.demo.recipeBook.recipe.RecipeService;
import com.example.demo.recipeBook.recipe.Title;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class NotExistingRecipeValidator
        implements ConstraintValidator<NotExistingRecipe, CreateRecipeFormData> {
    private final RecipeService recipeService;

    @Autowired
    public NotExistingRecipeValidator(RecipeService service){
        this.recipeService = service;
    }
    @Override
    public void initialize(NotExistingRecipe constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CreateRecipeFormData formData, ConstraintValidatorContext constraintValidatorContext) {
        if(recipeService.recipeWithTitleExists(new Title(formData.getTitle()))){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("{RecipeAlreadyExisting}")
                    .addPropertyNode("title").addConstraintViolation();
            return false;
        }
        return true;
    }
}
