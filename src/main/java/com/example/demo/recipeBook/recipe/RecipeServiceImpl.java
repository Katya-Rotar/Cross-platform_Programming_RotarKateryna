package com.example.demo.recipeBook.recipe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
                parameters.getTitle(),
                parameters.getIngredients(),
                parameters.getInstructions(),
                parameters.getDifficulty(),
                parameters.getCategory());
        return recipeRepository.save(recipe);
    }

    @Override
    public Optional<Recipe> getRecipe(RecipeId recipeId) {
        return recipeRepository.findById(recipeId);
    }

    @Override
    public Page<Recipe> getRecipes(Pageable pageable) {
        return recipeRepository.findAll(pageable);
    }

    @Override
    public boolean recipeWithTitleExists(Title title) {
        return recipeRepository.existsByTitle(title);
    }

    @Override
    public Recipe editRecipe(RecipeId recipeId, EditRecipeParameters recipeParameters) {
        var recipe = recipeRepository
                .findById(recipeId)
                .orElseThrow(()-> new RecipeNotFoundException(recipeId));
        if(recipeParameters.getVersion() != recipe.getVersion()){
            throw new ObjectOptimisticLockingFailureException(Recipe.class, recipe.getId().asString());
        }
        recipeParameters.update(recipe);
        return recipe;
    }

    @Override
    public void deleteRecipe(RecipeId recipeId) {
        recipeRepository.deleteById(recipeId);
    }
}
