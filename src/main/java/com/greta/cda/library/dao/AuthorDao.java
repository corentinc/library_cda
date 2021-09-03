package com.greta.cda.library.dao;

import com.greta.cda.library.domain.Author;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorDao {
    void create(Author author);

    List<Author> findAll();

    Optional<Author> findById(UUID id);

    void update(Author author);
}
