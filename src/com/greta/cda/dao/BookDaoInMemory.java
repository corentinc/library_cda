package com.greta.cda.dao;

import com.greta.cda.domain.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Implémente l'interface BookDAO
 * Cette implémentation choisit de stocker nos livres en mémoire (dans une ArrayList)
 */
public class BookDaoInMemory implements BookDao {
    private List<Book> books = new ArrayList<>();

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public void add(Book book) {
        books.add(book);
    }
}
