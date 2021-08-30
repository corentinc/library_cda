package com.greta.cda.service;

import com.greta.cda.dao.BookDao;
import com.greta.cda.domain.Book;

import java.util.List;
import java.util.UUID;

public class BookService {
    // a une dépendance vers le BookDao
    private BookDao bookDao;

    public BookService(BookDao bookDao) {
        // Ne sait pas quelle implémentation de BookDao on lui a envoyée
        this.bookDao = bookDao;
    }

    public void add(String name) {
        Book newBook = new Book(UUID.randomUUID(), name);
        bookDao.add(newBook);
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }
}
