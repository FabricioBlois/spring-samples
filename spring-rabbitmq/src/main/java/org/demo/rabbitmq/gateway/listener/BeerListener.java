package org.demo.rabbitmq.gateway.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.demo.rabbitmq.domain.Beer;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class BeerListener {

    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "ha.input.beer")
    public void dequeue(final Message message) {
        try {
            final Beer beer = objectMapper.readValue(message.getPayload().toString(), Beer.class);
            System.out.println(beer.getName() + " : " + beer.getType());
        } catch (final IOException exception) {
            throw new AmqpRejectAndDontRequeueException(exception.getMessage(), exception);
        }
    }

}