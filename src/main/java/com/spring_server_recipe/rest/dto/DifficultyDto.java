package com.spring_server_recipe.rest.dto;

import com.spring_server_recipe.domain.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DifficultyDto {
    private int id;
    private String name;
    public static DifficultyDto toDto (Difficulty difficulty) {
        return new DifficultyDto(
                difficulty.getId(),
                difficulty.getName()
        );
    }

    public static Difficulty toEntity (DifficultyDto dto) {
        return new Difficulty(
                dto.getId(),
                dto.getName()
        );
    }
}
