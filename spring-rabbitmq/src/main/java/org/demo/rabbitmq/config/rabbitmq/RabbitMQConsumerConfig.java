package org.demo.rabbitmq.config.rabbitmq;

import lombok.RequiredArgsConstructor;
import org.demo.rabbitmq.config.rabbitmq.mapping.RabbitMQConfigProperties;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.retry.RejectAndDontRequeueRecoverer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMQConsumerConfig {

    private final ConnectionFactory connectionFactory;

    @Bean
    public RabbitAdmin rabbitAdmin(final ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(final RabbitMQConfigProperties configurationProperties) {
        final SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrentConsumers(configurationProperties.getConfig().getConsumers());
        factory.setDefaultRequeueRejected(false);
        factory.setAdviceChain(RetryInterceptorBuilder
                .stateless()
                .recoverer(new RejectAndDontRequeueRecoverer())
                .maxAttempts(configurationProperties.getConfig().getRetries())
                .build());

        return factory;
    }

}