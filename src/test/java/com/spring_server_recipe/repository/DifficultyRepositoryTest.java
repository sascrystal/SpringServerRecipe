package com.spring_server_recipe.repository;

import com.spring_server_recipe.domain.Author;
import com.spring_server_recipe.domain.Difficulty;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class DifficultyRepositoryTest {

    @Autowired
    private DifficultyRepository difficultyRepository;

    @DisplayName("Должен находить автора по имени")
    @Test
    void shouldFindDifficultyByName(){
        Difficulty findDifficulty = difficultyRepository.findByName("Лёгкий");
        int expectedId = 1;
        assertThat(findDifficulty.getId()).isEqualTo(expectedId);
    }

    @DisplayName("должен находить автора по id")
    @Test
    void shouldFindAuthorById() {
        Difficulty findDifficulty = difficultyRepository.findById(1);
        String expectedName = "Лёгкий";
        assertThat(findDifficulty.getName()).isEqualTo(expectedName);
    }
}
