package com.greta.cda.library.service;

import com.greta.cda.library.dao.BookDao;
import com.greta.cda.library.domain.Book;
import com.greta.cda.library.exception.BookNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
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

    public List<Book> findBooksContainingName(String name) {
        return bookDao.findBooksContainingName(name);
    }

    public Book findById(UUID id) {
//        Optional<Book> optionalBook = bookDao.findById(id);
//        if (optionalBook.isPresent()) {
//            return optionalBook.get();
//        }
//        throw new BookNotFoundException(id);

        return bookDao.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    public void delete(UUID uuid) {
        bookDao.delete(uuid);
    }

    public void update(UUID uuid, Book book) {
        Book myActualBook = findById(uuid);
        if (book.getName() != null) {
            myActualBook.setName(book.getName());
        }
        bookDao.update(myActualBook);
    }
}
