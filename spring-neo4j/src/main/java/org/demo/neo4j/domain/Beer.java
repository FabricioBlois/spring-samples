package org.demo.neo4j.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class Beer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String type;
    private String name;

    @Relationship(type = "USED_IN", direction = INCOMING)
    private Water water;

    @Relationship(type = "USED_IN", direction = INCOMING)
    private List<Malt> malts;

    @Relationship(type = "USED_IN", direction = INCOMING)
    private List<Hop> hops;

    @Relationship(type = "USED_IN", direction = INCOMING)
    private Yeast yeast;

}