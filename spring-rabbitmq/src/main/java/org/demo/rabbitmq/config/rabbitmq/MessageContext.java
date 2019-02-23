package org.demo.rabbitmq.config.rabbitmq;

import lombok.AllArgsConstructor;
import org.demo.rabbitmq.config.rabbitmq.mapping.RabbitMQConfigProperties.Binding;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public final class MessageContext {

    private Binding binding;
    private Map<String, Object> properties;
    private Object message;

    public MessageContext(final Object message, final Binding binding) {
        this.message = message;
        this.binding = binding;
        this.properties = new HashMap<>();
    }

    public Binding getRabbitMQBiding() {
        return binding;
    }

    public MessageProperties getProperties() {
        final MessagePropertiesBuilder messagePropertiesBuilder = MessagePropertiesBuilder.newInstance();
        properties.forEach(messagePropertiesBuilder::setHeader);
        return messagePropertiesBuilder.build();
    }

    public Object getMessage() {
        return message;
    }

}