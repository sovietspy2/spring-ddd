package com.example.springddd.service;

import com.example.springddd.customer.CustomerRepository;
import com.example.springddd.customer.domain.CustomerAddressAggregate;
import com.example.springddd.customer.domain.CustomerAggregate;
import com.example.springddd.event.CustomerNameChangeEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final ApplicationEventPublisher applicationEventPublisher;


    public CustomerAggregate getCustomer(Integer id) {
        return customerRepository.getCustomerById(1);
    }


    public void changeCustomerNameWithEvent(Integer id, String name) {
        applicationEventPublisher.publishEvent(new CustomerNameChangeEvent(this, name, id));
    }

    public void changeCustomerName(Integer id, String name) {

        CustomerAggregate customerAggregate = customerRepository.getCustomerById(id);

        customerAggregate.changeName(name);


        customerRepository.saveCustomer(customerAggregate);



    }

    public void addNewAddressToCustomer(CustomerAddressAggregate address, Integer customerId) {

        CustomerAggregate customerAggregate = customerRepository.getCustomerById(customerId);

        customerAggregate.addCustomerAddress(address);


        customerRepository.saveCustomer(customerAggregate);


    }



}
