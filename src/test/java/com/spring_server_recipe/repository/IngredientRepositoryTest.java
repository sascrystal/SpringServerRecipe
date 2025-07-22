package com.spring_server_recipe.repository;

import com.spring_server_recipe.domain.Author;
import com.spring_server_recipe.domain.Difficulty;
import com.spring_server_recipe.domain.Ingredient;
import com.spring_server_recipe.domain.Recipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class IngredientRepositoryTest {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired RecipeRepository recipeRepository;


    @DisplayName("должен находить ингредиент по id")
    @Test
    void shouldFindAuthorById() {
        Ingredient findIngredient = ingredientRepository.findById(1);
        String expectedName = "картошка";
        String expectedCount = "грамм 300";
        int expectedRecipeId = 1;
        assertThat(findIngredient.getName()).isEqualTo(expectedName);
        assertThat(findIngredient.getCount()).isEqualTo(expectedCount);
        assertThat(findIngredient.getRecipe().getId()).isEqualTo(expectedRecipeId);
    }

    @DisplayName("Должен обновлять ингредиент по id")
    @Test
    void shouldUpdateAuthor() {
        Ingredient ingredientBeforeUpdate = ingredientRepository.findById(1);
        Ingredient updateIngredient = Ingredient.builder().
                id(1)
                .name("Супер картошка")
                .count("200 грамм")
                .recipe(ingredientBeforeUpdate.getRecipe())
                .build();
        ingredientRepository.save(updateIngredient);
        Ingredient actualIngredient = ingredientRepository.findById(1);
            assertThat(actualIngredient).isEqualTo(updateIngredient);
        assertThat(actualIngredient.getRecipe().getId()).isEqualTo(ingredientBeforeUpdate.getRecipe().getId());
    }





    @DisplayName("Должен выдавать список ингредиентов для рецепта")
    @Test
    void shouldFindIngredientByRecipeId() {
        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(ingredientRepository.findById(1));
        expectedIngredients.add(ingredientRepository.findById(2));
        expectedIngredients.add(ingredientRepository.findById(3));
        List<Ingredient> actualIngredients = ingredientRepository.findAllByRecipeId(1);
        assertThat(actualIngredients).isEqualTo(expectedIngredients);
    }
}
