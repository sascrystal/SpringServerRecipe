package com.spring_server_recipe.repository;

import com.spring_server_recipe.domain.Recipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository recipeRepository;
    @DisplayName("Должен находить рецепт по     ")
    @Test
    void shouldInsertRecipe() {
    }
}
