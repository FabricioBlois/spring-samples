package org.demo.groovy.domain.api

import groovy.transform.Canonical

import javax.validation.constraints.NotEmpty

@Canonical
class AuthorDTO {

    @NotEmpty
    String name

}
