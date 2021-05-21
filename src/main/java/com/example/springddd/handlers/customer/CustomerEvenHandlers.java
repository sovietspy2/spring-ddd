package com.example.springddd.handlers.customer;

import com.example.springddd.repository.customer.CustomerRepository;
import com.example.springddd.event.CustomerNameChangeEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomerEvenHandlers {

    //private final CustomerRepository customerRepository;

    @EventListener
    private void handleCustomerNameChange(CustomerNameChangeEvent event) {

        // some logic

        log.info("User changed his name");


    }


}
