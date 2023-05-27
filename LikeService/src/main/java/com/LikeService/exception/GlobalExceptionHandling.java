package com.LikeService.exception;

import com.LikeService.payload.ApiPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiPayload> handlerResponseNotFoundException(ResourceNotFoundException ex) {
        String msg = ex.getMessage();
        ApiPayload payload = ApiPayload.builder().msg(msg).status(true).httpStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiPayload>(payload,HttpStatus.NOT_FOUND);
    }
}
