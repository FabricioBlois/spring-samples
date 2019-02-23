package org.demo.kafka.config.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaProperties {

    private Topics topics;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Topics {

        private String beer;

    }

}