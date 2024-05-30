package com.example.demo.recipeBook.recipe;

public class EditRecipeParameters extends CreateRecipeParameters{
    private final long version;
    public EditRecipeParameters(long version, Title title, Ingredients ingredients, Instructions instructions,
                                Difficulty difficulty, Category category) {
        super(title, ingredients, instructions, difficulty, category);
        this.version = version;
    }

    public long getVersion() {
        return version;
    }

    public void update(Recipe recipe){
        recipe.setTitle(getTitle());
        recipe.setIngredients(getIngredients());
        recipe.setInstructions(getInstructions());
        recipe.setDifficulty(getDifficulty());
        recipe.setCategory(getCategory());
    }
}
