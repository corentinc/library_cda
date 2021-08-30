package com.greta.cda.dao;

import com.greta.cda.domain.Book;

import java.util.List;

/**
 * Définit ce qu'on peut attendre du DAO
 */
public interface BookDao {
    List<Book> findAll();

    void add(Book book);
}
