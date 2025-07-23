package com.spring_server_recipe.rest.controller;

import com.spring_server_recipe.rest.dto.IngredientDto;
import com.spring_server_recipe.rest.dto.StepDto;
import com.spring_server_recipe.service.StepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StepController {
    private final StepService stepService;

    @GetMapping("/step")
    public List<StepDto> getStepsByRecipeId(@RequestBody int recipeId) {
        return stepService.getAllStepsByRecipeId(recipeId).stream().map(StepDto::toDto).toList();
    }
    @DeleteMapping("/step/{id}")
    public void deleteStepById(@PathVariable int id) {
        stepService.deleteStepByStepId(id);
    }

    @PutMapping("/step")
    public StepDto createStep(@RequestBody String description,@RequestBody int recipeId) {
        return StepDto.toDto(stepService.insertStepByRecipeId(description, recipeId));
    }
    @PostMapping("/step/{id}")
    public StepDto updateStepById(@PathVariable int id, @RequestBody String description) {
        return StepDto.toDto(stepService.updateStepByStepId(id,description));
    }




}
