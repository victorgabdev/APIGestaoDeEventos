package com.victorgabriel.eventos.shared.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApplicationErrors {

    private String message;
    private int status;
    private LocalDateTime timestamp;
}
