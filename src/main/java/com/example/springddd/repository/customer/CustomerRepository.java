package com.example.springddd.repository.customer;

import com.example.springddd.domain.customer.CustomerAddress;
import com.example.springddd.domain.customer.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerRepository {

    private final CustomerDAO customerDAO;

    public Customer getCustomerById(Integer id) {

        CustomerProjection customerProjection = customerDAO.findById(id).orElseThrow();

        Set<CustomerAddress> customerAddress = customerProjection
                .getAddresses()
                .stream()
                .map(item -> CustomerAddress.builder()
                        .city(item.getCity())
                        .street(item.getStreet())
                        .zip(item.getZip())
                        .build()).collect(Collectors.toSet());


        Customer customer = Customer.builder()
                .name(customerProjection.getName())
                .id(customerProjection.getId())
                .customerAddresses(customerAddress)
                .build();

        return customer;
    }

    public void saveCustomer(Customer customer) {

        CustomerProjection customerProjection = customerDAO.findById(customer.getId()).orElseThrow();

        customerProjection.setName(customer.getName());

        customerProjection.setAddresses(customer.getCustomerAddresses().stream().map(item ->
                CustomerAddressProjection.builder()
                        .city(item.getCity())
                        .zip(item.getZip())
                        .street(item.getStreet())
                        .build()).collect(Collectors.toSet()));

        customerProjection.setModDate(new Date());

        customerDAO.save(customerProjection);
    }


}
