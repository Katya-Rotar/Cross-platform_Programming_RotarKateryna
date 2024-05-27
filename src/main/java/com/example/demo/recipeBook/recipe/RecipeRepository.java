package com.example.demo.recipeBook.recipe;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface RecipeRepository extends CrudRepository<Recipe, RecipeId>,
        PagingAndSortingRepository<Recipe, RecipeId>,
        RecipeRepositoryCustom {
}