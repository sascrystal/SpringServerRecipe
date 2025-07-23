package com.spring_server_recipe.rest.dto;

import com.spring_server_recipe.domain.Ingredient;
import com.spring_server_recipe.domain.Recipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeDto {
    private int id;
    private int rating;
    private String name;
    private String description;

    private AuthorDto authorDto;
    private DifficultyDto difficultyDto;
    private List<IngredientDto> ingredientsDto;
    private List<StepDto> stepsDto;

    public static RecipeDto toDto(Recipe recipe) {
        List<IngredientDto> ingredientsDto = recipe.getIngredients().stream().map(IngredientDto::toDto).toList();
        List<StepDto> stepsDto = recipe.getSteps().stream().map(StepDto::toDto).toList();
        AuthorDto authorDto = AuthorDto.toDto(recipe.getAuthor());
        DifficultyDto difficultyDto = DifficultyDto.toDto(recipe.getDifficulty());
        return new RecipeDto(
                recipe.getId(),
                recipe.getRating(),
                recipe.getName(),
                recipe.getDescription(),
                authorDto,
                difficultyDto,
                ingredientsDto,
                stepsDto
        );
    }
}
