package org.demo.kafka.gateway.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.demo.kafka.domain.Beer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeerListener {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "${spring.kafka.topics.beer}", groupId = "${spring.kafka.consumer.group-id}")
    public void execute(final String message) {
        try {
            final Beer beer = objectMapper.readValue(message, Beer.class);
            System.out.println(beer.getName());
        } catch (final Exception exception) {
            System.out.println(String.format("An error has occurred whilst deserialize the message - %s", exception));
        }
    }

}