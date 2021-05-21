package com.example.springddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.event.inbound.ApplicationEventListeningMessageProducer;
import org.springframework.integration.event.outbound.ApplicationEventPublishingMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@SpringBootApplication
public class SpringDddApplication {

//    @Bean
//    @ServiceActivator(inputChannel = "eventChannel")
//    public ApplicationEventPublishingMessageHandler eventHandler() {
//        ApplicationEventPublishingMessageHandler handler = new ApplicationEventPublishingMessageHandler();
//        handler.setPublishPayload(true);
//        return handler;
//    }
//
//    @Bean
//    public ApplicationEventListeningMessageProducer eventsAdapter(
//            MessageChannel eventChannel, MessageChannel eventErrorChannel) {
//
//        ApplicationEventListeningMessageProducer producer =
//                new ApplicationEventListeningMessageProducer();
//        producer.setEventTypes(example.FooEvent.class, example.BarEvent.class, java.util.Date.class);
//        producer.setOutputChannel(eventChannel);
//        producer.setErrorChannel(eventErrorChannel);
//        return producer;
//    }


    public static void main(String[] args) {
        SpringApplication.run(SpringDddApplication.class, args);
    }

}
