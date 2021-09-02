package com.greta.cda.library.controller;

import com.greta.cda.library.domain.Book;
import com.greta.cda.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @MockBean
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        when(bookService.findAll()).thenReturn(Arrays.asList(
                new Book(UUID.fromString("11111111-1111-1111-1111-111111111111"), "Toto à la plage")
        ));

        mockMvc.perform(get("/book"))
                .andExpect(jsonPath("$[0].id", is("11111111-1111-1111-1111-111111111111")))
                .andExpect(jsonPath("$[0].name", is("Toto à la plage")));
    }

    @Test
    void update() throws Exception {
        String bodyAsJson = "{\n" +
                "  \"name\": \"nouveau\"\n" +
                "}\n";

        mockMvc.perform(put("/book/11111111-1111-1111-1111-111111111111")
            .contentType(MediaType.APPLICATION_JSON)
                .content(bodyAsJson)
        ).andExpect(status().isOk());

        verify(bookService).update(UUID.fromString("11111111-1111-1111-1111-111111111111"), new Book(null, "nouveau"));
    }
}