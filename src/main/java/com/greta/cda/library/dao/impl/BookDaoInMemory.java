package com.greta.cda.library.dao.impl;

import com.greta.cda.library.dao.BookDao;
import com.greta.cda.library.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implémente l'interface BookDAO
 * Cette implémentation choisit de stocker nos livres en mémoire (dans une ArrayList)
 */
@Repository
public class BookDaoInMemory implements BookDao {
    private Map<UUID, Book> bookMap = new HashMap<>();

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(bookMap.values());
    }

    @Override
    public void add(Book book) {
        bookMap.put(book.getId(), book);
    }

    @Override
    public List<Book> findBooksContainingName(String name) {
        return bookMap.values()
                .stream()
                .filter(book -> book.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findById(UUID id) {
        return bookMap.values()
                .stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    @Override
    public void delete(UUID uuid) {
        bookMap.remove(uuid);
    }

    @Override
    public void update(Book book) {
        bookMap.put(book.getId(), book);
    }
}
