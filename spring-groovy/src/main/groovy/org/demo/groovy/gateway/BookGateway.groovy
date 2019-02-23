package org.demo.groovy.gateway

import org.demo.groovy.domain.Book
import org.demo.groovy.gateway.data.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookGateway {

    BookRepository bookRepository

    @Autowired
    BookGateway(BookRepository bookRepository) {
        this.bookRepository = bookRepository
    }

    Optional<Book> findById(UUID id) {
        bookRepository.findById(id)
    }

    Book create(Book book) {
        bookRepository.save(book)
    }

    Book update(Book book) {
        bookRepository.save(book)
    }

    void delete(Book book) {
        bookRepository.delete(book)
    }

}
