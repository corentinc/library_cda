package com.greta.cda.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Représente un Livre
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    @Id
    @Column(length = 36)
    @org.hibernate.annotations.Type(type="uuid-char")
    private UUID id;
    private String name;
    @ManyToOne
    private Author author;
    @ManyToMany
    private List<Genre> genreList;

    public Book(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
