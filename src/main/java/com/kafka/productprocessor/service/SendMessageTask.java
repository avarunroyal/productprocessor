package com.kafka.productprocessor.service;

import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class SendMessageTask {
    private final Logger logger =  LoggerFactory.getLogger(SendMessageTask.class);


    private final Producer producer;

    public SendMessageTask(Producer producer) {
        this.producer = producer;
    }

    // run every 10 sec
    @Scheduled(fixedRateString = "10000")
    public void send() throws ExecutionException, InterruptedException {

        ListenableFuture<SendResult<String, String>> listenableFuture = this.producer.sendMessage("PRODUCT_DATA", "IN_KEY", LocalDate.now().toString());

        SendResult<String, String> result = listenableFuture.get();
        logger.info(String.format("Produced:\ntopic: %s\noffset: %d\npartition: %d\nvalue size: %d", result.getRecordMetadata().topic(),
                result.getRecordMetadata().offset(),
                result.getRecordMetadata().partition(), result.getRecordMetadata().serializedValueSize()));
    }
}
