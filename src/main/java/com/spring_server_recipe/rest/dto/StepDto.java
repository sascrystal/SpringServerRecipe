package com.spring_server_recipe.rest.dto;

import com.spring_server_recipe.domain.Recipe;
import com.spring_server_recipe.domain.Step;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StepDto {
    private int id;
    private String description;

    public static StepDto toDto(Step step) {
        return new StepDto(step.getId(), step.getDescription());
    }
    public static Step toEntity(StepDto stepDto, Recipe recipe) {
        return new Step(stepDto.getId(), stepDto.getDescription(),recipe);
    }
}
