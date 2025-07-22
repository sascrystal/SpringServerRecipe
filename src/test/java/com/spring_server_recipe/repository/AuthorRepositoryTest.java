package com.spring_server_recipe.repository;

import com.spring_server_recipe.domain.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;


    @DisplayName("Должен находить автора по имени")
    @Test
    void shouldFindAuthorByName(){
        Author findAuthor = authorRepository.findByName("Антон");
        int expectedId = 1;
        assertThat(findAuthor.getId()).isEqualTo(expectedId);
    }

    @DisplayName("должен добавлять нового автора")
    @Test
    void shouldInsertAuthor() {
        Author newAuthor = Author.builder().name("Женя").build();
        authorRepository.save(newAuthor);
        Author findAuthor = authorRepository.findByName(newAuthor.getName());
        assertThat(newAuthor).isEqualTo(findAuthor);
    }

    @DisplayName("должен находить автора по id")
    @Test
    void shouldFindAuthorById() {
        Author findAuthor = authorRepository.findById(1);
        String expectedName = "Антон";
        assertThat(findAuthor.getName()).isEqualTo(expectedName);
    }

    @DisplayName("Должен обновлять автора по id")
    @Test
    void shouldUpdateAuthor() {
        Author newAuthor = Author.builder().id(1).name("Не АНТОН").build();
        authorRepository.save(newAuthor);
        Author actualAuthor = authorRepository.findById(1);
        assertThat(actualAuthor).isEqualTo(newAuthor);
    }

    @DisplayName("Должен удалять автора")
    @Test
    void shouldDeleteAuthor() {
        int sizeBeforeDelete = authorRepository.findAll().size();
        authorRepository.deleteById(1);
        int sizeAfterDelete = authorRepository.findAll().size();
        assertThat(sizeBeforeDelete).isEqualTo(sizeAfterDelete+1);
    }

}
