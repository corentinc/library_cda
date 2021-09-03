package com.greta.cda.library.service;

import com.greta.cda.library.dao.BookDao;
import com.greta.cda.library.domain.Book;
import com.greta.cda.library.exception.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookDao bookDao;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public Book add(String name) {
        Book newBook = new Book(UUID.randomUUID(), name);
        bookDao.add(newBook);
        logger.info("Un nouveau livre a été créé : nom={}", name);
        return newBook;
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }

    public List<Book> findBooksContainingName(String name) {
        return bookDao.findBooksContainingName(name);
    }

    public Book findById(UUID id) {
        return bookDao.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    public void delete(UUID uuid) {
        bookDao.delete(uuid);
    }

    public void update(Book book) {
        bookDao.update(book);
    }
}
