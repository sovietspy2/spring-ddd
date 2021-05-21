package com.example.springddd.customer;

import com.example.springddd.customer.domain.CustomerAddressAggregate;
import com.example.springddd.customer.domain.CustomerAggregate;
import com.example.springddd.customer.model.CustomerAddressProjection;
import com.example.springddd.customer.model.CustomerProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerRepository {

    private final CustomerDAO customerDAO;

    public CustomerAggregate getCustomerById(Integer id) {

        CustomerProjection customerProjection = customerDAO.findById(id).orElseThrow();

        Set<CustomerAddressAggregate> customerAddressAggregate = customerProjection.getAddresses().stream().map(item -> {
            return CustomerAddressAggregate.builder()
                    .city(item.getCity())
                    .street(item.getStreet())
                    .zip(item.getZip())
                    .build();
        }).collect(Collectors.toSet());


        CustomerAggregate customerAggregate = CustomerAggregate.builder()
                .name(customerProjection.getName())
                .id(customerProjection.getId())
                .customerAddresses(customerAddressAggregate)
                .build();

        return customerAggregate;
    }

    public void saveCustomer(CustomerAggregate customer) {

        CustomerProjection customerProjection = customerDAO.findById(customer.getId()).orElseThrow();

        customerProjection.setName(customer.getName());

        customerProjection.setAddresses(customer.getCustomerAddresses().stream().map(item -> {
            return CustomerAddressProjection.builder()
                    .city(item.getCity())
                    .zip(item.getZip())
                    .street(item.getStreet())
                    .build();
        }).collect(Collectors.toSet()));

        customerProjection.setModDate(new Date());

        customerDAO.save(customerProjection);
    }


}
