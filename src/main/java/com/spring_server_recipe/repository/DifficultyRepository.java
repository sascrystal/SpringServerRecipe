package com.spring_server_recipe.repository;

import com.spring_server_recipe.domain.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DifficultyRepository extends JpaRepository<Difficulty, Integer> {
    Difficulty findByName(String name);
    Difficulty findById(int id);
}
