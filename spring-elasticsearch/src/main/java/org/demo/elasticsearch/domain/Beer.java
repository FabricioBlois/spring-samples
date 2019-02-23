package org.demo.elasticsearch.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "beer")
public class Beer {

    @Id
    private String id;

    @Field(type = Text)
    private String type;

    @Field(type = Text)
    private String name;

}