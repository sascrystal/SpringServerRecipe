package com.spring_server_recipe.repository;

import com.spring_server_recipe.domain.Step;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StepRepository extends JpaRepository<Step, Integer> {
    List<Step> findByRecipeId(int recipeId);
    Step findById(int stepId);

}
