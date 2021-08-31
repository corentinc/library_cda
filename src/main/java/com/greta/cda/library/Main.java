package com.greta.cda.library;

import com.greta.cda.library.cli.CliController;
import com.greta.cda.library.dao.BookDao;
import com.greta.cda.library.dao.BookDaoInMemory;
import com.greta.cda.library.service.BookService;

public class Main {

    public static void main(String[] args) {
        BookDao bookDao = new BookDaoInMemory();
        BookService bookService = new BookService(bookDao);
        CliController cliController = new CliController(bookService);
        initData(bookService);
        cliController.start();
    }

    /**
     * Initialise quelques données par défaut afin de ne pas tout perdre à chaque redémarrage
     * @param bookService
     */
    private static void initData(BookService bookService) {
        bookService.add("La rivière à l'envers");
        bookService.add("Toto à la plage");
    }
}
