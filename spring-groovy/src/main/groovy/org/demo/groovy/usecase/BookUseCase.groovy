package org.demo.groovy.usecase

import org.demo.groovy.domain.Author
import org.demo.groovy.domain.Book
import org.demo.groovy.domain.api.BookDTO
import org.demo.groovy.exception.BookNotFoundException
import org.demo.groovy.gateway.BookGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static java.lang.String.format
import static java.util.UUID.randomUUID

@Service
class BookUseCase {

    BookGateway bookGateway

    @Autowired
    BookUseCase(BookGateway bookGateway) {
        this.bookGateway = bookGateway
    }

    Book findById(UUID id) {
        bookGateway
                .findById(id)
                .orElseThrow({
            new BookNotFoundException(format('Book [%s] not found', id))
        })
    }

    Book create(BookDTO bookDTO) {
        def author = new Author(name: bookDTO.getAuthor().getName())
        def book = new Book(id: randomUUID(), name: bookDTO.getName(), author: author,
                publishedDate: bookDTO.getPublishedDate(), pages: bookDTO.getPages())
        bookGateway.create(book)
    }

    Book update(UUID id, BookDTO bookDTO) {
        def book = findById(id)
        book.getAuthor().setName(bookDTO.getAuthor().getName())
        book.setName(bookDTO.getName())
        book.setPublishedDate(bookDTO.getPublishedDate())
        book.setPages(bookDTO.getPages())
        bookGateway.update(book)
    }

    void delete(UUID id) {
        def book = findById(id)
        bookGateway.delete(book)
    }

}
