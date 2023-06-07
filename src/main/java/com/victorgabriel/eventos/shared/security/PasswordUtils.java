package com.victorgabriel.eventos.shared.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

    public static String encode(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    public static boolean matches(String rawPassword, String encodePassword) {
        return new BCryptPasswordEncoder().matches(rawPassword, encodePassword);
    }
}
