package com.spring_server_recipe.repository;

import com.spring_server_recipe.domain.Recipe;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    List<Recipe> findAllByAuthorId(int authorId);
    List<Recipe> findAllByAuthorIdAndDifficultyId(int authorId, int difficultyId);
    List<Recipe> findAllByDifficultyId(int difficultyId);
    List<Recipe> findByRatingGreaterThan(int rating);
    Recipe findById(int id);


}
