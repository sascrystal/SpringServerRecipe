package com.spring_server_recipe.service;

import com.spring_server_recipe.domain.Step;

import java.util.List;

public interface StepService {
    Step insertStepByRecipeId(String description,int id);
    Step updateStepByStepId(int id,String description, int recipeId);
    void deleteStepByStepId(int id);
    List<Step> getAllStepsByRecipeId(int id);


}
