package org.demo.groovy.gateway.data

import org.demo.groovy.domain.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository extends CrudRepository<Book, UUID> {

}