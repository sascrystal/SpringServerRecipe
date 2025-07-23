package com.spring_server_recipe.rest.controller;

import com.spring_server_recipe.domain.Author;
import com.spring_server_recipe.repository.AuthorRepository;
import com.spring_server_recipe.rest.dto.AuthorDto;
import com.spring_server_recipe.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/author")
    public List<AuthorDto> getAuthors() {
        List<Author> authors = authorService.findAll();
        return authors.stream().map(AuthorDto::toDto).toList();
    }
    @GetMapping("/author/{id}")
    public AuthorDto getAuthorById(@PathVariable int id) {
        return AuthorDto.toDto(authorService.findById(id));
    }
    @GetMapping("/author/findByName")
    public AuthorDto getAuthorByName(@RequestParam String name) {
        return AuthorDto.toDto(authorService.findByName(name));
    }
    @DeleteMapping("/author/{id}")
    public void deleteAuthorById(@PathVariable int id) {
        authorService.deleteById(id);
    }
    @PostMapping("/author")
    public AuthorDto insertAuthor(@RequestParam String name) {
        return AuthorDto.toDto(authorService.insert(name));
    }
    @PutMapping("/author/{id}")
    public AuthorDto updateAuthor(@RequestParam String name, @PathVariable int id) {
        return AuthorDto.toDto(authorService.update(id, name));
    }
}
