package org.demo.rabbitmq.domain.exception;

public class QueueNotFoundException extends RuntimeException {

    public QueueNotFoundException(final String message) {
        super(message);
    }

}