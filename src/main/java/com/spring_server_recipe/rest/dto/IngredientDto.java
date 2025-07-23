package com.spring_server_recipe.rest.dto;

import com.spring_server_recipe.domain.Ingredient;
import com.spring_server_recipe.domain.Recipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientDto {
    private int id;
    private String name;
    private String count;
    public static IngredientDto toDto(Ingredient ingredient) {
        return new IngredientDto(
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getCount()
        );
    }
    public static Ingredient toEntity(IngredientDto ingredientDto, Recipe recipe) {
        return new Ingredient(
                ingredientDto.getId(),
                ingredientDto.getName(),
                ingredientDto.getCount(),
                recipe
        );
    }
}
