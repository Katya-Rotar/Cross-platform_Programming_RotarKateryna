package com.example.demo.recipe;

import com.example.demo.recipeBook.recipe.*;
import io.github.wimdeblauwe.jpearl.InMemoryUniqueIdGenerator;
import io.github.wimdeblauwe.jpearl.UniqueIdGenerator;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("data-jpa-test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RecipeRepositoryTest {

    private final RecipeRepository repository;
    private final JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    RecipeRepositoryTest(RecipeRepository repository, JdbcTemplate jdbcTemplate) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @BeforeEach
    void validatePreconditions() {
        assertThat(repository.count()).isZero();
    }

    @Test
    void testSaveRecipe() {
        RecipeId id = repository.nextId();
        repository.save(new Recipe(id,
                new Title("Борщ"),
                new Ingredients("Вода, капуста, буряк, картопля, морква, цибуля"),
                new Instructions("1. Наріжте овочі. 2. Варіть у воді. 3. Додайте сіль та спеції."),
                Difficulty.MEDIUM,
                Category.MAIN_COURSE));
        entityManager.flush();

        UUID idInDb = jdbcTemplate.queryForObject("SELECT id FROM tt_recipes", UUID.class);
        assertThat(idInDb).isEqualTo(id.getId());
        assertThat(jdbcTemplate.queryForObject("SELECT title FROM tt_recipes", String.class)).isEqualTo("Борщ");
        assertThat(jdbcTemplate.queryForObject("SELECT ingredients FROM tt_recipes", String.class))
                .isEqualTo("Вода, капуста, буряк, картопля, морква, цибуля");
        assertThat(jdbcTemplate.queryForObject("SELECT instructions FROM tt_recipes", String.class))
                .isEqualTo("1. Наріжте овочі. 2. Варіть у воді. 3. Додайте сіль та спеції.");
        assertThat(jdbcTemplate.queryForObject("SELECT difficulty FROM tt_recipes", String.class)).isEqualTo("MEDIUM");
        assertThat(jdbcTemplate.queryForObject("SELECT category FROM tt_recipes", String.class)).isEqualTo("MAIN_COURSE");
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public UniqueIdGenerator<UUID> uniqueIdGenerator() {
            return new InMemoryUniqueIdGenerator();
        }

        @Bean
        public DataSource dataSource() {
            return DataSourceBuilder.create()
                    .driverClassName("org.testcontainers.jdbc.ContainerDatabaseDriver")
                    .url("jdbc:tc:postgresql:12:///recipeBook_db?TC_TMPFS=/testtmpfs:rw")
                    .username("user")
                    .password("password")
                    .build();
        }
    }
}
