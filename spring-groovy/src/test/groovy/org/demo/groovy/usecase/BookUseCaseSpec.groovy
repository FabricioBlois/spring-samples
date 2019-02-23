package org.demo.groovy.usecase

import org.demo.groovy.domain.Author
import org.demo.groovy.domain.Book
import org.demo.groovy.domain.api.AuthorDTO
import org.demo.groovy.domain.api.BookDTO
import org.demo.groovy.exception.BookNotFoundException
import org.demo.groovy.gateway.BookGateway
import spock.lang.Specification

import static java.time.LocalDate.parse
import static java.util.Optional.empty
import static java.util.Optional.of
import static java.util.UUID.randomUUID

class BookUseCaseSpec extends Specification {

    def bookGateway = Mock(BookGateway)
    def bookUseCase

    def setup() {
        bookUseCase = new BookUseCase(bookGateway)
    }

    def 'should get book successfully'() {
        when: 'use case is called'
        def result = bookUseCase.findById(bookId)

        then: 'check interactions'
        1 * bookGateway.findById(_ as UUID) >> of(new Book())

        and: 'check result'
        result

        where: 'input values'
        bookId       | _
        randomUUID() | _
    }

    def 'should throw exception whilst trying to get book'() {
        when: 'use case is called'
        def result = bookUseCase.findById(bookId)

        then: 'check exception'
        def exception = thrown(exceptionType)
        exception.message == String.format(exceptionMessage, bookId)

        and: 'check interactions'
        1 * bookGateway.findById(_ as UUID) >> empty()

        and: 'check result'
        !result

        where: 'input values'
        bookId       | exceptionType         | exceptionMessage
        randomUUID() | BookNotFoundException | 'Book [%s] not found'
    }

    def 'should create book successfully'() {
        given: 'author dto'
        def authorDTO = new AuthorDTO(name: authorName)

        and: 'book dto'
        def bookDTO = new BookDTO(name: bookName, author: authorDTO, pages: pages,
                publishedDate: publishedDate ? parse(publishedDate) : null)

        when: 'use case is called'
        def result = bookUseCase.create(bookDTO)

        then: 'check interactions'
        1 * bookGateway.create(_ as Book) >> new Book()

        and: 'check result'
        result

        where: 'input values'
        bookId       | bookName     | authorName         | publishedDate | pages
        randomUUID() | 'The Hobbit' | 'J. R. R. Tolkien' | '1937-09-21'  | 310
        randomUUID() | null         | ''                 | '1937-09-21'  | 310
        randomUUID() | 'The Hobbit' | null               | '1937-09-21'  | 310
    }

    def 'should update book successfully'() {
        given: 'author'
        def author = new Author(name: authorName)

        and: 'book'
        def book = new Book(id: bookId, author: author, pages: pages,
                publishedDate: publishedDate ? parse(publishedDate) : null)

        and: 'author dto'
        def authorDTO = new AuthorDTO(name: authorName)

        and: 'book dto'
        def bookDTO = new BookDTO(name: bookName, author: authorDTO, pages: pages,
                publishedDate: publishedDate ? parse(publishedDate) : null)

        when: 'use case is called'
        def result = bookUseCase.update(bookId, bookDTO)

        then: 'check interactions'
        1 * bookGateway.findById(_ as UUID) >> of(book)
        1 * bookGateway.update(_ as Book) >> new Book()

        and: 'check result'
        result

        where: 'input values'
        bookId       | bookName     | authorName         | publishedDate | pages
        randomUUID() | 'The Hobbit' | 'J. R. R. Tolkien' | '1937-09-21'  | 310
        randomUUID() | null         | ''                 | '1937-09-21'  | 310
        randomUUID() | 'The Hobbit' | null               | '1937-09-21'  | 310
    }

    def 'should throw exception whilst trying to update book'() {
        given: 'book dto'
        def bookDTO = new BookDTO()

        when: 'use case is called'
        bookUseCase.update(bookId, bookDTO)

        then: 'check exception'
        def exception = thrown(exceptionType)
        exception.message == String.format(exceptionMessage, bookId)

        and: 'check interactions'
        1 * bookGateway.findById(_ as UUID) >> empty()
        0 * bookGateway.update(_ as Book)

        where: 'input values'
        bookId       | exceptionType         | exceptionMessage
        randomUUID() | BookNotFoundException | 'Book [%s] not found'
    }

    def 'should delete book successfully'() {
        given: 'author'
        def author = new Author(name: authorName)

        and: 'book'
        def book = new Book(id: bookId, name: bookName, author: author,
                publishedDate: publishedDate ? parse(publishedDate) : null)

        when: 'use case is called'
        bookUseCase.delete(bookId)

        then: 'check interactions'
        1 * bookGateway.findById(_ as UUID) >> of(book)
        1 * bookGateway.delete(_ as Book)

        where: 'input values'
        bookId       | bookName     | authorName         | publishedDate | pages
        randomUUID() | 'The Hobbit' | 'J. R. R. Tolkien' | '1937-09-21'  | 310
    }

    def 'should throw exception whilst trying to delete book'() {
        when: 'use case is called'
        bookUseCase.delete(bookId)

        then: 'check exception'
        def exception = thrown(exceptionType)
        exception.message == String.format(exceptionMessage, bookId)

        and: 'check interactions'
        1 * bookGateway.findById(_ as UUID) >> empty()
        0 * bookGateway.delete(_ as Book)

        where: 'input values'
        bookId       | exceptionType         | exceptionMessage
        randomUUID() | BookNotFoundException | 'Book [%s] not found'
    }

}
