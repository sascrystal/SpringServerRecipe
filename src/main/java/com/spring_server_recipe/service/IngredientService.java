package com.spring_server_recipe.service;


import com.spring_server_recipe.domain.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findByRecipeId(int id);
    Ingredient insertIngredient(int recipeId, String name, String count);
    Ingredient updateIngredient(int id, String name, String count);
    Ingredient findById(int id);
}
