package com.greta.cda.library.repository;

import com.greta.cda.library.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    Optional<Person> findPersonByLogin(String login);
}
