package org.demo.kafka.gateway;

import lombok.RequiredArgsConstructor;
import org.demo.kafka.config.kafka.KafkaProperties;
import org.demo.kafka.domain.Beer;
import org.demo.kafka.gateway.kafka.KafkaPostman;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeerGateway {

    private final KafkaProperties kafkaProperties;
    private final KafkaPostman kafkaPostman;

    public void publish(final Beer beer) {
        kafkaPostman.fireEvent(beer, beer.getName(), kafkaProperties.getTopics().getBeer());
    }

}