package com.spring_server_recipe.service;

import com.spring_server_recipe.domain.Difficulty;

import java.util.List;

public interface DifficultyService {
    Difficulty getDifficultyById(int id);
    Difficulty getDifficultyByName(String name);
    Difficulty insertDifficulty(String name);
    List<Difficulty> findAll();
    Difficulty updateDifficulty(int id,String name);
    void deleteDifficulty(int id);
}
