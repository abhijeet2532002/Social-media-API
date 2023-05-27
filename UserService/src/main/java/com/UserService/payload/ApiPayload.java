package com.UserService.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiPayload {
    private String msg;
    private Boolean status;
    private HttpStatus httpStatus;
}
