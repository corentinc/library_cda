package com.greta.cda.library.controller;

import com.greta.cda.library.dto.LoginDto;
import com.greta.cda.library.security.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/auth")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    loginDto.getLogin(), loginDto.getPassword()
                            )
                    );

            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.AUTHORIZATION,
                            jwtUtil.generateJwtToken(authenticate)
                    )
                    .build();
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
