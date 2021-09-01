package com.greta.cda.library.config;

import com.greta.cda.library.dao.BookDao;
import com.greta.cda.library.dao.BookDaoInMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    BookDao bookDao() {
        System.out.println("On utilise un dao en mémoire");
        BookDaoInMemory bookDaoInMemory = new BookDaoInMemory();
        return bookDaoInMemory;
    }
}
