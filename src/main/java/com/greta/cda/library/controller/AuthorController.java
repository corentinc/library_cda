package com.greta.cda.library.controller;

import com.greta.cda.library.domain.Author;
import com.greta.cda.library.domain.Book;
import com.greta.cda.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public void create(@RequestBody Author author) {
        authorService.create(author.getName());
    }

    @PostMapping("/{id}/book")
    public void addBook(@PathVariable UUID id, @RequestBody Book book) {
        authorService.attachBook(id, book);
    }

    @GetMapping("/{id}/book")
    public List<Book> findBooksByAuthorId(@PathVariable UUID id) {
        return authorService.getById(id);
    }

    @GetMapping
    public List<Author> findAll() {
        return authorService.findAll();
    }
}
