package com.example.demo;

import com.example.demo.recipeBook.recipe.*;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        List<String> ingredientList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            ingredientList.add(faker.food().ingredient());
        }
        Ingredients ingredients = new Ingredients(String.join(", ", ingredientList));

        List<String> instructionList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(4) + 7; i++) {
            String action = faker.options().option("Chop", "Slice", "Dice", "Grate", "Boil", "Bake", "Whisk",
                    "Saute", "Blend");
            String ingredient = ingredientList.get(random.nextInt(ingredientList.size()));
            String step = String.format(
                    "Step %d: %s the %s.",
                    i + 1,
                    action,
                    ingredient
            );
            instructionList.add(step);

            if (random.nextBoolean()) {
                String additionalAction = faker.options().option("Add", "Mix", "Stir", "Season", "Garnish");
                String additionalIngredient = ingredientList.get(random.nextInt(ingredientList.size()));
                String additionalStep = String.format(
                        "Step %d: %s %s with %s.",
                        i + 2,
                        additionalAction,
                        additionalIngredient,
                        ingredient
                );
                instructionList.add(additionalStep);
                i++;
            }
        }
        Instructions instructions =  new Instructions(String.join(" ", instructionList));
        Difficulty difficulty = faker.options().option(Difficulty.class);
        Category category = faker.options().option(Category.class);
        return new CreateRecipeParameters(title, ingredients, instructions, difficulty, category);
    }
}
