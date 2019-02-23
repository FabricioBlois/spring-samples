package org.demo.rabbitmq.config.rabbitmq.mapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "rabbit.mappings")
public class RabbitMQConfigProperties {

    private List<Binding> bindings;
    private Config config;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Binding {

        private String topic;
        private String routingKey;
        private String queue;
        private boolean declare;
        private Integer ttl;
        private String deadLetterRoutingKey;
        private String deadLetterExchange;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Config {

        private Integer initialInterval;
        private Integer maxInterval;
        private Integer multiplier;
        private Integer retries;
        private Integer consumers;

    }

    public Optional<Binding> getQueueByName(final String queue) {
        return bindings
                .stream()
                .filter(binding -> binding.getQueue().equals(queue))
                .findFirst();
    }

}