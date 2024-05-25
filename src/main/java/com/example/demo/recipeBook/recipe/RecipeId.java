package com.example.demo.recipeBook.recipe;

import io.github.wimdeblauwe.jpearl.AbstractEntityId;

import java.util.UUID;

public class RecipeId extends AbstractEntityId<UUID> {

   /**
   * Default constructor for JPA
   */
   protected RecipeId() {
   }

   public RecipeId(UUID id) {
       super(id);
   }
}