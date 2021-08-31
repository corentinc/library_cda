package com.greta.cda.library.exception;

import java.util.UUID;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(UUID id) {
        super("Aucun livre trouvé avec le UUID : " + id.toString());
    }
}
