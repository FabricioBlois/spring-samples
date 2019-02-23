package org.demo.rabbitmq.gateway.impl;

import lombok.RequiredArgsConstructor;
import org.demo.rabbitmq.config.rabbitmq.MessageContext;
import org.demo.rabbitmq.config.rabbitmq.RabbitMQPublish;
import org.demo.rabbitmq.config.rabbitmq.mapping.RabbitMQConfigProperties;
import org.demo.rabbitmq.config.rabbitmq.mapping.RabbitMQConfigProperties.Binding;
import org.demo.rabbitmq.domain.Message;
import org.demo.rabbitmq.domain.exception.QueueNotFoundException;
import org.demo.rabbitmq.gateway.BeerGateway;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
@RequiredArgsConstructor
public class BeerGatewayImpl implements BeerGateway {

    private final RabbitMQPublish rabbitMQPublish;
    private final RabbitMQConfigProperties rabbitMQConfigProperties;

    @Override
    public <T extends Message> void publish(final T message, final String queueName) {
        final Binding binding = rabbitMQConfigProperties
                .getQueueByName(queueName)
                .orElseThrow(() -> new QueueNotFoundException(format("Unable to find queue: '%s'", queueName)));

        rabbitMQPublish.enqueue(new MessageContext(message, binding));
    }

}