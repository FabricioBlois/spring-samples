package org.demo.rabbitmq.gateway;

import org.demo.rabbitmq.domain.Message;

public interface BeerGateway {

    <T extends Message> void publish(T message, String queueName);

}