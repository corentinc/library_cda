package com.greta.cda.library.service;

import com.greta.cda.library.dao.AuthorDao;
import com.greta.cda.library.domain.Author;
import com.greta.cda.library.domain.Book;
import com.greta.cda.library.exception.AuthorNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorDao authorDao;
    private final BookService bookService;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void create(String name) {
        Author myNewAuthor = new Author(UUID.randomUUID(), name, new ArrayList<>());
        authorDao.create(myNewAuthor);
        logger.info("Création de l'auteur : {}", myNewAuthor);
    }

    @Transactional
    public void attachBook(UUID authorId, Book book) {
        Author author = authorDao.findById(authorId).orElseThrow(() -> new AuthorNotFoundException());
        Book bookCreated = bookService.add(book.getName());
        bookCreated.setAuthor(author);
        author.getBooks().add(bookCreated);
        authorDao.update(author);
        bookService.update(bookCreated);
    }

    public List<Book> getById(UUID authorId) {
        Author author = authorDao.findById(authorId).orElseThrow(() -> new AuthorNotFoundException());
        return author.getBooks();
    }

    public List<Author> findAll() {
        return authorDao.findAll();
    }
}
