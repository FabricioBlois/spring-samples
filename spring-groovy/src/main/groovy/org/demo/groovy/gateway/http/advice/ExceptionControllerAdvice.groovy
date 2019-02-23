package org.demo.groovy.gateway.http.advice

import org.demo.groovy.domain.error.ErrorResponse
import org.demo.groovy.exception.BookNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

import static org.springframework.http.HttpStatus.NOT_FOUND

@ControllerAdvice
class ExceptionControllerAdvice {

    @ResponseBody
    @ExceptionHandler(BookNotFoundException.class)
    ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException bookNotFoundException) {
        return new ResponseEntity<>(new ErrorResponse(message: bookNotFoundException.getMessage()), NOT_FOUND)
    }

}
