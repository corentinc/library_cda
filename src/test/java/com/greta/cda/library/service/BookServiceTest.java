package com.greta.cda.library.service;

import com.greta.cda.library.dao.BookDao;
import com.greta.cda.library.domain.Book;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class BookServiceTest {
    BookDao mockedDao;
    BookService bookService;

    @Before
    public void setUp() {
        // mock : simulation de comportemant d'une classe
        mockedDao = mock(BookDao.class);

        // service que je veux tester
        bookService = new BookService(mockedDao);
    }

    @Test
    public void findBooksContainingName() {
        List<Book> expectedBooks = Arrays.asList(
                new Book(UUID.randomUUID(), "Toto à la plage"),
                new Book(UUID.randomUUID(), "Toto au greta")
        );
        // lorsque le service va appeler cette méthode sur le mock
        // le mock lui retournera la liste ci-dessus
        when(mockedDao.findBooksContainingName("Toto")).thenReturn(expectedBooks);

        // j'appelle la méthode testée
        List<Book> actualBooks = bookService.findBooksContainingName("Toto");

        // je m'assure que son résultat est bien celui que j'attends
        assertThat(actualBooks, equalTo(expectedBooks));
    }

    @Test
    public void findBooksContainingName_whenNoBookFound() {
        when(mockedDao.findBooksContainingName("Nicolas")).thenReturn(new ArrayList<>());

        List<Book> actualBooks = bookService.findBooksContainingName("Nicolas");

        assertThat(actualBooks.size(), equalTo(0));
    }

    @Test
    public void add() {
        bookService.add("Toto");

        ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);
        verify(mockedDao).add(bookArgumentCaptor.capture());

        Book bookSentToDAO = bookArgumentCaptor.getValue();
        assertThat(bookSentToDAO.getId(), is(notNullValue()));
        assertThat(bookSentToDAO.getName(), is("Toto"));
    }
}