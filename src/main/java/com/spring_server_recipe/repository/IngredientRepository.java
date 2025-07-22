package com.spring_server_recipe.repository;

import com.spring_server_recipe.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> findAllByRecipeId(int recipeId);
    Ingredient findById(int id);
}
