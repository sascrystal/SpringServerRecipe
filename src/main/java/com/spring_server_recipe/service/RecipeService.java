package com.spring_server_recipe.service;

import com.spring_server_recipe.domain.Difficulty;
import com.spring_server_recipe.domain.Ingredient;
import com.spring_server_recipe.domain.Recipe;
import com.spring_server_recipe.domain.Step;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();
    Recipe getRecipeById(int id);
    List<Recipe> getRecipesByName(String name);
    List<Recipe> getBestRecipes();
    List<Recipe> getRecipesRatingGreaterThan(int rating);
    List<Recipe> getRecipesByAuthorId(int id);
    List<Recipe> getBestRecipesByAuthorId(int id);
    List<Recipe> getBestRecipesByAuthorName(String name);
    List<Recipe> getRecipesByAuthorName(String name);
    List<Recipe> getRecipesByDifficultyId(int id);
    List<Recipe> getBestRecipesByDifficultyId(int id);
    List<Recipe> getBestRecipesByDifficultyName(String name);
    List<Recipe> getRecipesByDifficultyName(String name);
    List<Recipe> getBestRecipeByDifficultyIdAndAuthorId(int difficultyId, int authorId);
    List<Recipe> getRecipeByDifficultyIdAndAuthorId(int difficultyId, int authorId);
    Recipe createRecipe(String authorName, String  difficultyName, String recipe);
    Recipe updateRecipe(int id, String authorName, String difficultyName, String name);
    Recipe likeRecipeById(int id);
    void deleteRecipe(int id);



}
