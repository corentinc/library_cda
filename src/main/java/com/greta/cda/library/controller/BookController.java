package com.greta.cda.library.controller;

import com.greta.cda.library.domain.Book;
import com.greta.cda.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Book book) {
        bookService.add(book.getName());
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        bookService.delete(uuid);
    }

    @PutMapping("/{uuid}")
    public void update(@PathVariable UUID uuid, @RequestBody Book book) {
        book.setId(uuid);
        bookService.update(book);
    }

    @GetMapping("/name/{queryName}")
    public List<Book> findByName(@PathVariable String queryName) {
        return bookService.findBooksContainingName(queryName);
    }
}
