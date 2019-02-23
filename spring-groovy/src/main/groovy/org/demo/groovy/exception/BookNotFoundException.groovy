package org.demo.groovy.exception

class BookNotFoundException extends RuntimeException {

    BookNotFoundException(String message) {
        super(message)
    }

}