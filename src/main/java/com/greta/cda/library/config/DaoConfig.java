package com.greta.cda.library.config;

import com.greta.cda.library.dao.BookDao;
import com.greta.cda.library.dao.BookDaoInMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    BookDao bookDao() {
        BookDaoInMemory bookDaoInMemory = new BookDaoInMemory();
        return bookDaoInMemory;
    }
}
