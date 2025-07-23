package com.spring_server_recipe.rest.controller;

import com.spring_server_recipe.domain.Ingredient;
import com.spring_server_recipe.rest.dto.IngredientDto;
import com.spring_server_recipe.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;

    @GetMapping("/ingredient")
    public List<IngredientDto> getIngredientByRecipeId(@RequestParam int recipeId) {
        return ingredientService.findByRecipeId(recipeId).stream().map(IngredientDto::toDto).toList();
    }

    @GetMapping("/ingredient/{id}")
    public IngredientDto getIngredientById(@PathVariable int id) {
        return IngredientDto.toDto(ingredientService.findById(id));
    }

    @PostMapping("/ingredient")
    public IngredientDto createIngredient(@RequestBody int recipeId, @RequestParam String name,@RequestParam String count) {
        return IngredientDto.toDto(ingredientService.insertIngredient(recipeId,name,count));
    }
    @PutMapping("/ingredient/{id}")
    public IngredientDto updateIngredient(@PathVariable int id, @RequestParam String name, @RequestParam String count) {
        return IngredientDto.toDto(ingredientService.updateIngredient(id, name, count));

    }



}
