package com.greta.cda.library;

import com.greta.cda.library.cli.CliController;
import com.greta.cda.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = applicationContext.getBean(BookService.class);
        initData(bookService);

        applicationContext.getBean(CliController.class).start();
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
