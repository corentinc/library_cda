package com.greta.cda.library;

import com.greta.cda.library.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        BookService bookService = applicationContext.getBean(BookService.class);
        initData(bookService);
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
