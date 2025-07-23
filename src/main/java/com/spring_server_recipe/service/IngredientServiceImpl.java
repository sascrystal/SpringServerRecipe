package com.spring_server_recipe.service;

import com.spring_server_recipe.domain.Ingredient;
import com.spring_server_recipe.domain.Recipe;
import com.spring_server_recipe.repository.IngredientRepository;
import com.spring_server_recipe.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;

    @Override
    public List<Ingredient> findByRecipeId(int id) {
        return ingredientRepository.findAllByRecipeId(id);
    }

    @Override
    public Ingredient insertIngredient(int recipeId, String name, String count) {
        Recipe recipe = recipeRepository.findById(recipeId);
        if (recipe == null) {
            return null;
        }
        Ingredient ingredient = Ingredient.builder()
                .recipe(recipe).count(count).name(name).build();
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient updateIngredient(int id, String name, String count) {
        Ingredient oldIngredient = ingredientRepository.findById(id);
        if (oldIngredient == null) {
            return null;
        }
        oldIngredient.setName(name);
        oldIngredient.setCount(count);
        return ingredientRepository.save(oldIngredient);
    }

    @Override
    public Ingredient findById(int id) {
        return ingredientRepository.findById(id);
    }
}
