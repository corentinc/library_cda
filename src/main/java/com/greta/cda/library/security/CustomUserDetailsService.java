package com.greta.cda.library.security;

import com.greta.cda.library.domain.Person;
import com.greta.cda.library.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        1/ chercher notre Person via son login
        Person person = personRepository.findPersonByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException(login));

        //        2/ transforme notre Person en UserDetails
        UserDetails userDetails = User.builder()
                .username(person.getLogin())
                .password(person.getPassword())
                .roles(person.getRole())
                .build();

//        3/ on le retourne
        return userDetails;
    }
}
