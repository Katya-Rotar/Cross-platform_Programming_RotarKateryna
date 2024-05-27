package com.example.demo.recipeBook.recipe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }
    @Override
    public Recipe createRecipe(CreateRecipeParameters parameters) {
        RecipeId recipeId = recipeRepository.nextId();
        var recipe = new Recipe(
                recipeId,
                parameters.title(),
                parameters.ingredients(),
                parameters.instructions(),
                parameters.difficulty(),
                parameters.category());
        return recipeRepository.save(recipe);
    }

    @Override
    public Page<Recipe> getRecipes(Pageable pageable) {
        return recipeRepository.findAll(pageable);
    }
}
