package com.example.demo;

import com.example.demo.recipeBook.recipe.*;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("init-db")
public class DatabaseInitializer implements CommandLineRunner {

    private final Faker faker = new Faker();
    private final RecipeService recipeService;

    public DatabaseInitializer(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    public void run(String... args) {
        for (int i = 0; i < 20; i++) {
            recipeService.createRecipe(newRandomRecipeParameters());
        }
    }

    private CreateRecipeParameters newRandomRecipeParameters() {
        Title title = new Title(faker.food().dish());
        Ingredients ingredients = new Ingredients(faker.lorem().sentence(10));
        Instructions instructions = new Instructions(faker.lorem().paragraph());
        Difficulty difficulty = faker.options().option(Difficulty.class);
        Category category = faker.options().option(Category.class);
        return new CreateRecipeParameters(title, ingredients, instructions, difficulty, category);
    }
}
