package com.spring_server_recipe.service;


import com.spring_server_recipe.domain.Author;

import java.util.List;

public interface AuthorService {
    Author insert(String name);
    List<Author> findAll();
    Author findById(int id);
    Author findByName(String name);
    void deleteById(int id);
    Author update(int id,String name);
}
