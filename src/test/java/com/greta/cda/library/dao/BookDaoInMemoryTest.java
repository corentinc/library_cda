package com.greta.cda.library.dao;

import com.greta.cda.library.dao.impl.BookDaoInMemory;
import com.greta.cda.library.domain.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class BookDaoInMemoryTest {
    private BookDao bookDao;
    private Book firstBook;
    private Book secondBook;

    @BeforeEach
    void setUp() {
        bookDao = new BookDaoInMemory();

        firstBook = new Book(UUID.randomUUID(), "toto");
        secondBook = new Book(UUID.randomUUID(), "tata");

        bookDao.add(firstBook);
        bookDao.add(secondBook);
    }

    @Test
    void findAll() {
        assertThat(bookDao.findAll(), hasItems(firstBook, secondBook));
    }

    @Test
    void findById() {
        assertThat(bookDao.findById(secondBook.getId()), equalTo(Optional.of(secondBook)));
    }

    @Test
    void findById_notFound() {
        assertThat(bookDao.findById(UUID.randomUUID()), equalTo(Optional.empty()));
    }

    @Test
    void remove() {
        bookDao.delete(firstBook.getId());
        assertThat(bookDao.findById(firstBook.getId()), equalTo(Optional.empty()));
        assertThat(bookDao.findAll(), equalTo(Arrays.asList(secondBook)));
    }

    @Test
    void update() {
        Book bookToUpdate = new Book(secondBook.getId(), "Le second a changé de nom");
        bookDao.update(bookToUpdate);

        assertThat(bookDao.findById(secondBook.getId()).get().getName(), equalTo("Le second a changé de nom"));
    }
}