package com.example.demo.recipeBook;

import com.example.demo.addRecipe.CreateRecipeFormData;
import com.example.demo.recipeBook.recipe.*;

public class EditRecipeFormData extends CreateRecipeFormData {
    private String id;
    private long version;
    public static EditRecipeFormData fromRecipe(Recipe recipe){
        EditRecipeFormData result = new EditRecipeFormData();
        result.setId(recipe.getId().asString());
        result.setVersion(recipe.getVersion());
        result.setTitle(recipe.getTitle().asString());
        result.setIngredients(recipe.getIngredients().asString());
        result.setInstructions(recipe.getInstructions().asString());
        result.setDifficulty(recipe.getDifficulty());
        result.setCategory(recipe.getCategory());
        return result;
    }
    public EditRecipeParameters toParameters() {
        return new EditRecipeParameters(
                version, new Title(getTitle()), new Ingredients(getIngredients()),
                new Instructions(getInstructions()), getDifficulty(), getCategory()
        );
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
