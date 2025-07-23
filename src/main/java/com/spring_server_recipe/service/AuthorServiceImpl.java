package com.spring_server_recipe.service;

import com.spring_server_recipe.domain.Author;
import com.spring_server_recipe.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Author insert(String name) {
        Author author = Author.builder().name(name).build();
        authorRepository.save(author);
        return author;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(int id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author findByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);


    }

    @Override
    public Author update(int id, String name) {
        Author author = Author.builder().id(id).name(name).build();
        authorRepository.save(author);
        return author;
    }
}
