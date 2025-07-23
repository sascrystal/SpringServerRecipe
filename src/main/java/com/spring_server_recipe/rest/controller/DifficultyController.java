package com.spring_server_recipe.rest.controller;

import com.spring_server_recipe.domain.Author;
import com.spring_server_recipe.domain.Difficulty;
import com.spring_server_recipe.rest.dto.AuthorDto;
import com.spring_server_recipe.rest.dto.DifficultyDto;
import com.spring_server_recipe.service.DifficultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DifficultyController {
    private final DifficultyService difficultyService;

    @GetMapping("/difficulty")
    public List<DifficultyDto> getDifficulties() {
        List<Difficulty> difficulties = difficultyService.findAll();
        return difficulties.stream().map(DifficultyDto::toDto).toList();
    }
    @GetMapping("/difficulty/{id}")
    public DifficultyDto getDifficultyById(@PathVariable int id) {
        return DifficultyDto.toDto(difficultyService.getDifficultyById(id));
    }
    @GetMapping("/difficulty/findByName")
    public DifficultyDto getDifficultyByName(@RequestParam String name) {
        return DifficultyDto.toDto(difficultyService.getDifficultyByName(name));
    }
    @DeleteMapping("/difficulty/{id}")
    public void deleteDifficultyById(@PathVariable int id) {
        difficultyService.deleteDifficulty(id);
    }
    @PostMapping("/difficulty")
    public DifficultyDto insertDifficulty(@RequestParam String name) {

        return DifficultyDto.toDto(difficultyService.insertDifficulty(name));
    }
    @PutMapping("/difficulty/{id}")
    public DifficultyDto updateDifficulty(@RequestParam String name, @PathVariable int id) {
        return DifficultyDto.toDto(difficultyService.updateDifficulty(id, name));
    }

}
