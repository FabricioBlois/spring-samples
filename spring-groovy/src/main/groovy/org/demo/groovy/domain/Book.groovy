package org.demo.groovy.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalDate

@Document
class Book {

    @Id
    UUID id

    String name
    Author author
    LocalDate publishedDate
    Integer pages

}