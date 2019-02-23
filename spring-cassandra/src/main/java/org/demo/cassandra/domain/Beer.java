package org.demo.cassandra.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Beer implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKeyColumn(type = PARTITIONED)
    private String name;

    private String type;

}