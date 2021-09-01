package com.greta.cda.library.cli;

import com.greta.cda.library.domain.Book;
import com.greta.cda.library.service.BookService;
import org.springframework.stereotype.Controller;

import java.util.Iterator;
import java.util.Scanner;
import java.util.UUID;

/**
 * Est responsable des entrée/sortie utilisateurs
 */
@Controller
public class CliController {
    // a un dépendance vers bookService
    private BookService bookService;

    public CliController(BookService bookService) {
        this.bookService = bookService;
    }

    public void start() {
        System.out.println("--------------------");
        System.out.println("1 - Afficher l'ensemble des livres");
        System.out.println("2 - Rechercher par titre");
        System.out.println("3 - Rechercher par id");
        System.out.println("--------------------");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        if (choice.equals("1")) {
            Iterator<Book> iterator = bookService.findAll();
            while (iterator.hasNext()) {
                System.out.println(iterator.next().toString());
            }
        } else if (choice.equals("2")) {
            System.out.println("Quel titre ? : ");
            String searchedName = scanner.next();
            bookService.findBooksContainingName(searchedName).forEach(book -> System.out.println(book));
        } else if (choice.equals("3")) {
            System.out.println("Quel id ? : ");
            String id = scanner.next();
            bookService.findById(UUID.fromString(id));
        }

    }
}
