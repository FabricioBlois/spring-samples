package org.demo.rabbitmq.config.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.demo.rabbitmq.config.rabbitmq.mapping.RabbitMQConfigProperties.Binding;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMQPublish {

    private final RabbitTemplate template;
    private final ObjectMapper objectMapper;

    public void enqueue(final MessageContext context) {
        final Binding binding = context.getRabbitMQBiding();
        final String json = stringifyRabbitMessage(context.getMessage());
        final Message message = template.getMessageConverter().toMessage(json, getProperties(context));

        template.send(binding.getTopic(), binding.getRoutingKey(), message);
    }

    private String stringifyRabbitMessage(final Object data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return data.toString();
    }

    private MessageProperties getProperties(final MessageContext context) {
        return MessagePropertiesBuilder
                .fromProperties(context.getProperties())
                .build();
    }

}