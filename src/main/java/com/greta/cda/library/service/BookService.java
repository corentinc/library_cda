package com.greta.cda.library.service;

import com.greta.cda.library.dao.BookDao;
import com.greta.cda.library.domain.Book;

import java.util.Iterator;
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

    public Iterator<Book> findAll() {
        return bookDao.iteratorOnAll();
    }

    public List<Book> findBooksContainingName(String name) {
        return bookDao.findBooksContainingName(name);
    }
}
