package org.demo.couchdb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.couchbase.core.mapping.Document;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Beer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String type;
    private String name;

}