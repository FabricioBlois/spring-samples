package org.demo.groovy.domain.api

import groovy.transform.Canonical

import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
import java.time.LocalDate

@Canonical
class BookDTO {

    @NotEmpty
    String name

    @NotNull
    @Valid
    AuthorDTO author

    @NotNull
    LocalDate publishedDate

    @NotNull
    @Size(min = 1)
    Integer pages

}
