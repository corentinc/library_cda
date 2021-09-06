package com.greta.cda.library.service;

import com.greta.cda.library.domain.Person;
import com.greta.cda.library.dto.SignUp;
import com.greta.cda.library.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void signUp(SignUp signUp) {
        Person person = Person.builder()
                .id(UUID.randomUUID())
                .login(signUp.getLogin())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role("USER")
                .build();
        personRepository.save(person);
        logger.info("New subscription : login={}", person.getLogin());
    }

}
