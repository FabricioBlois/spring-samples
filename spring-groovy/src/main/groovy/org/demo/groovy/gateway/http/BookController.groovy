package org.demo.groovy.gateway.http

import org.demo.groovy.domain.Book
import org.demo.groovy.domain.api.BookDTO
import org.demo.groovy.usecase.BookUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

import static org.springframework.http.HttpStatus.*
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@RestController
@RequestMapping(path = '/api/v1/')
class BookController {

    BookUseCase bookUseCase

    @Autowired
    BookController(BookUseCase bookUseCase) {
        this.bookUseCase = bookUseCase
    }

    @ResponseStatus(OK)
    @GetMapping(value = '/books/{id}', produces = APPLICATION_JSON_VALUE)
    Book findById(@PathVariable UUID id) {
        bookUseCase.findById(id)
    }

    @ResponseStatus(CREATED)
    @PostMapping(value = '/books', consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    Book create(@Valid @RequestBody BookDTO bookDTO) {
        bookUseCase.create(bookDTO)
    }

    @ResponseStatus(OK)
    @PutMapping(value = '/books/{id}', consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    Book update(@PathVariable UUID id, @Valid @RequestBody BookDTO bookDTO) {
        bookUseCase.update(id, bookDTO)
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(value = '/books/{id}')
    void delete(@PathVariable UUID id) {
        bookUseCase.delete(id)
    }

}