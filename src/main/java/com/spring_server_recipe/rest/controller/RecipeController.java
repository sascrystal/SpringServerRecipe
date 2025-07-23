package com.spring_server_recipe.rest.controller;

import com.spring_server_recipe.rest.dto.RecipeDto;
import com.spring_server_recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("/recipe")
    public List<RecipeDto> getAllRecipes() {
        return recipeService.getAllRecipes().stream().map(RecipeDto::toDto).toList();
    }

    @GetMapping("/recipe/sortedByRating")
    public List<RecipeDto> getRecipeSortedByRating() {
        return recipeService.getBestRecipes().stream().map(RecipeDto::toDto).toList();
    }

    @GetMapping("/recipe/{id}")
    public RecipeDto getRecipe(@PathVariable int id) {
        return RecipeDto.toDto(recipeService.getRecipeById(id));
    }

    @GetMapping("/recipe/findByAuthor")
    public List<RecipeDto> getRecipeByAuthorId(@RequestParam int author_id) {
        return recipeService.getRecipesByAuthorId(author_id).stream().map(RecipeDto::toDto).toList();
    }

    @GetMapping("/recipe/findByName")
    public List<RecipeDto> getRecipeByName(@RequestParam String name) {
        return recipeService.getRecipesByName(name).stream().map(RecipeDto::toDto).toList();
    }

    @GetMapping("/recipe/findRatingGreaterThan")
    public List<RecipeDto> getRecipeByRatingGreaterThan(@RequestParam int rating) {
        return recipeService.getRecipesRatingGreaterThan(rating).stream().map(RecipeDto::toDto).toList();
    }

    @GetMapping("/recipe/findByAuthorId/sortedByRating")
    public List<RecipeDto> getRecipeSortedByRatingByAuthorId(@RequestParam int author_id) {
        return recipeService.getBestRecipesByAuthorId(author_id).stream().map(RecipeDto::toDto).toList();
    }

    @GetMapping("/recipe/findByDifficultyId")
    public List<RecipeDto> getRecipeByDifficultyId(@RequestParam int difficulty_id) {
        return recipeService.getRecipesByDifficultyId(difficulty_id).stream().map(RecipeDto::toDto).toList();
    }

    @GetMapping("/recipe/findByDifficultyId/sortedByRating")
    public List<RecipeDto> getRecipeSortedByRatingByDifficulty(@RequestParam int difficulty_id) {
        return recipeService.getBestRecipesByDifficultyId(difficulty_id).stream().map(RecipeDto::toDto).toList();
    }

    @GetMapping("/recipe/findByDifficultyId&ByAuthorId")
    public List<RecipeDto> getRecipeByDifficultyIdAndAuthorId(@RequestParam int difficulty_id, @RequestParam int author_id) {
        return recipeService.getRecipeByDifficultyIdAndAuthorId(difficulty_id, author_id).stream().map(RecipeDto::toDto).toList();
    }

    @GetMapping("/recipe/findByDifficultyId&ByAuthorId/sortedByRating")
    public List<RecipeDto> getRecipeSortedByRatingByDifficultyIdAndAuthorId(@RequestParam int difficulty_id, @RequestParam int author_id) {
        return recipeService.getBestRecipeByDifficultyIdAndAuthorId(difficulty_id, author_id).stream().map(RecipeDto::toDto).toList();
    }

    @DeleteMapping("/recipe/{id}")
    public void deleteRecipe(@PathVariable int id) {
        recipeService.deleteRecipe(id);
    }

    @PostMapping("/recipe/{id}")
    public RecipeDto updateRecipe(@RequestParam String name, @PathVariable int id, @RequestParam String authorName, @RequestParam String difficultyName) {
        return RecipeDto.toDto(recipeService.updateRecipe(id, authorName, difficultyName, name));

    }
    @PostMapping("/recipe")
    public RecipeDto createRecipe(@RequestParam String name, @RequestParam String authorName, @RequestParam String difficultyName) {
        return RecipeDto.toDto(recipeService.createRecipe( authorName, difficultyName, name));

    }
    @PutMapping("/recipe/{id}/like")
    public RecipeDto likeRecipe(@PathVariable int id) {
        return RecipeDto.toDto(recipeService.likeRecipeById(id));
    }

}
