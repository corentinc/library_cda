package com.greta.cda.library.dao;

import com.greta.cda.library.domain.Book;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Définit ce qu'on peut attendre du DAO
 */
public interface BookDao {
    List<Book> findAll();

    void add(Book book);

    List<Book> findBooksContainingName(String name);

    Optional<Book> findById(UUID id);

    void delete(UUID uuid);

    void update(Book book);
}
