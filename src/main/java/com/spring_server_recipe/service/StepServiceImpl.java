package com.spring_server_recipe.service;

import com.spring_server_recipe.domain.Recipe;
import com.spring_server_recipe.domain.Step;
import com.spring_server_recipe.repository.RecipeRepository;
import com.spring_server_recipe.repository.StepRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StepServiceImpl implements StepService {
    private final StepRepository stepRepository;
    private final RecipeRepository recipeRepository;
    @Override
    public Step insertStepByRecipeId(String description, int id) {
        Recipe recipe = recipeRepository.findById(id);
        if (recipe == null) {
            return null;
        }
        Step step = Step.builder().description(description).recipe(recipe).build();
        return  stepRepository.save(step);
    }

    @Override
    public Step updateStepByStepId(int id,String description) {
        Step step = stepRepository.findById(id);
        if (step == null) {
            return null;
        }
        Step newStep = Step.builder().id(id).description(description).recipe(step.getRecipe()).build();
        return stepRepository.save(newStep);
    }

    @Override
    public void deleteStepByStepId(int id) {
         stepRepository.deleteById(id);
    }

    @Override
    public List<Step> getAllStepsByRecipeId(int id) {
        Recipe recipe = recipeRepository.findById(id);
        if (recipe == null) {
            return List.of();
        }
        return stepRepository.findByRecipeId(id);
    }
}
