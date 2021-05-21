package com.example.springddd.handlers.customer;

import com.example.springddd.customer.CustomerRepository;
import com.example.springddd.event.CustomerNameChangeEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerEvenHandlers {

    private final CustomerRepository customerRepository;

    @EventListener
    private void handleCustomerNameChange(CustomerNameChangeEvent event) {


        System.out.println("asd");
    }


}
