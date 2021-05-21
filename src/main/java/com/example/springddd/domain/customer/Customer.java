package com.example.springddd.domain.customer;


import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class Customer {

    private String name;

    private final Integer id;

    private final Set<CustomerAddress> customerAddresses;

    public void changeName(String name) {
        // validations
        //idk

        this.name = name;
    }

    private void removeAddress(CustomerAddress address) {

        // logic


        customerAddresses.remove(address);
    }

    public void addCustomerAddress(CustomerAddress address) {

        // logic

        if (this.customerAddresses.contains(address)) {
            throw new IllegalArgumentException("Address already exists on the customer!");
        }

        this.customerAddresses.add(address);


    }

}
