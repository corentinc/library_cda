package com.greta.cda.library.dao;

import com.greta.cda.library.domain.Book;

import java.util.*;
import java.util.stream.Collectors;

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
    public Iterator<Book> iteratorOnAll() {
        return books.iterator();
    }

    @Override
    public void add(Book book) {
        books.add(book);
    }

    public List<Book> findBooksContainingName(String name) {
        return books.stream()
                .filter(book -> book.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findById(UUID id) {
//        for (Book book : books) {
//            if (book.getId().equals(id)) {
//                return Optional.of(book);
//            }
//        }
//        return Optional.empty();

        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }
}
