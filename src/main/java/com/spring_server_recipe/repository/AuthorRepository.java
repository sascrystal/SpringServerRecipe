package com.spring_server_recipe.repository;

import com.spring_server_recipe.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    Author findByName(String name);
    Author findById(int id);

}
