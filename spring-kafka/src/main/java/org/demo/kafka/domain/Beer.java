package org.demo.kafka.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Beer implements Message {

    private static final long serialVersionUID = 1L;

    private String name;
    private String type;

}