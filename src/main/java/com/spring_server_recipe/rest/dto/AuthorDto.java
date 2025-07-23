package com.spring_server_recipe.rest.dto;

import com.spring_server_recipe.domain.Author;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDto {
    private int id;
    private String name;

    public static AuthorDto toDto(Author author) {
        return new AuthorDto(
                author.getId(), author.getName()
        );
    }

    public static Author toEntity(AuthorDto authorDto) {
        return new Author(
                authorDto.getId(), authorDto.getName()
        );
    }

}
