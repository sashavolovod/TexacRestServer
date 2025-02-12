package gefest.rest.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ApiResponse {
    private LocalDateTime timestamp;
    private String message;
}