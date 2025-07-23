package com.spring_server_recipe.service;

import com.spring_server_recipe.domain.*;
import com.spring_server_recipe.repository.AuthorRepository;
import com.spring_server_recipe.repository.DifficultyRepository;
import com.spring_server_recipe.repository.IngredientRepository;
import com.spring_server_recipe.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final AuthorRepository authorRepository;
    private final DifficultyRepository difficultyRepository;

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeById(int id) {
        return recipeRepository.findById(id);
    }

    @Override
    public List<Recipe> getRecipesByName(String name) {
        return recipeRepository.findByName(name);
    }

    @Override
    public List<Recipe> getBestRecipes() {
        List<Recipe> recipes = getAllRecipes();
        return sortByRating(recipes);
    }

    @Override
    public List<Recipe> getRecipesRatingGreaterThan(int rating) {
        List<Recipe> recipes = recipeRepository.findAllByRatingGreaterThan(rating);
        return sortByRating(recipes);
    }

    @Override
    public List<Recipe> getRecipesByAuthorId(int id) {
        return recipeRepository.findAllByAuthorId(id);
    }

    @Override
    public List<Recipe> getBestRecipesByAuthorId(int id) {
        List<Recipe> recipes = recipeRepository.findAllByAuthorId(id);
        return sortByRating(recipes);
    }

    @Override
    public List<Recipe> getBestRecipesByAuthorName(String name) {
        List<Recipe> recipes = getRecipesByAuthorName(name);
        return sortByRating(recipes);
    }

    @Override
    public List<Recipe> getRecipesByAuthorName(String name) {
        return recipeRepository.findByName(name);
    }

    @Override
    public List<Recipe> getRecipesByDifficultyId(int id) {

        return recipeRepository.findAllByDifficultyId(id);
    }

    @Override
    public List<Recipe> getBestRecipesByDifficultyId(int id) {
        List<Recipe> recipes = getRecipesByDifficultyId(id);
        return sortByRating(recipes);
    }

    @Override
    public List<Recipe> getBestRecipesByDifficultyName(String name) {
        List<Recipe> recipes = getRecipesByDifficultyName(name);

        return sortByRating(recipes);
    }

    @Override
    public List<Recipe> getRecipesByDifficultyName(String name) {

        return recipeRepository.findAllByDifficultyName(name);
    }

    @Override
    public List<Recipe> getBestRecipeByDifficultyIdAndAuthorId(int difficultyId, int authorId) {
        List<Recipe> recipes = getRecipeByDifficultyIdAndAuthorId(difficultyId, authorId);
        return sortByRating(recipes);
    }

    @Override
    public List<Recipe> getRecipeByDifficultyIdAndAuthorId(int difficultyId, int authorId) {
        return recipeRepository.findAllByAuthorIdAndDifficultyId(authorId, difficultyId);
    }

    @Override
    public Recipe CreateRecipe(String authorName, String difficultyName, String recipeName) {
        Author author = authorRepository.findByName(authorName);
        if (author == null) {
            Author newAuthor = Author.builder().name(authorName).build();
            authorRepository.save(newAuthor);
        }
        Difficulty difficulty = difficultyRepository.findByName(difficultyName);
        if (difficulty == null) {
            difficulty = difficultyRepository.findById(1);// сделано так, чтобы не плодить новые сложности которые не нужны
        }
        Recipe recipe = Recipe.builder().author(author).difficulty(difficulty).rating(0).build();
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe updateRecipe(int id, String authorName, String difficultyName, String name, List<Step> steps, List<Ingredient> ingredients) {
        Author author = authorRepository.findByName(authorName);
        if (author == null) {
            Author newAuthor = Author.builder().name(authorName).build();
            authorRepository.save(newAuthor);
        }
        Difficulty difficulty = difficultyRepository.findByName(difficultyName);
        if (difficulty == null) {
            difficulty = difficultyRepository.findById(1);// сделано так, чтобы не плодить новые сложности которые не нужны
        }
        Recipe recipe = recipeRepository.findById(id);
        if (recipe == null) {
            return Recipe.builder().author(author).difficulty(difficulty).steps(steps).ingredients(ingredients).rating(0).build();
        } else {
            return Recipe.builder()
                    .id(recipe.getId())
                    .name(name)
                    .author(author)
                    .steps(steps)
                    .ingredients(ingredients)
                    .difficulty(difficulty)
                    .rating(recipe.getRating()).build();
        }
    }

    @Override
    public Recipe likeRecipeById(int id) {
        Recipe recipe = recipeRepository.findById(id);
        recipe.setRating(recipe.getRating() + 1);
        return recipeRepository.save(recipe);
    }

    @Override
    public void deleteRecipe(int id) {
        recipeRepository.deleteById(id);
    }

    private List<Recipe> sortByRating(List<Recipe> recipes) {
        if (recipes.isEmpty()) {
            return recipes;
        }
        recipes.sort(Comparator.comparingInt(Recipe::getRating).reversed());
        return recipes;
    }

}
