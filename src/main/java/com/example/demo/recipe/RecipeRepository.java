package com.example.demo.recipe;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface RecipeRepository extends CrudRepository<Recipe, RecipeId>, RecipeRepositoryCustom {
}