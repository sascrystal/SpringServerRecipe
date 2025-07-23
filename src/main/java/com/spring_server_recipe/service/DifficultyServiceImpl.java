package com.spring_server_recipe.service;

import com.spring_server_recipe.domain.Author;
import com.spring_server_recipe.domain.Difficulty;
import com.spring_server_recipe.repository.DifficultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DifficultyServiceImpl implements DifficultyService {

    private final DifficultyRepository difficultyRepository;

    @Override
    public Difficulty getDifficultyById(int id) {
        return difficultyRepository.findById(id);
    }

    @Override
    public Difficulty getDifficultyByName(String name) {
        return difficultyRepository.findByName(name);
    }

    @Override
    public Difficulty insertDifficulty(String name) {
        Difficulty difficulty = Difficulty.builder().name(name).build();
        return difficultyRepository.save(difficulty);
    }

    @Override
    public List<Difficulty> findAll() {

        return difficultyRepository.findAll();
    }

    @Override
    public Difficulty updateDifficulty(int id, String name) {
        Difficulty difficulty = Difficulty.builder().id(id).name(name).build();
        return difficultyRepository.save(difficulty);
    }

    @Override
    public void deleteDifficulty(int id) {
        difficultyRepository.deleteById(id);
    }
}
