package com.greta.cda.library.dao.impl;

import com.greta.cda.library.dao.BookDao;
import com.greta.cda.library.domain.Book;
import com.greta.cda.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Primary
@RequiredArgsConstructor
public class BookDaoInDb implements BookDao {
    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findBooksContainingName(String name) {
        return bookRepository.findAllByNameContaining(name);
    }

    @Override
    public Optional<Book> findById(UUID id) {
        return bookRepository.findById(id);
    }

    @Override
    public void delete(UUID uuid) {
        bookRepository.deleteById(uuid);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }
}
