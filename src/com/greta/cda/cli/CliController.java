package com.greta.cda.cli;

import com.greta.cda.domain.Book;
import com.greta.cda.service.BookService;

import java.util.List;
import java.util.Scanner;

/**
 * Est responsable des entrée/sortie utilisateurs
 */
public class CliController {
    // a un dépendance vers bookService
    private BookService bookService;

    public CliController(BookService bookService) {
        this.bookService = bookService;
    }

    public void start() {
        System.out.println("--------------------");
        System.out.println("1 - Afficher l'ensemble des livres");
        System.out.println("--------------------");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        if (choice.equals("1")) {
            List<Book> allBooks = bookService.findAll();
            for (Book currentBook : allBooks) {
                System.out.println(currentBook);
            }
        }

    }
}
