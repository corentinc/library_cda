package com.greta.cda.library.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "author_books")
@Data
@NoArgsConstructor
public class AuthorBook {
    @Id
    private AuthorBookPk id;
    private LocalDate releaseDate;

    @Embeddable
    @Data
    @NoArgsConstructor
    public class AuthorBookPk implements Serializable {
        @Column(name = "author_id")
        private UUID authorId;
        @Column(name = "books_id")
        private UUID bookId;
    }
}
