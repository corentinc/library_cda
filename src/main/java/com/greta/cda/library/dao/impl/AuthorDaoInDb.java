package com.greta.cda.library.dao.impl;

import com.greta.cda.library.dao.AuthorDao;
import com.greta.cda.library.domain.Author;
import com.greta.cda.library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class AuthorDaoInDb implements AuthorDao {
    private final AuthorRepository authorRepository;

    @Override
    public void create(Author author) {
        authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(UUID id) {
        return authorRepository.findById(id);
    }

    @Override
    public void update(Author author) {
        authorRepository.save(author);
    }
}
