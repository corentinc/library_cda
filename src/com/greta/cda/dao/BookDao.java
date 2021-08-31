package com.greta.cda.dao;

import com.greta.cda.domain.Book;

import java.util.Iterator;
import java.util.List;

/**
 * Définit ce qu'on peut attendre du DAO
 */
public interface BookDao {
    List<Book> findAll();

    Iterator<Book> iteratorOnAll();

    void add(Book book);

    List<Book> findBooksContainingName(String name);
}
