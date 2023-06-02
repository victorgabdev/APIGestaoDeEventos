package com.victorgabriel.eventos.shared.validations;

import java.util.regex.Pattern;

public class ValidationUtils {
    public static boolean validateEmail(String email) {
        String patternEmail = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-" +
                "]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";

        return Pattern.compile(patternEmail).matcher(email).matches();
    }
}
