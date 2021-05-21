package com.example.springddd.service;

import com.example.springddd.repository.customer.CustomerRepository;
import com.example.springddd.domain.customer.CustomerAddress;
import com.example.springddd.domain.customer.Customer;
import com.example.springddd.event.CustomerNameChangeEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final ApplicationEventPublisher applicationEventPublisher;


    public Customer getCustomer(Integer id) {
        return customerRepository.getCustomerById(1);
    }


    public void changeCustomerNameWithEvent(Integer id, String name) {
        applicationEventPublisher.publishEvent(new CustomerNameChangeEvent(this, name, id));
    }

    @Transactional
    public void changeCustomerName(Integer id, String name) {

        Customer customer = customerRepository.getCustomerById(id);

        customer.changeName(name);


        customerRepository.saveCustomer(customer);

        applicationEventPublisher.publishEvent(new CustomerNameChangeEvent(this, name, customer.getId()));
    }

    public void addNewAddressToCustomer(CustomerAddress address, Integer customerId) {

        Customer customer = customerRepository.getCustomerById(customerId);

        customer.addCustomerAddress(address);


        customerRepository.saveCustomer(customer);


    }



}
