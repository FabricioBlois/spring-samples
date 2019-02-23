package org.demo.kafka.gateway.kafka;

import lombok.RequiredArgsConstructor;
import org.demo.kafka.domain.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@RequiredArgsConstructor
public class KafkaPostman {

    private final KafkaTemplate kafkaTemplate;

    public <T extends Message> void fireEvent(final T eventMessage, final String key, final String topicName) {
        final ListenableFuture<SendResult<String, Message>> send = kafkaTemplate.send(topicName, key, eventMessage);

        send.addCallback(
                new ListenableFutureCallback<SendResult<String, Message>>() {

                    @Override
                    public void onSuccess(final SendResult<String, Message> result) {
                        System.out.println(String.format("Message successfully sent ='%s' offset='%s'", eventMessage,
                                result.getRecordMetadata().offset()));
                    }

                    @Override
                    public void onFailure(final Throwable ex) {
                        System.out.println(String.format("Failed to send message with content='%s'", eventMessage, ex));
                    }
                });
    }

}